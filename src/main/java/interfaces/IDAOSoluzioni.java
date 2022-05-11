package interfaces;
import java.util.*;
import entities.*;

public interface IDAOSoluzioni
{
	List<Map<String, String>> read();
	boolean create(Soluzione s);
	boolean delete(int id);
	boolean update(Soluzione s);
	boolean createUtente(Soluzione s, Persona p);
	boolean updateUtente(Soluzione s);
	
	
	default String stampaLista(List<Map<String, String>> lista)
	{
		String ris = "";
		Soluzione s;
		for(Map<String, String> m : lista)
		{
			s = new Soluzione(m);
			ris += s.toString();
		}
		return ris;
	}

	//Scrivo il metodo che trasformerà l'elenco di mappe
	//	in un elenco mdi oggetti di tipo Persona
	default List<Soluzione> elencoSoluzioni(){
		List<Soluzione> ris = new ArrayList<Soluzione>();
		Soluzione s;
		for (Map<String,String> m : read()) {
			s = new Soluzione(m);
			ris.add(s);
		}

		return ris;
	}

	//creo un metodo di default che permette di ircavare un oggetto Persona partendo dall'id
	default Soluzione cercaPerId(int id) {
		Soluzione s = null;
		for (Soluzione so : elencoSoluzioni()) 
			if(so.getIdEsercizio() == id)
				s = so;
		return s;
	}


}