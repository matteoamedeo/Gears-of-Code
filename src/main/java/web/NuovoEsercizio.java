package web;

import java.io.IOException;
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
import rest.Api;
import utilities.Utility;


@WebServlet(
		urlPatterns = { "/nuovoesercizio" }, 
		initParams = { 
				@WebInitParam(name = "NuovoEsercizio", value = "")
		})
public class NuovoEsercizio extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	
	static IDAOPersone ip = new DAOPersone("gearsofcode");
	static IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	static IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	static IDAOLoggato il = new DAOPersone("gearsofcode");
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		Esercizio e = new Esercizio();
 		e.setLinguaggio( request.getParameter("linguaggio") );
 		e.setTitolo(request.getParameter("titolo"));
 		e.setLivello( Integer.parseInt(request.getParameter("livello")));
 		e.setCorpo(e.getTitolo());

 		// CORPO SARÁ IL TESTO DELL'ESERCIZIO
 		String corpo = request.getParameter("corpo");

 		// Creo l'oggetto Soluzione
 		Soluzione s = new Soluzione();
 		s.setOpzione1(e.getCorpo().replace(".txt", "") + "_opzione1.txt");
 		s.setOpzione2(e.getCorpo().replace(".txt", "") + "_opzione2.txt");
 		s.setOpzione3(e.getCorpo().replace(".txt", "") + "_opzione3.txt");

 		// LE OPZIONI SARANNO I TESTI DELLE SOLUZIONI
 		String opzione1 = request.getParameter("opzione1");
 		String opzione2 = request.getParameter("opzione2");
 		String opzione3 = request.getParameter("opzione3");

 		// CONTROLLO CHE LA PERSONA INDICATA SIA LIVELLO 3 E SE SI CREO ESERCIZI E SOLUZIONI

 		Persona p = new Persona();

 		// DA MODIFICARE IL NUMERO CON L'ID DELL'UTENTE PRESO DAL WEB
 		p = ip.cercaPerId( Integer.parseInt(request.getParameter("idUtente")) ); 

 		boolean posso = il.creaEsercizioLv3(p, e, s);

 		if (posso == true) {
 			Utility.writeEsercizio(e.getLinguaggio(),e.getLivello(),e.getCorpo(), corpo );
 			Utility.writeSoluzione(e.getLinguaggio(),e.getLivello(),e.getCorpo(),e.getId(),opzione1,opzione2,opzione3 );	
 			System.out.println("Esercizio Creato");
 		}
 		else {
 			System.out.println("Esercizio NON Creato");
 		}
 		String ris = Api.esercizi_soluzioniToJSON() +"";
		//response.getWriter().append(ris);
		response.sendRedirect("viste/HTML/homepage.jsp");
	}
}
