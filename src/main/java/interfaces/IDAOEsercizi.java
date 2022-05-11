package interfaces;
import java.util.*;
import entities.*;

public interface IDAOEsercizi
{
	List<Map<String, String>> read();
	boolean create(Esercizio e);
	boolean delete(int id);
	boolean update(Esercizio e);
	List<Map<String, String>> ricerca(String linguaggio, int livello);
	boolean createUtente(Esercizio e,Persona p);
	boolean updateUtente(Esercizio e, Persona p);
	
	default String stampaLista(List<Map<String, String>> lista)
	{
		String ris = "";
		Esercizio e;
		for(Map<String, String> m : lista)
		{
			e = new Esercizio(m);
			ris += e.toString();
		}
		return ris;
	}

	//Scrivo il metodo che trasformerà l'elenco di mappe
	//	in un elenco mdi oggetti di tipo Persona
	default List<Esercizio> elencoEsercizi(){
		List<Esercizio> ris = new ArrayList<Esercizio>();
		Esercizio e;
		for ( Map<String,String> m : read() ) {
			e = new Esercizio(m);
			ris.add(e);
		}

		return ris;
	}

	//creo un metodo di default che permette di ircavare un oggetto Persona partendo dall'id
	default Esercizio cercaPerId(int id) {
		Esercizio e = null;
		for (Esercizio es : elencoEsercizi()) 
			if(es.getId() == id)
				e = es;
		return e;
	}
	
	default List<Map<String, String>> eserciziLinguaLivello(String linguaggio, int livello){
		List<Map<String, String>> elenco = ricerca(linguaggio,livello);
		return elenco;
	}
	

}