package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import interfaces.*;
import rest.Api;
import viste.GestoreTemplate;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String percorsoCartellaViste = "C:\\Users\\39327\\Desktop\\programmazione\\Intermedio\\GearsOfCode\\src\\main\\webapp\\viste\\HTML\\";
	
	GestoreTemplate GT = new GestoreTemplate(percorsoCartellaViste);
	
	static IDAOPersone ip = new DAOPersone("gearsofcode");
	static IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	static IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	static IDAOLoggato il = new DAOPersone("gearsofcode");

	
	Api apiEsercizi = new Api();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

		String comando = request.getParameter("comando");
		if(comando == null)
			comando = "home";
	
		String ris = "";
		
		switch (comando) {
		case "home":
			ris = GT.leggiHTML("loading.jsp");
			break;
		case "api":
			ris = apiEsercizi.eserciziToJSON() + "";
			break;
		case "apiEserciziSoluzioni":
			ris = Api.esercizi_soluzioniToJSON() + "";
			break;
	
		default:
			break;
		}
		response.getWriter().append(ris);
	}

}
