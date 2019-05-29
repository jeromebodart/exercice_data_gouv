package ProjetApplication.CreationSireneUpdatesOnly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

import com.example.domain.entreprise.CaracteristiquesEconomiquesEntreprise;
import com.example.domain.entreprise.Entreprise;
import com.example.domain.entreprise.IdentificationEntreprise;
import com.example.domain.entreprise.InformationsSiege;
import com.example.domain.etablissement.AdresseDeclaree;
import com.example.domain.etablissement.AdresseGeographique;
import com.example.domain.etablissement.AdresseNormalisee;
import com.example.domain.etablissement.CaracteristiquesEconomiquesEtablissement;
import com.example.domain.etablissement.Etablissement;
import com.example.domain.etablissement.Informations;
import com.example.domain.etablissement.Localisation;
import com.example.domain.etablissement.MiseAJour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jbodart
 * This app aim at creating a new version of the database which will be called sirene_only_updates. For this we are going to 
 * - add a SIRET fro each row
 * - remove outdated data using the timestamp present in the last column and entitle datemaj
 * 
 * To realise this we execute two querry for each row read for the csv of the database
 * ==> If the data (siren and nic) is not present (query_1) we simply insert it into the database 
 * ==> EITHER we check if the current row has a more recent timestamp than the one in the database. If so we update the database.
 *
 */
@SpringBootApplication
public class CreationSireneUpdatesOnlyApplication {

	/**
	 * @Connection to database
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:postgresql://localhost:5432/SIRENE";
			String user = "postgres";
			String passwd = "azerty";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");         
			//	        https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26543-fouillez-dans-la-base-de-donnees
			//			//On crée la requête
			//		      String query = "INSERT INTO ? (prof_nom, prof_prenom) VALUES('SALMON', 'Dylan')";
			//			state.executeUpdate("INSERT INTO professeur (prof_nom, prof_prenom) VALUES('SALMON', 'Dylan')");
			try {
				//Create a file chooser
				final  JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				//In response to a button click:
				int returnVal = fc.showOpenDialog(null);
				File file = null;
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					//Now you have your file to do whatever you want to do
				} else {
					//User did not choose a valid file
				}
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				boolean first_line=true;
				String query_1 = "SELECT datemaj FROM sirene_only_updates";
				query_1 += " WHERE siren = ?";
				query_1 += " AND nic = ?";
				System.out.println(query_1);
				//On crée l'objet avec la requête en paramètre
				PreparedStatement preparedStatement = conn.prepareStatement(
						query_1, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY
						);
//				Ici on met 101 valeur (on ajoutera la colonne siret)
				String query_2 = "INSERT INTO sirene_only_updates VALUES (";
				for(int i=0; i<100; i++) {
					query_2+="?, ";
				}
				query_2+="?)";
				System.out.println(query_2);
				PreparedStatement preparedStatement_2 = conn.prepareStatement(
						query_2, 
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY
						);
				//			LinkedList<String> lList = new LinkedList<String>();
				//				int n_informationsSiege = 1;
				while ((line = br.readLine()) != null) {
					LinkedList<String> lList = stringToMultipleElementsLinklist(line);
					//				lList.forEach((element) -> {
					//					out.print(element);
					//					out.print(";");
					//				});
					//				out.print("\n");
					if(first_line) {
						System.out.println("***************************************************");
						System.out.println("First line skipped");
						System.out.println("***************************************************");
						first_line=false;
					}
					else
					{	
						String siren = String.format("%09d", Integer.parseInt(lList.get(0)));
						System.out.println(siren);
						preparedStatement.setString(1, siren);
						String nic = String.format("%05d", Integer.parseInt(lList.get(1)));
						System.out.println(nic);
						preparedStatement.setString(2,  nic);
						System.out.println(preparedStatement.toString());
						System.out.println("***************************************************");
						ResultSet rs = preparedStatement.executeQuery();
						//						‪C:\Users\jbodart\Desktop\PROJET\sirene_201904_L_M\voir.csv
						//						https://docs.oracle.com/javase/6/docs/api/java/sql/ResultSet.html#next%28%29
						boolean to_insert_in_database = false;
						if(!rs.next())
						{
							System.out.println("Non présent en base");
							to_insert_in_database = true;
						} else {
							System.out.println("Déjà présent en base");
							System.out.println("Comparaison des timestamp");
							String pattern = "\\D";
							Pattern p = Pattern.compile(pattern);
							System.out.println(rs.getString("datemaj"));
							System.out.println(rs.getString("datemaj").toString());
							int[] date = StringArrayToIntArray(p.split(rs.getString("datemaj").toString()));
							GregorianCalendar date_bdd = new GregorianCalendar(date[0], date[1], date[2], date[3], date[4],date[5]);
							int[] date_csv = StringArrayToIntArray(p.split(lList.get(99).toString()));
							GregorianCalendar current_date = new GregorianCalendar(date_csv[0], date_csv[1], date_csv[2], date_csv[3], date_csv[4], date_csv[5]);
							//							Nothing to do if the date in the database is more recent
							if (date_bdd.compareTo(current_date) < 0 ) {to_insert_in_database = true;} 
						}
						if(to_insert_in_database) { 
							constitutionInsertQuery(preparedStatement_2, lList, siren, nic);
							System.out.println(preparedStatement_2);
							preparedStatement_2.executeUpdate();		
						}
						rs.close();
					}
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				System.out.println("C fini");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void constitutionInsertQuery(PreparedStatement preparedStatement_2, LinkedList<String> lList, String siren, String nic) throws SQLException {
		// TODO Auto-generated method stub
		////	Il faut appliquer le bon format pour chaque donnée
		preparedStatement_2.setString(1, siren + nic);
		preparedStatement_2.setString(2, siren);
		preparedStatement_2.setString(3, nic);
		for(int i=4; i<102; i++) {
			preparedStatement_2.setString(i, lList.get(i-2).toString());
		}
	}
	public static int[] StringArrayToIntArray(String[] ArrayOfString) {
		int[] results = new int[ArrayOfString.length];
		for (int i = 0; i < ArrayOfString.length; i++) {
			try {
				results[i] = Integer.parseInt(ArrayOfString[i]);
			} catch (NumberFormatException nfe) {
				//NOTE: write something here if you need to recover from formatting errors
			}
		}
		return results;
	}

	public static String SIRET(LinkedList<String> lList) {
		int SIREN = Integer.parseInt(lList.get(0));
		int NIC  = Integer.parseInt(lList.get(1));
		int siret = SIREN + NIC;
		return Integer.toString(siret);
	}
	public static LinkedList<String> stringToMultipleElementsLinklist(String s) {
		// convert array to LinkedList
		//		System.out.println(s);
		String[] str = s.split(";");
		//		System.out.println(str);
		LinkedList<String> listStrings = new LinkedList<String>();
		for (String element : str) {
			listStrings.add(element.replaceAll("\"", ""));
		}
		return listStrings;
	}
}
