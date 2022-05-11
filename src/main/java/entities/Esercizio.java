package entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Esercizio {

	private int id;
	private String linguaggio;
	private String titolo;
	private int livello;
	private int punti;
	private String corpo;
	private int idCreatore;
	
	
	public Esercizio() {
		
	}

	public Esercizio(Map<String, String> m)
	{
		if(m.containsKey("id"))
			setId(Integer.parseInt(m.get("id")));
		if(m.containsKey("linguaggio"))
			setLinguaggio(m.get("linguaggio"));
		if(m.containsKey("titolo"))
			setTitolo(m.get("titolo"));
		if(m.containsKey("livello"))
			setLivello(Integer.parseInt(m.get("livello")));
		if(m.containsKey("punti"))
			setPunti(Integer.parseInt(m.get("punti")));
		if(m.containsKey("corpo"))
			setCorpo(m.get("titolo"));
		if(m.containsKey("id_creatore"))
			setIdCreatore(Integer.parseInt(m.get("id_creatore")));
	}
	public Esercizio(String tipo,Map<String, String[]> request) {
		Map<String,String> riga = new HashMap<String, String>();
		for (String chiave : request.keySet()) 
			riga.put(chiave,request.get(chiave)[0]);
		setId(Integer.parseInt(riga.get("id")));
		setLinguaggio(riga.get("linguaggio"));
		setTitolo(riga.get("titolo"));
		setLivello(Integer.parseInt(riga.get("livello")));
		setPunti(Integer.parseInt(riga.get("punti")));
		setCorpo(riga.get("corpo"));
		setIdCreatore(Integer.parseInt(riga.get("id_creatore")));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinguaggio() {
		return linguaggio;
	}

	public void setLinguaggio(String linguaggio) {
		this.linguaggio = linguaggio;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String titolo) {
		
		String[] frase = titolo.split(" ");
		String nomeCorpo = "";
		
		for(String s : frase) {
			
			String primaLettera = s.substring(0,1).toUpperCase();
			String resto = s.substring(1, s.length()).toLowerCase();
			
			nomeCorpo += primaLettera + resto;
		}
		this.corpo = nomeCorpo+".txt";
	}
	
	public static Esercizio fromMap(Map<String,String> m) {
		Esercizio e = new Esercizio();
		e.setId(Integer.parseInt(m.get("id")));
		e.setLinguaggio(m.get("linguaggio"));
		e.setTitolo(m.get("titolo"));
		e.setLivello(Integer.parseInt(m.get("livello")));
		e.setPunti(Integer.parseInt(m.get("punti")));
		e.setCorpo(m.get("corpo"));
		e.setIdCreatore(Integer.parseInt(m.get("id_creatore")));
		return e;
	}

	public Map<String, String> toMap(){
		Map<String, String> ris = new LinkedHashMap<String, String>();
		ris.put("id", id + "");
		ris.put("linguaggio", linguaggio);
		ris.put("titolo", titolo);
		ris.put("livello", livello + "");
		ris.put("punti", punti + "");
		ris.put("corpo", corpo);
		ris.put("id_creatore", idCreatore + "");
		return ris;
	}
	
	public String toString(){
		String ris = "";
		Map<String, String> mappa = toMap();
		for(String chiave : mappa.keySet())
			ris += chiave +	": " + mappa.get(chiave) + "\n";
		return ris;
	}

	public int getIdCreatore() {
		return idCreatore;
	}

	public void setIdCreatore(int idCreatore) {
		this.idCreatore = idCreatore;
	}

}
