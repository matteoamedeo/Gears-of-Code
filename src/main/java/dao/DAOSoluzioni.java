package dao;

import java.util.*;
import entities.*;
import interfaces.*;

public class DAOSoluzioni implements IDAOSoluzioni,IDAOLoggato{
	
	private Database db;
	
	public DAOSoluzioni(String nomeDB)
	{
		db = new Database(nomeDB);
		db.apriConnessione();
	}

	@Override
	public List<Map<String, String>> read() {
		return db.read("select * from soluzioni");

	}

	@Override
	public boolean create(Soluzione s) {
		String query = "insert into soluzioni (id_esercizio,opzione1,opzione2,opzione3) values ((select max(id) from esercizi),?,?,?)";
		return db.update(query, s.getOpzione1(),s.getOpzione2(),s.getOpzione3());
	}

	@Override
	public boolean delete(int idEsercizio) {
		String query = "delete from soluzioni where id_esercizio = ?";
		return db.update(query, idEsercizio + "");
	}

	@Override
	public boolean update(Soluzione s) {
		String query = "update soluzioni set opzione1 = ?,opzione2 = ?,opzione3 = ?, where id_esercizio = ?";
		return db.update(query, s.getOpzione1(),s.getOpzione2(),s.getOpzione3(), s.getIdEsercizio() + "");
		}

	@Override
	public boolean createUtente(Soluzione s,Persona p) {
		String query = "insert into soluzioni (id_esercizio,opzione1,opzione2,opzione3,id_creatore) values ((select max(id) from esercizi),?,?,?,?)";
		return db.update(query, s.getOpzione1(),s.getOpzione2(),s.getOpzione3(),p.getId()+"");
	}
	
	@Override
	public boolean updateUtente(Soluzione s) {
		String query = "update soluzioni set opzione1 = ?,opzione2 = ?,opzione3 = ? where id_esercizio = ?";
		return db.update(query, s.getOpzione1(),s.getOpzione2(),s.getOpzione3(), s.getIdEsercizio() + "");
		}

}
