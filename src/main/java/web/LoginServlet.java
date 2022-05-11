package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOPersone;
import interfaces.IDAOPersone;
@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "LoginServlet", value = "")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IDAOPersone ip = new DAOPersone("gearsofcode");

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramUsername = request.getParameter("username");
		String paramPassword = request.getParameter("password");
		
		if(ip.login(paramUsername, paramPassword)) {
			// se l'autenticazione va a buon fine

			// recupero la sessione corrente
			HttpSession oldSession = request.getSession(false);
			if(oldSession != null) {
				oldSession.invalidate(); //invalida la sessione se esiste
			}

			HttpSession currentSession = request.getSession(); // creo una nuova sessione
			currentSession.setAttribute("user", paramUsername);
			currentSession.setMaxInactiveInterval(5*60); // 5 minuti di inattività massima

			response.sendRedirect("viste/HTML/homepage.jsp"); // vai alla pagina success.jsp

		} else {
			// Se l'autenticazione fallisce
			response.sendRedirect("viste/HTML/sign-in.jsp");
		}

	}
}
