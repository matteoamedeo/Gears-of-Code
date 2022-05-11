package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;




public class Utility {

	public static String fileString(String percorso) {
		String risposta = "";

		try {
			Scanner file = new Scanner (new File(percorso));
			while(file.hasNextLine()) {
				risposta += file.nextLine()+"\n";
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nERRORE LETTURA FILE\n");
			e.printStackTrace();
		}
		return risposta;
	}

	public static String leggiCorpoEsercizio(String linguaggioScelto,int livelloScelto,String nomeEsercizio) {

		String risposta = "";

		String percorso = "C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src/main/res/" + linguaggioScelto.toLowerCase() + "/esercizi/livello" + livelloScelto + "/" + nomeEsercizio.replaceAll(" ","")+".txt";
		try {

			Scanner file = new Scanner (new File(percorso));
			while(file.hasNextLine()) {
				risposta += file.nextLine() +"<br>";
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nERRORE LETTURA FILE\n");
			e.printStackTrace();
		}
		return risposta;
	}

	public static String leggiCorpoSoluzione(String linguaggioScelto,int livelloScelto,String nomeEsercizio) {
		String risposta = "";

		try {
			for(int i = 1 ; i <= 3 ; i++) {

				String percorso = "C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src/main/res/" + linguaggioScelto.toLowerCase() + "/soluzioni/livello" + livelloScelto + "/" 
						+ nomeEsercizio.replaceAll(" ","")+"/"+ nomeEsercizio.replaceAll(" ","")+"_opzione"+i+".txt";

				Scanner file = new Scanner (new File(percorso));
				while(file.hasNextLine()) {
					risposta += file.nextLine()+"<br>&nbsp";

				}
				file.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("\nERRORE LETTURA FILE\n");
			e.printStackTrace();
		}
		return risposta;
	}
	public static String leggiCorpoSoluzioneOpzione(String linguaggioScelto,int livelloScelto,String nomeEsercizio, int opzione) {
		String risposta = "";

		try {
			//for(int i = 1 ; i <= 3 ; i++) {

			String percorso = "C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src\\main\\res\\" + linguaggioScelto.toLowerCase() + "\\soluzioni\\livello" + livelloScelto + "\\" 
					+ nomeEsercizio.replaceAll(" ","")+"\\"+ nomeEsercizio.replaceAll(" ","")+"_opzione"+opzione+".txt";
			//System.out.println("utility 79: " + percorso);
			Scanner file = new Scanner (new File(percorso));
			while(file.hasNextLine()) {
				risposta += file.nextLine()+"<br>&nbsp";

			}
			file.close();
			//}
		} catch (FileNotFoundException e) {
			System.out.println("\nERRORE LETTURA FILE\n");
			e.printStackTrace();
		}
		return risposta;
	}



	public static void writeEsercizio(String linguaggioScelto,int livelloScelto,String nomeEsercizio,String corpo) {


		try {

			String percorso = "C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src\\main\\res\\" + linguaggioScelto.toLowerCase() + "/esercizi/livello" + livelloScelto + "/" + nomeEsercizio;

			FileWriter fw = new FileWriter(percorso);

			fw.write(corpo);
			System.out.println("Scrittura completata.");

			fw.close();

		}catch (IOException err) {
			System.out.println("ERRORE: " + err.getMessage());
		} catch (Exception err) {
			System.out.println("ERRORE: " + err.getMessage());
		}
	}

	public static void writeSoluzione(String linguaggioScelto,int livelloScelto,String nomeEsercizio,
			int idEsercizio,String opzione1,String opzione2,String opzione3) {

		try {

			String cartella = nomeEsercizio.replace(".txt", "");

			String percorso = "C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src\\main\\res\\" + linguaggioScelto.toLowerCase() + "/soluzioni/livello" + livelloScelto + "/"; 

			File f = new File(percorso + cartella);
			f.mkdir();
			percorso += cartella + "/" + cartella + "_" ;
			String percorso1 = percorso + "opzione1.txt";
			String percorso2 = percorso + "opzione2.txt";
			String percorso3 = percorso + "opzione3.txt";

			FileWriter fw1 = new FileWriter(percorso1);
			fw1.write(opzione1);
			fw1.close();

			FileWriter fw2 = new FileWriter(percorso2);
			fw2.write(opzione2);
			fw2.close();

			FileWriter fw3 = new FileWriter(percorso3);
			fw3.write(opzione3);
			fw3.close();

			System.out.println("Scrittura completata.");

		}catch (IOException err) {
			System.out.println("ERRORE: " + err.getMessage());
		} catch (Exception err) {
			System.out.println("ERRORE: " + err.getMessage());
		}
	}

	public static String leggiCorpoSoluzioneEsatta(String linguaggioScelto,int livelloScelto,String nomeEsercizio) {
		String risposta = "";

		try {


			String percorso = "C:\\Users\\Simone\\Documenti\\Eclipse\\GearsOfCode\\GearsOfCode\\src/main/res/" + linguaggioScelto.toLowerCase() + "/soluzioni/livello" + livelloScelto + "/" 
					+ nomeEsercizio.replaceAll(" ","")+"/"+ nomeEsercizio.replaceAll(" ","")+"_opzione"+1+".txt";

			Scanner file = new Scanner (new File(percorso));
			while(file.hasNextLine()) {
				risposta += file.nextLine()+"\n";

			}
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("\nERRORE LETTURA FILE\n");
			e.printStackTrace();
		}
		return risposta;
	}
	public static String leggiCorpoSoluzioneUtente(String linguaggioScelto,int livelloScelto,String nomeEsercizio, int scelta) {
		String risposta = "";

		try {


			String percorso = "C:\\Users\\Simone\\Documenti\\Eclipse\\GearsOfCode\\GearsOfCode\\src/main/res/" + linguaggioScelto.toLowerCase() + "/soluzioni/livello" + livelloScelto + "/" 
					+ nomeEsercizio.replaceAll(" ","")+"/"+ nomeEsercizio.replaceAll(" ","")+"_opzione"+scelta+".txt";

			Scanner file = new Scanner (new File(percorso));
			while(file.hasNextLine()) {
				risposta += file.nextLine()+"\n";

			}
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("\nERRORE LETTURA FILE\n");
			e.printStackTrace();
		}
		return risposta;
	}

	public static boolean controllaRisultato(String linguaggio, int livello, String titoloEsercizio) {
		boolean ris = false;
		switch (linguaggio) {
		case "Java":
			switch (livello) {
			case 1:
				switch (titoloEsercizio) {
				case "Even_Or_Odd":
					
					break;

				default:
					break;
				}
				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}
			break;
		case "JavaScript":

			break;

		default:
			break;
		}


		System.out.println(ris);
		return ris;
	}


}