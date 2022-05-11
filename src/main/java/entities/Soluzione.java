package entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Soluzione {

	private int idEsercizio;
	private String opzione1;
	private String opzione2;
	private String opzione3;
	private int idCreatore;
	
	public Soluzione() {
		
	}

	public Soluzione(Map<String, String> m){
		if(m.containsKey("id_esercizio"))
			setIdEsercizio(Integer.parseInt(m.get("id_esercizio")));
		if(m.containsKey("opzione1"))
			setOpzione1(m.get("opzione1"));
		if(m.containsKey("opzione2"))
			setOpzione2(m.get("opzione2"));
		if(m.containsKey("opzione3"))
			setOpzione3(m.get("opzione3"));
		if(m.containsKey("id_creatore"))
			setIdCreatore(Integer.parseInt(m.get("id_creatore")));
	}
	public Soluzione(String tipo,Map<String, String[]> request) {
		Map<String,String> riga = new HashMap<String, String>();
		for (String chiave : request.keySet()) 
			riga.put(chiave,request.get(chiave)[0]);
		setIdEsercizio(Integer.parseInt(riga.get("idEsercizio")));
		setOpzione1(riga.get("opzione1"));
		setOpzione2(riga.get("opzione2"));
		setOpzione3(riga.get("opzione3"));
		setIdCreatore(Integer.parseInt(riga.get("id_creatore")));
	}

	public int getIdEsercizio() {
		return idEsercizio;
	}

	public void setIdEsercizio(int idEsercizio) {
		this.idEsercizio = idEsercizio;
	}

	public String getOpzione1() {
		return opzione1;
	}

	public void setOpzione1(String opzione1) {
		this.opzione1 = opzione1;
	}

	public String getOpzione2() {
		return opzione2;
	}

	public void setOpzione2(String opzione2) {
		this.opzione2 = opzione2;
	}

	public String getOpzione3() {
		return opzione3;
	}

	public void setOpzione3(String opzione3) {
		this.opzione3 = opzione3;
	}


	public Map<String, String> toMap()
	{
		Map<String, String> ris = new LinkedHashMap<String, String>();
		ris.put("id_esercizio", idEsercizio + "");
		ris.put("opzione1", opzione1);
		ris.put("opzione2", opzione2);
		ris.put("opzione3", opzione3);
		ris.put("id_creatore", idCreatore + "");
		
		return ris;
	}
	
	public String toString()
	{
		String ris = "";
		Map<String, String> mappa = toMap();
		for(String chiave : mappa.keySet())
			ris += chiave +	": " + mappa.get(chiave) + "\n";
		return ris;
	}
	
	public static Soluzione fromMap(Map<String, String> m) {
		Soluzione s = new Soluzione();
		s.setIdEsercizio(Integer.parseInt(m.get("id_esercizio")));
		s.setOpzione1(m.get("opzione1"));
		s.setOpzione2(m.get("opzione2"));
		s.setOpzione3(m.get("opzione3"));
		s.setIdCreatore(Integer.parseInt(m.get("id_creatore")));
		return s;
	}

	public int getIdCreatore() {
		return idCreatore;
	}

	public void setIdCreatore(int idCreatore) {
		this.idCreatore = idCreatore;
	}

}