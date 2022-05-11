package entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Persona {

	private int id;
	private String username;
	private String password ;
	private String email;
	private int livello;
	private int punteggio;
	private String completati;
	
	@Override
	public String toString(){
		String ris = "";
		Map<String, String> mappa = toMap();
		for(String chiave : mappa.keySet())
			ris += chiave +	": " + mappa.get(chiave) + "\n";
		return ris;
	}
	
	public static Persona fromMap(Map<String,String> m) {
		Persona p = new Persona();
				
		p.setUsername(m.get("username"));
		p.setPassword(m.get("pwd"));
		p.setEmail(m.get("email"));
		p.setLivello(Integer.parseInt(m.get("livello")));
		p.setPunteggio(Integer.parseInt(m.get("punteggio")));
		//
		p.setCompletati(m.get("completato"));
		return p;
	}	
	
	public Map<String, String> toMap(){
		
		Map<String,String> ris = new LinkedHashMap<String,String>();
		
		ris.put("id", id + "");
		ris.put("username", username);
		ris.put("pwd",password);
		ris.put("email", email);
		ris.put("livello", livello+"");
		ris.put("punteggio", punteggio+"");
		//
		ris.put("completato", completati);
		return ris;
	}
	
	public Persona() {
		// Costruttore vuoto
	}
	
	public Persona(Map<String, String> m){
		if(m.containsKey("id"))
			setId(Integer.parseInt(m.get("id")));
		if(m.containsKey("username"))
			setUsername(m.get("username"));
		if(m.containsKey("pwd"))
			setPassword(m.get("pwd"));
		if(m.containsKey("email"))
			setEmail(m.get("email"));
		if(m.containsKey("livello"))
			setLivello(Integer.parseInt(m.get("livello")));
		if(m.containsKey("punteggio"))
			setPunteggio(Integer.parseInt(m.get("punteggio")));
		//
		if(m.containsKey("completato"))
			setCompletati(m.get("completato"));
	}
	
	public Persona(String tipo,Map<String, String[]> request) {
		Map<String,String> riga = new HashMap<String, String>();
		for (String chiave : request.keySet()) 
			riga.put(chiave,request.get(chiave)[0]);
			setId(Integer.parseInt(riga.get("id")));
			setUsername(riga.get("username"));
			setPassword(riga.get("pwd"));
			setEmail(riga.get("email"));
			setLivello(Integer.parseInt(riga.get("livello")));
			setPunteggio(Integer.parseInt(riga.get("punteggio")));
			//
			setCompletati(riga.get("completato"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		
	
		
		this.livello = livello;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		
		this.punteggio = punteggio;
	}

	public String getCompletati() {
		return completati;
	}

	public void setCompletati(String completati) {
		this.completati = completati;
	}
	
	
	
}
