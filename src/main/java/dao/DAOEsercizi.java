package dao;

import java.util.List;
import java.util.Map;

import entities.Esercizio;
import entities.Persona;
import interfaces.IDAOEsercizi;
import interfaces.IDAOLoggato;

public class DAOEsercizi implements IDAOEsercizi,IDAOLoggato{
	
	private Database db;
	
	public DAOEsercizi(String nomeDB)
	{
		db = new Database(nomeDB);
		db.apriConnessione();
	}

	@Override
	public List<Map<String, String>> read() {
		return db.read("select * from esercizi");
	}

	@Override
	public boolean create(Esercizio e) {
		
		switch (e.getLivello()) {
		
		case 1 : e.setPunti(2); break;
		case 2 : e.setPunti(5); break;
		case 3 : e.setPunti(8); break;
		
		}
		String query = "insert into esercizi (linguaggio,titolo,livello,punti,corpo) values (?,?,?,?,?)";
		return db.update(query, e.getLinguaggio(),e.getTitolo(),e.getLivello() + "" ,e.getPunti() + "",e.getCorpo());
	}

	@Override
	public boolean delete(int id) {
		String query = "delete from esercizi where id = ?";
		return db.update(query, id + "");
	}

	@Override
	public boolean update(Esercizio e) {
		String query = "update esercizi set linguaggio = ?, titolo = ?, livello = ?, punti = ?, corpo = ? where id = ?";
		return db.update(query, e.getLinguaggio(), e.getTitolo(), e.getLivello() + "", 
						e.getPunti() + "", e.getCorpo(), e.getId() + "");
	}

	public List<Map<String, String>> ricerca(String linguaggio, int livello) {
		//select * from esercizi where linguaggio = "java" and livello = 2;
		return db.read("select titolo, punti from esercizi where linguaggio = \"" + linguaggio + "\" and livello = " + livello + "");
	}
	
	public boolean createUtente(Esercizio e, Persona p) {
		
		switch (e.getLivello()) {
		
		case 1 : e.setPunti(2); break;
		case 2 : e.setPunti(5); break;
		case 3 : e.setPunti(8); break;
		
		}
		String query = "insert into esercizi (linguaggio,titolo,livello,punti,corpo,id_creatore) values (?,?,?,?,?,?)";
		return db.update(query, e.getLinguaggio(),e.getTitolo(),e.getLivello() + "" ,e.getPunti() + "",e.getCorpo(), p.getId()+"");
	}
	
	public boolean updateUtente(Esercizio e, Persona p) {
		//	id, linguaggio, titolo, livello, punti, corpo, id_creatore
		switch (e.getLivello()) {

		case 1 : e.setPunti(2); break;
		case 2 : e.setPunti(5); break;
		case 3 : e.setPunti(8); break;

		}
		String query = "update esercizi set linguaggio = ? , titolo = ? , livello = ? , punti = ? , corpo = ? where id = ?";
		return db.update(query, e.getLinguaggio(), e.getTitolo(), e.getLivello() + "",e.getPunti() + "", e.getCorpo(), e.getId() + "");
	}
	
}
