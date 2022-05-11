package viste;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;

import dao.DAOEsercizi;
import entities.Esercizio;
import interfaces.IDAOEsercizi;

public class GestoreTemplate {

private String percorsoCartellaViste;
	
	public GestoreTemplate(String percorsoCartellaViste) {
		this.percorsoCartellaViste = percorsoCartellaViste;
	}
	
	IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	
	public String leggiHTML(String nomeFile) {
		String ris = "";
		try {
			Scanner file = new Scanner(new File(percorsoCartellaViste + nomeFile));
			while(file.hasNextLine()) 
				ris += file.nextLine();
			file.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRORE LETTURA FILE");
		}
		return ris;
	}
	
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
}
