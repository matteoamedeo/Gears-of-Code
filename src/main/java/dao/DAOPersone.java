package dao;

import java.util.List;
import java.util.Map;

import entities.Esercizio;
import entities.Persona;
import interfaces.IDAOLoggato;
import interfaces.IDAOPersone;

public class DAOPersone implements IDAOPersone,IDAOLoggato{

	private Database db;

	public DAOPersone(String nomeDB)
	{
		db = new Database(nomeDB);
		db.apriConnessione();
	}

	@Override
	public List<Map<String, String>> read() {
		return db.read("select * from persone");
	}

	@Override
	public boolean create(Persona p) {
		String query = "insert into persone(username, pwd, email) values(?,?,?)";
		return db.update(query, p.getUsername(), p.getPassword(),
				p.getEmail());
	}


	@Override
	public boolean delete(int id) {
		String query = "delete from persone where id = ?";
		return db.update(query, id + "");
	}
	
	@Override
	public boolean update(Persona p) {
		String query = "update persone set username = ?, pwd = ?, email = ?, livello = ?, punteggio = ?  where id = ?";
		return db.update(query, p.getUsername(), p.getPassword(),
				p.getEmail(), p.getLivello() + "", p.getPunteggio() + "", p.getId() + "");
	}

	// prendo l'utente dal db attraverso le credenziali che manderemo al metodo login()
	public List<Map<String, String>> loginDB(String username, String password) {
			String query = "select * from persone where username = \"" + username + "\" and pwd = \"" + password + "\"" ;
			return db.read(query) ;
	}
	
	public boolean updateLogin(Persona p) {
		String query = "update persone set username = ?, pwd = ?, email = ?  where id = "+p.getId();
		return db.update(query, p.getUsername(), p.getPassword(),p.getEmail());
	}
	
	public boolean updatePuntiUtente(Persona p, Esercizio e, int punti) {
					  //update persone set punteggio = punteggio+  (select punti from esercizi where id = ?) 										where id = ?;
					//                                                                                       completato = concat(completato,",124")
		boolean ris = false;
			
		
		if(punti == 0) {
			String query = "update persone set punteggio = punteggio+" + punti + " where id =" + p.getId();
			ris = db.update(query);
		}
		else {
			String query = "update persone set punteggio = punteggio+" + e.getPunti() + ", completato = concat(completato,\"," + e.getId() +"\") where id =" + p.getId();
			ris = db.update(query);
		}
			
		
		//GESTIONE AUMENTO LIVELLO
		String queryLivello = "";		
		if(p.getPunteggio() + e.getPunti() >= 20) {
			queryLivello =  "update persone set livello = 2 where id = " + p.getId();
		}
		if(p.getPunteggio() + e.getPunti() >= 70) {
			queryLivello =  "update persone set livello = 3 where id = " + p.getId();
		}
		if(!queryLivello.equals("")) {
			db.update(queryLivello);
			System.out.println("Aumento di livello");
		}
				
		return ris;
	}
	
	@Override
	public List<Map<String, String>> giaFatto(Persona p) {
		
		String query = "select completato from persone where id ="+p.getId();
		return db.read(query);
	}

}
