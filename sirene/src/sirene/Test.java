package sirene;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;

public class Test {
	//	C:\Users\jbodart\Desktop\sirc-17804_9075_61173_201904_L_M_20190501_015252595.csv
//	https://stackoverflow.com/questions/19177994/java-read-file-and-split-into-multiple-files
	public static void main(String[] args) throws Exception
	{
//		RandomAccessFile raf = new RandomAccessFile("test.csv", "r");
		//		Create a file chooser
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
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		long numSplits = 20; //from user input, extract it from args
		long sourceSize = raf.length();
		long bytesPerSplit = sourceSize/numSplits ;
		long remainingBytes = sourceSize % numSplits;

		int maxReadBufferSize = 8 * 1024; //8KB
		for(int destIx=1; destIx <= numSplits; destIx++) {
			BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("C:\\Users\\jbodart\\Desktop\\bdd\\split."+destIx));
			if(bytesPerSplit > maxReadBufferSize) {
				long numReads = bytesPerSplit/maxReadBufferSize;
				long numRemainingRead = bytesPerSplit % maxReadBufferSize;
				for(int i=0; i<numReads; i++) {
					readWrite(raf, bw, maxReadBufferSize);
				}
				if(numRemainingRead > 0) {
					readWrite(raf, bw, numRemainingRead);
				}
			}else {
				readWrite(raf, bw, bytesPerSplit);
			}
			bw.close();
		}
		if(remainingBytes > 0) {
			BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split."+(numSplits+1)));
			readWrite(raf, bw, remainingBytes);
			bw.close();
		}
		raf.close();
	}

	static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
		byte[] buf = new byte[(int) numBytes];
		int val = raf.read(buf);
		if(val != -1) {
			bw.write(buf);
		}
	}
	//	public static void main(String[] args) throws IOException {
	//		
	//		// TODO Auto-generated method stub
	//		BufferedReader br;
	//		FileWriter fw = new FileWriter("C:\\Users\\jbodart\\Desktop\\WriteTest.csv");
	//		PrintWriter out = new PrintWriter(fw);
	//		try {
	//			Class.forName("org.postgresql.Driver");
	//
	//			String url = "jdbc:postgresql://localhost:5432/Ecole";
	//			String user = "postgres";
	//			String passwd = "azerty";
	//
	//			Connection conn = DriverManager.getConnection(url, user, passwd);
	//			conn.setAutoCommit(false);
	//			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	//			//	        https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26543-fouillez-dans-la-base-de-donnees
	//			//			//On crée la requête
	//			//		      String query = "INSERT INTO ? (prof_nom, prof_prenom) VALUES('SALMON', 'Dylan')";
	//			//			state.executeUpdate("INSERT INTO professeur (prof_nom, prof_prenom) VALUES('SALMON', 'Dylan')");
	//			try {
	//				//Create a file chooser
	//				final  JFileChooser fc = new JFileChooser();
	//				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	//				//In response to a button click:
	//				int returnVal = fc.showOpenDialog(null);
	//				File file = null;
	//				if (returnVal == JFileChooser.APPROVE_OPTION) {
	//					file = fc.getSelectedFile();
	//					//Now you have your file to do whatever you want to do
	//				} else {
	//					//User did not choose a valid file
	//				}
	//				br = new BufferedReader(new FileReader(file));
	//				String line;
	//				boolean first_line=true;
	//				//			LinkedList<String> lList = new LinkedList<String>();
	//				int n_informationsSiege = 1;
	//				while ((line = br.readLine()) != null) {
	//					LinkedList<String> lList = stringToMultipleElementsLinklist(line);
	//					if(first_line) {
	//						System.out.println(lList);
	//						System.out.println("***************************************************");
	//						first_line=false;
	//						lList.add(1,"id_siege");
	//						lList.add(2,"id_identification_entreprise");
	//						lList.add(3,"id_caracteristiques");
	//						lList.add(4,"SIRET");
	//						lList.add(5,"id_siren");
	//						lList.add(7,"id_adresse_declaree");
	//						lList.add(8,"id_adresse_normalisee");
	//						lList.add(9,"id_info");
	//						lList.add(10,"id_adresse_geographique");
	//						lList.add(11,"id_localisation_geographique");
	//						lList.add(12,"id_caracteristiques_economiques");
	//						lList.add(13,"id_updates");
	//						lList.add(14,"id");
	//						lList.add(22,"id");
	//						lList.add(30,"id");
	//						lList.add(37,"id");
	//						lList.add(51,"id");
	//						lList.add(57,"id");
	//						lList.add(78,"id");
	//						lList.add(85,"id");
	//						lList.add(90,"id");
	//						lList.add(116,"id");
	//						System.out.println(lList);
	//					}
	//					else
	//					{	
	//						//					System.out.println("66");
	//						//					System.out.println(lList.get(66).toString());
	//						//					System.out.println("67");
	//						//					System.out.println(lList.get(67).toString());
	//						//					System.out.println("68");
	//						//					System.out.println(lList.get(68).toString());
	//						//					System.out.println("66_bis");
	//						//					System.out.println(Integer.parseInt(lList.get(66)));
	//						//					System.out.println("67_bis");
	//						//					System.out.println(Integer.parseInt(lList.get(67)));
	//						//					System.out.println("68_bis");
	//						//					System.out.println(Integer.parseInt(lList.get(68)));
	//
	//						InformationsSiege informationsSiege = new InformationsSiege(lList.get(66), lList.get(67), lList.get(68), lList.get(69));
	//					     //L'objet ResultSet contient le résultat de la requête SQL
	//					      ResultSet result = state.executeQuery("SELECT (n_informationsSiege, nic, code_region, departement_commune, email) FROM info_siege WHERE nic=? AND code_region=? AND departement_commune=? AND email=? LIMIT 1");
	//					      if(result == null) {
	//								String query = "INSERT INTO info_siege (n_informationsSiege, nic, code_region, departement_commune, email) VALUES(?, ?, ?, ?, ?)";
	//								//On crée l'objet avec la requête en paramètre
	//								PreparedStatement prepare = conn.prepareStatement(query);
	//							      //On remplace le premier trou par le nom du professeur
	//							     prepare.setString(1, Integer.toString(n_informationsSiege));
	//							     prepare.setString(2, lList.get(66));
	//							     prepare.setString(3, lList.get(67));
	//							     prepare.setString(4, lList.get(68));
	//							     prepare.setString(5, lList.get(69));
	//							     ++n_informationsSiege;
	//					      }
	//						IdentificationEntreprise identificationEntreprise = new IdentificationEntreprise(lList.get(60),lList.get(61), lList.get(62),lList.get(63),lList.get(64),lList.get(65));
	//						//						INSERT INTO ? (prof_nom, prof_prenom) VALUES('SALMON', 'Dylan');
	//						CaracteristiquesEconomiquesEntreprise caracteristiquesEconomiquesEntreprise = new CaracteristiquesEconomiquesEntreprise(lList.get(70),lList.get(71), lList.get(72),lList.get(73),lList.get(74),lList.get(75));
	//						Entreprise entreprise = new Entreprise(lList.get(0), informationsSiege, identificationEntreprise, caracteristiquesEconomiquesEntreprise);
	//						AdresseDeclaree adresseDeclaree = new AdresseDeclaree(lList.get(9), lList.get(10), lList.get(11),lList.get(12),lList.get(13), lList.get(14), lList.get(15));
	//						AdresseNormalisee adresseNormalisee = new AdresseNormalisee(lList.get(2), lList.get(3), lList.get(4),lList.get(5),lList.get(6), lList.get(7), lList.get(8));
	//						AdresseGeographique adresseGeographique = new AdresseGeographique(lList.get(16), lList.get(17), lList.get(18), lList.get(19), lList.get(20), lList.get(21));
	//						CaracteristiquesEconomiquesEtablissement caracteristiquesEconomiquesEtablissement = new CaracteristiquesEconomiquesEtablissement(lList.get(40), lList.get(41), lList.get(42), lList.get(43));
	//						Informations info = new Informations(lList.get(36), lList.get(37), lList.get(38), lList.get(39), lList.get(40));
	//						Localisation localisation = new Localisation(lList.get(22), lList.get(23), lList.get(24), lList.get(25), lList.get(26), lList.get(27), lList.get(28), lList.get(29), lList.get(30), lList.get(31), lList.get(32), lList.get(33), lList.get(34));
	//						MiseAJour miseAJour = new MiseAJour(lList.get(95), lList.get(96), lList.get(97), lList.get(98), lList.get(99));
	//						Etablissement etablissement = new Etablissement(SIRET(lList), entreprise, lList.get(2), adresseDeclaree, adresseNormalisee, info, adresseGeographique, localisation, caracteristiquesEconomiquesEtablissement, miseAJour);
	//					}
	//					//				lList.forEach((element) -> {
	//					//					out.print(element);
	//					//					out.print(";");
	//					//				});
	//					//				out.print("\n");
	//				}
	//				//Flush the output to the file
	//				out.flush();
	//
	//				//Close the Print Writer
	//				out.close();
	//
	//				//Close the File Writer
	//				fw.close();       
	//				br.close();
	//			} catch (FileNotFoundException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//			finally {
	//				System.out.println("C fini");
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}  
	//	}
	//
	//	public static String SIRET(LinkedList<String> lList) {
	//		int SIREN = Integer.parseInt(lList.get(0));
	//		int NIC  = Integer.parseInt(lList.get(1));
	//		int siret = SIREN + NIC;
	//		return Integer.toString(siret);
	//	}
	//	public static LinkedList<String> stringToMultipleElementsLinklist(String s) {
	//		// convert array to LinkedList
	//		//		System.out.println(s);
	//		String[] str = s.split(";");
	//		//		System.out.println(str);
	//		LinkedList<String> listStrings = new LinkedList<String>();
	//		for (String element : str) {
	//			listStrings.add(element.replaceAll("\"", ""));
	//		}
	//		return listStrings;
	//	}
}
