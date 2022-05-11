package web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOEsercizi;
import dao.DAOPersone;
import dao.DAOSoluzioni;
import entities.Esercizio;
import entities.Persona;
import entities.Soluzione;
import interfaces.IDAOEsercizi;
import interfaces.IDAOLoggato;
import interfaces.IDAOPersone;
import interfaces.IDAOSoluzioni;
import main.JavaMailUtil;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(
		urlPatterns = { "/risultatoesercizio" }, 
		initParams = { 
				@WebInitParam(name = "RisultatoEsercizio", value = "")
		})
public class RisultatoEsercizio extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static IDAOPersone ip = new DAOPersone("gearsofcode");
	static IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	static IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	static IDAOLoggato il = new DAOPersone("gearsofcode");
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String risultato = request.getParameter("risultatoesercizio");
		boolean risposta = false;
		if(risultato.equalsIgnoreCase("true"))
			risposta = true;
		
		Persona p = ip.cercaPerId(Integer.parseInt(request.getParameter("idUtente")));
		Esercizio e = ie.cercaPerId(Integer.parseInt(request.getParameter("idEsercizio")));
		int punti = e.getPunti();
		System.out.println("risultato: " + risultato);
		System.out.println("risposta: " + risposta);
		System.out.println("\n---------------");
		System.out.println("persona: " + p.toString());
		System.out.println("---------------\n");
		System.out.println("esercizio: " + e.toString());
		System.out.println("punti: " + punti);
		
		if( cercoSeFatto( e.getId(),p.getId() ) == true ) {
			punti = 0;
		}
		System.out.println("riga 61: " + il.isSoluzioneEsatta( p, e, punti , risposta ) );
		response.sendRedirect("viste/HTML/homepage.jsp");
		
	}
	
	public static boolean cercoSeFatto(int idEsercizio, int idPersona) {
		
		boolean fatto = false;
		
		Persona p = new Persona();
		// TROVO LA PERSONA CHE STA SVOLGENDO L'ESERCIZIO
		p = ip.cercaPerId(idPersona);		
		
		String elenco = "";
		
		// USO IL METODO giaFatto PER CREARE UN ARRAYLIST DI MAPPE
		// CONTENENTE UN ELENCO DI ESERCIZI COMPLETATI DALL'UTENTE
		for(Map<String,String> m : ip.giaFatto(p)) {
			elenco += m.values();
		}
		System.out.println("riga 81: " + elenco);
		
		// CREO UN VETTORE DALL'ELENCO
		String[] vettoreFatti = new String[elenco.split(",").length];
		
		// CICLO L'ELENCO E OGNI VALORE LO INSERISCO NELL'ARRAY
		for(int i = 0 ; i < vettoreFatti.length ; i++) {
			vettoreFatti[i] = elenco.split(",")[i];
		}
		
		int min = 0;
		int max = vettoreFatti.length-1;
		
		// ELIMINO LA "[" DAL PRIMO ELEMENTO E LA "]" DALL'ULTIMO
		vettoreFatti[min] = vettoreFatti[min].replace("[", "");
		vettoreFatti[max] = vettoreFatti[max].replace("]", "");

		// CON esercizio INDICO L'ESERCIZIO DESIDERATO 
		String esercizio = idEsercizio+"";
		
		// CERCO esercizio CICLANDO IL VETTORE
		for(int i = 0 ; i < vettoreFatti.length ; i++) {
			// STAMPO L'ESITO DEL CONFRONTO
			if(esercizio.equalsIgnoreCase(vettoreFatti[i])) {
				fatto = true;
				System.out.println("riga 106: " + fatto);
				break;
			}
			
		}
		return fatto;
	}
	
}