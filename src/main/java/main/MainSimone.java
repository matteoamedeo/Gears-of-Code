package main;

import java.util.*;
import dao.*;
import entities.*;
import interfaces.*;
import utilities.Utility;

public class MainSimone {

	static IDAOPersone ip = new DAOPersone("gearsofcode");
	static IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	static IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	static IDAOLoggato il = new DAOPersone("gearsofcode");
	
	public static void main(String[] args) {
		
//		leggiEsercizio();
//		leggiSoluzioniRandom();
		
		
		
		//System.out.println( Utility.leggiCorpoSoluzioneRandomMappe2("Java", 3, "Prova Esercizio").get(0) );
		//System.out.println( Utility.leggiCorpoSoluzioneRandomMappe2("Java", 3, "Prova Esercizio").get(0).get("2") );
		
		// leggiSoluzione();
		// esercizioCorretto();
		//leggiSoluzioniRandom();
	}
	
	public static void creaUtente() {
		
		Persona p = new Persona ();
		p.setUsername("prova");
		p.setPassword("passprova");
		p.setEmail("prova@outlook.it");
		ip.create(p);
		
	}

	public static void modUtente() {
				// METODO CAMBIO USER/MAIL/PWD DA LOGIN
		Persona p = ip.cercaPerId(7);
		p.setUsername("login");
		p.setPassword("pass");
		p.setEmail("provo@login");
		ip.updateLogin(p);
	}
	
 	public static void creaEsercizioSoluzioni() {
		
		
		// CREO OGGETTO ESERCIZIO
		Esercizio e = new Esercizio();
		e.setLinguaggio("Java");
		e.setTitolo("Prova Esercizio");
		e.setLivello(3);		
		e.setCorpo(e.getTitolo());	
		// LO INSERISCO NEL DB 
		ie.create(e);
		
		String corpo = "VALORI DA INSERIRE";
		
		// CREO OGGETTO SOLUZIONE
		Soluzione s = new Soluzione();
		s.setOpzione1(e.getCorpo() + "_opzione1.txt");
		s.setOpzione2(e.getCorpo() + "_opzione2.txt");
		s.setOpzione3(e.getCorpo() + "_opzione3.txt");
		// LO INSERISCO NEL DB
		is.create(s);
		
		String opzione1 = "VALORI DA INSERIRE";
		String opzione2 = "VALORI DA INSERIRE";
		String opzione3 = "VALORI DA INSERIRE";
		
		// USO I METODI write DELLA CLASSE Utility
		Utility.writeEsercizio(e.getLinguaggio(),e.getLivello(),e.getCorpo(), corpo);
		Utility.writeSoluzione(e.getLinguaggio(),e.getLivello(),e.getCorpo(),e.getId(),opzione1,opzione2,opzione3);	
		
		
	}
	
 	public static boolean userLivello3CreaRoba() {

 		boolean esito = false;


 		// METODO PER CREARE ESERCIZIO E SOLUZIONE SE PERSONA LV3
 		// creaEsercizioLv3(Persona p, Esercizio e, Soluzione s)

 		// Uso ip.cercaPerId() che mi torna un oggetto Persona		
 		//				System.out.println( ip.cercaPerId(6) );

 		// Creo l'oggetto Esercizio
 		Esercizio e = new Esercizio();
 		e.setLinguaggio("Java");
 		e.setTitolo("Creo un nUoVo esercizio");
 		e.setLivello(3);
 		e.setCorpo(e.getTitolo());

 		// CORPO SARÁ IL TESTO DELL'ESERCIZIO
 		String corpo = "VALORI DA INSERIRE";

 		// Creo l'oggetto Soluzione
 		Soluzione s = new Soluzione();
 		s.setOpzione1(e.getCorpo().replace(".txt", "") + "_opzione1.txt");
 		s.setOpzione2(e.getCorpo().replace(".txt", "") + "_opzione2.txt");
 		s.setOpzione3(e.getCorpo().replace(".txt", "") + "_opzione3.txt");

 		// LE OPZIONI SARANNO I TESTI DELLE SOLUZIONI
 		String opzione1 = "VALORI DA INSERIRE";
 		String opzione2 = "VALORI DA INSERIRE";
 		String opzione3 = "VALORI DA INSERIRE";

 		// CONTROLLO CHE LA PERSONA INDICATA SIA LIVELLO 3 E SE SI CREO ESERCIZI E SOLUZIONI

 		Persona p = new Persona();

 		// DA MODIFICARE IL NUMERO CON L'ID DELL'UTENTE PRESO DAL WEB
 		p = ip.cercaPerId(8); 

 		boolean posso = il.creaEsercizioLv3(p, e, s);

 		if (posso == true) {
 			Utility.writeEsercizio(e.getLinguaggio(),e.getLivello(),e.getCorpo(), corpo );
 			Utility.writeSoluzione(e.getLinguaggio(),e.getLivello(),e.getCorpo(),e.getId(),opzione1,opzione2,opzione3 );	
 			esito = true;
 		}
 		return esito;
 	}
	
	public static void leggiEsercizio() {
		// METODO Utility CHE LEGGE IL CORPO DELL'ESERCIZIO SELEZIONATO
//		String a = "Hidden Cubic Numbers";
//		a = a.replaceAll(" ","");
//		System.out.println(a);
		
		String linguaggio = "Java";
		int livello = 3;
		String esercizio = "Prova Esercizio";
		System.out.println(Utility.leggiCorpoEsercizio(linguaggio, livello, esercizio));
	}
	
	public static void leggiEserciziLinguaLivello() {
		// RICERCA ESERCIZI PER LINGUAGGIO E LIVELLO
		String linguaggio = "C";
		int livello = 2;
		String elenco = "";
		
		// il metoto eserciziLinguaLivello(linguaggio,livello) ritorna
		// un ArrayList di Mappe contenenti gli esercizi del linguaggio
		// e del livello richiesto dall'utente
		
		for(Map<String, String> m : ie.eserciziLinguaLivello(linguaggio,livello)) {
			elenco += m.values()+"\n" ;
		}		
		System.out.println(elenco);
	}
	
	public static void leggiSoluzione() {
		// METODO Utility CHE LEGGE IL CORPO DELLE SOLUZIONI DELL'ESERCIZIO SELEZIONATO
		String linguaggio = "Java";
		int livello = 3;
		String esercizio = "Find The Odd Int";
		System.out.println(Utility.leggiCorpoSoluzioneEsatta(linguaggio, livello, esercizio));
	}
	
//	public static void gestioneSoluzioneCorretta() {
//		//GESTIONE PUNTEGGIO PER ESERCIZIO CORRETTO
//		Persona p = ip.cercaPerId(7);
//		Esercizio e = ie.cercaPerId(150);
//		Soluzione s = is.cercaPerId(150);
//		String risposta = "OddHeavyArray_opzione1.txt";
//		
//		int punti = e.getPunti();
//		
//		if( cercoSeFatto( e.getId() ) == true ) {
//			punti = 0;
//		}
//		System.out.println( il.isSoluzioneEsatta( p, e, punti , s, risposta ) );
//		
//	}
	
	public static boolean cercoSeFatto(int idEsercizio) {
		
		boolean fatto = false;
		
		Persona p = new Persona();
		// TROVO LA PERSONA CHE STA SVOLGENDO L'ESERCIZIO
		p = ip.cercaPerId(7);		
		
		String elenco = "";
		
		// USO IL METODO giaFatto PER CREARE UN ARRAYLIST DI MAPPE
		// CONTENENTE UN ELENCO DI ESERCIZI COMPLETATI DALL'UTENTE
		for(Map<String,String> m : ip.giaFatto(p)) {
			elenco += m.values();
		}
		System.out.println(elenco);
		
		// CREO UN VETTORE DALL'ELENCO
		String[] vettoreFatti = new String[elenco.split(",").length];
		
		// CICLO L'ELENCO E OGNI VALORE LO INSERISCO NELL'ARRAY
		for(int i = 0 ; i < vettoreFatti.length ; i++) {
			vettoreFatti[i] = elenco.split(",")[i];
		}
		
		int min = 0;
		int max = vettoreFatti.length-1;
		
		// ELIMINO LA "[" DAL PRIMO ELEMENTO E LA "]" DALL'ULTIMO
		vettoreFatti[min] = vettoreFatti[min].replace("[", "");
		vettoreFatti[max] = vettoreFatti[max].replace("]", "");

		// CON esercizio INDICO L'ESERCIZIO DESIDERATO 
		String esercizio = idEsercizio+"";
		
		// CERCO esercizio CICLANDO IL VETTORE
		for(int i = 0 ; i < vettoreFatti.length ; i++) {
			// STAMPO L'ESITO DEL CONFRONTO
			if(esercizio.equalsIgnoreCase(vettoreFatti[i])) {
				fatto = true;
				System.out.println(fatto);
				break;
			}
			
		}
		return fatto;
	}
	
	public static boolean utenteModEx() {

 		boolean esito = false;

 		Esercizio e = new Esercizio();
 		e = ie.cercaPerId(151);
 		e.setLinguaggio("C");
 		e.setTitolo("Modifico nuovamente un esercizio");
 		e.setLivello(3);
 		e.setCorpo(e.getTitolo());
 		
 		//int id = e.getId();
 		
 		String corpo = "VALORI DA INSERIRE";
 		
 		Soluzione s = new Soluzione();
 		
 		s = is.cercaPerId(151);
 		s.setOpzione1(e.getCorpo().replace(".txt", "") + "_opzione1.txt");
 		s.setOpzione2(e.getCorpo().replace(".txt", "") + "_opzione2.txt");
 		s.setOpzione3(e.getCorpo().replace(".txt", "") + "_opzione3.txt");

 		String opzione1 = "VALORI DA INSERIRE";
 		String opzione2 = "VALORI DA INSERIRE";
 		String opzione3 = "VALORI DA INSERIRE";
 		
 		Persona p = new Persona();
 		p = ip.cercaPerId(8);
 		
 		boolean posso = il.puoModificare(p, e, s);
 		
 		if(posso == true) {
 			
 			Utility.writeEsercizio(e.getLinguaggio(),e.getLivello(),e.getCorpo(), corpo );
 			Utility.writeSoluzione(e.getLinguaggio(),e.getLivello(),e.getCorpo(),e.getId(),opzione1,opzione2,opzione3 );	
 			
 			esito = true; 		
 		}
 		
 		return esito;
 	}
	
	
	public static boolean esercizioCorretto() {
		boolean esito = false;
		
		String linguaggio = "Java";
		int livello = 3;
		String esercizio = "Find The Odd Int";
				
		String rispostaEsatta = Utility.leggiCorpoSoluzioneEsatta(linguaggio, livello, esercizio);
				
		// corrisponde alla request dal web														   3 dovrá corrispondere alla chiave della mappa
		String rispostaUtente =  Utility.leggiCorpoSoluzioneUtente(linguaggio, livello, esercizio, 3);
		
		// parametro in entrata sará la request
		if(rispostaEsatta.equals(rispostaUtente)) {
			esito = true;
		}
		
		
		
		System.out.println(esito);
		return esito;
	}
	
	
	
}