import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

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

/**
 * @author jbodart
 *
 */
public class Test {

	public static void main(String[] args) throws IOException {
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
					//				Creation des instances
					//	System.out.println("66");
					//					System.out.println(lList.get(66).toString());
					//					System.out.println("67");
					//					System.out.println(lList.get(67).toString());
					//					System.out.println("68");
					//					System.out.println(lList.get(68).toString());
					//					System.out.println("66_bis");
					//					System.out.println(Integer.parseInt(lList.get(66)));
					//					System.out.println("67_bis");
					//					System.out.println(Integer.parseInt(lList.get(67)));
					//					System.out.println("68_bis");
					//					System.out.println(Integer.parseInt(lList.get(68)));

					InformationsSiege informationsSiege = new InformationsSiege(lList.get(66), lList.get(67), lList.get(68), lList.get(69));
					IdentificationEntreprise identificationEntreprise = new IdentificationEntreprise(lList.get(60),lList.get(61), lList.get(62),lList.get(63),lList.get(64),lList.get(65));
					CaracteristiquesEconomiquesEntreprise caracteristiquesEconomiquesEntreprise = new CaracteristiquesEconomiquesEntreprise(lList.get(70),lList.get(71), lList.get(72),lList.get(73),lList.get(74),lList.get(75));
					Entreprise entreprise = new Entreprise(lList.get(0), informationsSiege, identificationEntreprise, caracteristiquesEconomiquesEntreprise);
					AdresseDeclaree adresseDeclaree = new AdresseDeclaree(lList.get(9), lList.get(10), lList.get(11),lList.get(12),lList.get(13), lList.get(14), lList.get(15));
					AdresseNormalisee adresseNormalisee = new AdresseNormalisee(lList.get(2), lList.get(3), lList.get(4),lList.get(5),lList.get(6), lList.get(7), lList.get(8));
					AdresseGeographique adresseGeographique = new AdresseGeographique(lList.get(16), lList.get(17), lList.get(18), lList.get(19), lList.get(20), lList.get(21));
					CaracteristiquesEconomiquesEtablissement caracteristiquesEconomiquesEtablissement = new CaracteristiquesEconomiquesEtablissement(lList.get(40), lList.get(41), lList.get(42), lList.get(43));
					Informations info = new Informations(lList.get(36), lList.get(37), lList.get(38), lList.get(39), lList.get(40));
					Localisation localisation = new Localisation(lList.get(22), lList.get(23), lList.get(24), lList.get(25), lList.get(26), lList.get(27), lList.get(28), lList.get(29), lList.get(30), lList.get(31), lList.get(32), lList.get(33), lList.get(34));
					MiseAJour miseAJour = new MiseAJour(lList.get(95), lList.get(96), lList.get(97), lList.get(98), lList.get(99));
					Etablissement etablissement = new Etablissement(SIRET(lList), entreprise, lList.get(2), adresseDeclaree, adresseNormalisee, info, adresseGeographique, localisation, caracteristiquesEconomiquesEtablissement, miseAJour);
					System.out.println(etablissement.toString());
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public static String SIRET(LinkedList<String> lList) {
		int SIREN = Integer.parseInt(lList.get(0));
		int NIC  = Integer.parseInt(lList.get(1));
		int siret = SIREN + NIC;
		return Integer.toString(siret);
	}
}
