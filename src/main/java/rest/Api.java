package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import dao.DAOEsercizi;
import dao.DAOSoluzioni;
import entities.Esercizio;
import entities.Soluzione;
import interfaces.IDAOEsercizi;
import interfaces.IDAOSoluzioni;
import utilities.Utility;

public class Api {

	IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	public List<JSONObject> eserciziToJSON() {
		JSONObject esercizio = null;
		List<JSONObject> listaJSON = new ArrayList<JSONObject>();
		for (Esercizio e : ie.elencoEsercizi()) {
			esercizio = new JSONObject();
			esercizio.put("id", e.getId());
			esercizio.put("linguaggio", e.getLinguaggio());
			esercizio.put("titolo", e.getTitolo());
			esercizio.put("livello", e.getLivello());
			esercizio.put("punti", e.getPunti());
			esercizio.put("corpo", e.getCorpo());
			listaJSON.add(esercizio);
		}
		return listaJSON;
	}
	public List<JSONObject> soluzioniToJSON() {
		
		JSONObject soluzione = null;
		List<JSONObject> listaJSON = new ArrayList<JSONObject>();
		for (Soluzione s : is.elencoSoluzioni()) {
			soluzione = new JSONObject();
			soluzione.put("id_esercizio", s.getIdEsercizio());
			soluzione.put("opzione1", s.getOpzione1());
			soluzione.put("opzione2", s.getOpzione2());
			soluzione.put("opzione3", s.getOpzione3());
			listaJSON.add(soluzione);
		}
		return listaJSON;
	}
	static public List<JSONObject> esercizi_soluzioniToJSON() {
		IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
		IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
		JSONObject esercizio = null;
		List<JSONObject> listaJSON = new ArrayList<JSONObject>();

		for (int i = 0; i < ie.elencoEsercizi().size(); i++) {
			esercizio = new JSONObject();
			esercizio.put("id", ie.elencoEsercizi().get(i).getId());
			esercizio.put("linguaggio", ie.elencoEsercizi().get(i).getLinguaggio());
			esercizio.put("titolo", ie.elencoEsercizi().get(i).getTitolo());
			esercizio.put("livello", ie.elencoEsercizi().get(i).getLivello());
			esercizio.put("punti", ie.elencoEsercizi().get(i).getPunti());
			esercizio.put("corpo", ie.elencoEsercizi().get(i).getCorpo());
			esercizio.put("corpoEsercizio", Utility.leggiCorpoEsercizio(ie.elencoEsercizi().get(i).getLinguaggio().toLowerCase(),
																		ie.elencoEsercizi().get(i).getLivello(), 
																		ie.elencoEsercizi().get(i).getTitolo()));
			esercizio.put("id_esercizio", is.elencoSoluzioni().get(i).getIdEsercizio());
			esercizio.put("opzione1", Utility.leggiCorpoSoluzioneOpzione(ie.elencoEsercizi().get(i).getLinguaggio().toLowerCase(),
																		 ie.elencoEsercizi().get(i).getLivello(), 
																		 ie.elencoEsercizi().get(i).getTitolo(), 
																		 1));
			esercizio.put("opzione2", Utility.leggiCorpoSoluzioneOpzione(ie.elencoEsercizi().get(i).getLinguaggio().toLowerCase(),
					 													 ie.elencoEsercizi().get(i).getLivello(), 
					 													 ie.elencoEsercizi().get(i).getTitolo(), 
					 													 2));
			esercizio.put("opzione3", Utility.leggiCorpoSoluzioneOpzione(ie.elencoEsercizi().get(i).getLinguaggio().toLowerCase(),
					 													 ie.elencoEsercizi().get(i).getLivello(), 
					 													 ie.elencoEsercizi().get(i).getTitolo(), 
					 													 3));
			
			listaJSON.add(esercizio);
		}
		return listaJSON;
	}

}
