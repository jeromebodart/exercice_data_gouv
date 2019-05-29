package sirene;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class LineSpliter {
	public static void main(String args[])  
	{  
//		https://stackoverflow.com/questions/19177994/java-read-file-and-split-into-multiple-files
		try{  
			// Reading file and getting no. of files to be generated  
//			Create a file chooser
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
//			Use wc -l nom_fichier pour obtenir le nombre de lignes du fichier
//			 11364644/20 = 568232 donc je choisis ce nombre pour avoir 20 fichiers se 8/20=400Mo   
			double nol = 568232; //  No. of lines to be split and saved in each output file.
			Scanner scanner = new Scanner(file);  
			int count = 0;  
			while (scanner.hasNextLine())   
			{  
				scanner.nextLine();  
				count++;  
			}  
			System.out.println("Lines in the file: " + count);     // Displays no. of lines in the input file.  
			double temp = (count/nol);  
			int temp1=(int)temp;  
			int nof=0;  
			if(temp1==temp)  
			{  
				nof=temp1;  
			}  
			else  
			{  
				nof=temp1+1;  
			}  
			System.out.println("No. of files to be generated :"+nof); // Displays no. of files to be generated.  
			//---------------------------------------------------------------------------------------------------------  
			// Actual splitting of file into smaller files  
			FileInputStream fstream = new FileInputStream(file); DataInputStream in = new DataInputStream(fstream);  
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;  
			for (int j=1;j<=nof;j++)  
			{  
//				FileWriter fstream1 = new FileWriter(file.getParent()+"\\"+j+".csv");     // Destination File Location  
				OutputStreamWriter fstream1 = new OutputStreamWriter(new FileOutputStream(file.getParent()+"\\"+j+".csv", true), StandardCharsets.UTF_8);
				BufferedWriter out = new BufferedWriter(fstream1);   
				for (int i=1;i<=nol;i++)  
				{  
					strLine = br.readLine();   
					if (strLine!= null)  
					{  
						out.write(strLine);   
						if(i!=nol)  
						{  
							out.newLine();  
						}  
					}  
				}  
				out.close();  
			}  
			in.close();  
			System.out.println("J'ai fini!!");
		}catch (Exception e)  
		{  
			System.err.println("Error: " + e.getMessage());  
		}  
	}  
}
