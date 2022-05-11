package interfaces;
import java.util.*;


import entities.*;

public interface IDAOPersone
{
	List<Map<String, String>> read();
	boolean create(Persona p);
	boolean delete(int id);
	boolean update(Persona p);
	List<Map<String, String>> loginDB(String username, String password);
	boolean updateLogin(Persona p);
	boolean updatePuntiUtente(Persona p, Esercizio e, int punti);
	List<Map<String, String>> giaFatto(Persona p);
	
	default String stampaLista(List<Map<String, String>> lista)
	{
		String ris = "";
		Persona p;
		for(Map<String, String> m : lista)
		{
			p = new Persona(m);
			ris += p.toString();
		}
		return ris;
	}

	default boolean login(String username, String password) {

		boolean accedi = false;
		if(loginDB(username,password).size() > 0) {
			if(loginDB(username,password).get(0).get("username").equalsIgnoreCase(username) &&
					loginDB(username,password).get(0).get("pwd").equalsIgnoreCase(password)) {
				accedi = true;
				System.out.println("Benvenuto");
			}
			else {
				System.out.println("Username e/o Password ERRATI");
			}
		} else {
			System.out.println("Nessuna corrispondenza trovata");
		}
		return accedi;
	}
	
	default List<Persona> elencoPersone(){
		List<Persona> ris = new ArrayList<Persona>();
		Persona p;
		for (Map<String,String> m : read()) {
			p = new Persona(m);
			ris.add(p);
		}

		return ris;
	}

	default Persona cercaPerId(int id) {
		Persona p = null;
		for (Persona pe : elencoPersone()) 
			if(pe.getId() == id)
				p = pe;
		return p;
	}

	
	
	
}