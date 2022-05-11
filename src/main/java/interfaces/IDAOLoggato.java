package interfaces;

import dao.*;
import entities.*;

public interface IDAOLoggato{

	IDAOPersone ip = new DAOPersone("gearsofcode");
	IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	
	
	default boolean creaEsercizioLv3(Persona p, Esercizio e, Soluzione s) {
		
		boolean esito = false;
		
		if (p.getLivello() == 3) {
			
			ie.createUtente(e,p);
			is.createUtente(s,p);
			
			esito = true;
		}		
		return esito;
	}
	
	default boolean isSoluzioneEsatta(Persona p,  Esercizio e, int punti, boolean risposta) {
		
		boolean esito = false;
		
		if(risposta) {
			esito = true;
			ip.updatePuntiUtente(p, e, punti);
			
		}	
		return esito;
	}
	
	default boolean puoModificare(Persona p, Esercizio e, Soluzione s) {

		boolean esito = false;
		
		if(e.getIdCreatore() == p.getId()) {
			
			// metodo update esercizi
			ie.updateUtente(e, p);
			// metodo update soluzioni
			is.updateUtente(s);
			
			// modifica esito
			esito = true;
		}
		
		return esito;
	}
	
	
}