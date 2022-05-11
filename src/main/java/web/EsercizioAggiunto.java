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
		urlPatterns = { "/esercizioaggiunto" }, 
		initParams = { 
				@WebInitParam(name = "EsercizioAggiunto", value = "")
		})
public class EsercizioAggiunto extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static IDAOPersone ip = new DAOPersone("gearsofcode");
	static IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	static IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	static IDAOLoggato il = new DAOPersone("gearsofcode");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ris = Api.esercizi_soluzioniToJSON() +"";
		response.getWriter().append(ris);
		response.sendRedirect("viste/HTML/homepage.jsp");
		
	}
}
