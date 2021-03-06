package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOEsercizi;
import dao.DAOPersone;
import dao.DAOSoluzioni;
import entities.Persona;
import interfaces.IDAOEsercizi;
import interfaces.IDAOLoggato;
import interfaces.IDAOPersone;
import interfaces.IDAOSoluzioni;
import main.JavaMailUtil;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(
		urlPatterns = { "/profilo" }, 
		initParams = { 
				@WebInitParam(name = "Profilo", value = "")
		})
public class Profilo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static IDAOPersone ip = new DAOPersone("gearsofcode");
	static IDAOEsercizi ie = new DAOEsercizi("gearsofcode");
	static IDAOSoluzioni is = new DAOSoluzioni("gearsofcode");
	static IDAOLoggato il = new DAOPersone("gearsofcode");
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramUsername = request.getParameter("username");
		String paramPassword = request.getParameter("password");
		Persona p = ip.cercaPerId(Integer.parseInt(request.getParameter("idUtente")));
		
		p.setUsername(request.getParameter("username"));
		p.setPassword(request.getParameter("password"));
		p.setEmail(request.getParameter("email"));
		
		ip.updateLogin(p);
		HttpSession currentSession = request.getSession(); // creo una nuova sessione
		currentSession.setAttribute("user", paramUsername);
		currentSession.setMaxInactiveInterval(5*60); // 5 minuti di inattivitą massima
		// CREARE METODO 
		JavaMailUtil.inviaCambioMail(p.getEmail(), p.getUsername());
		response.sendRedirect("viste/HTML/homepage.jsp");
		
		
	}

}
