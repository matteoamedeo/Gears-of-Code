<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/homepage.css">
<link rel="stylesheet" href="../CSS/home-media.css">
<title>JSP Page</title>
</head>
<body>
	<!-- CODICE JAVA -->
	<%@page import="entities.Persona"%>
	<%@page import="dao.DAOPersone"%>
	<%@page import="interfaces.IDAOPersone"%>
	<%
	String user = null;
	IDAOPersone ip = new DAOPersone("gearsofcode");
	Persona utenteLoggato = null;

	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	} else {
		user = (String) session.getAttribute("user");
		ip.read();
		for (Persona p : ip.elencoPersone())
			if (user.equals(p.getUsername()))
		utenteLoggato = p;
	}
	%>
	<%
	String livello = "";
	livello = (String) session.getAttribute("livello");
	%>
	<!-- CODICE JAVA -->

	<section id="top">
		<div id="logo">
			<img src="../materiali/LOGOicona2.png" alt="">
			<!--   <div id="nome">Gears of Code</div> -->
		</div>
		<div id="dropdown">
			<div id="profilo">
				<div id="nome-utente">
					<span id="utente-loggato"><%=utenteLoggato.getUsername()%></span>
				</div>
				<div id="livello">
					<img class="livello-utente-loggato"
						src=<%="../materiali/Level" + utenteLoggato.getLivello() + ".png"%>
						alt="" title=<%=utenteLoggato.getLivello()%>>
				</div>
				<div id="punti"><%=utenteLoggato.getPunteggio()%></div>
				<div id="idUtente" style="display: none;"><%=utenteLoggato.getId()%></div>
			</div>
			<div id="top-menu">
				<ul>
					<li><a href="../HTML/profilo.jsp">Profile</a></li>
					<li><a href="../HTML/nuovoesercizio.jsp"
						id="aggiungi-esercizio">Add a new exercise</a></li>
					<li><a href=<%=request.getContextPath() + "/logout"%>>Logout</a></li>
				</ul>
			</div>
		</div>
	</section>
	<section id="content">
		<div id="scelta-livello">
			<ul>
				<li class="livello-selezionato" value="1" onclick="scegliLivello()">level
					1</li>
				<li value="2" onclick="scegliLivello()">level 2</li>
				<li value="3" onclick="scegliLivello()">level 3</li>
			</ul>
		</div>
		<div id="liste">
			<div id="lista-linguaggi">
				<ul id="ul-linguaggi">
					<li class="linguaggio-selezionato" onclick="scegliLinguaggio()"><a
						href="">Java</a></li>
					<li onclick="scegliLinguaggio()"><a href="#">JavaScript</a></li>
					<li onclick="scegliLinguaggio()"><a href="#">C</a></li>
					<li onclick="scegliLinguaggio()"><a href="#">PHP</a></li>
					<li onclick="scegliLinguaggio()"><a href="#">Python</a></li>
				</ul>
				<ul id="ul-banners">
					<li class="annunci-lavoro">CAREER OPPORTUNITIES</li>
					<li><img src="../materiali/generation.jpg" alt="">
						<div>Left Field Labs is hiring a Back End Engineer/Developer</div>
					</li>
					<li><img src="../materiali/Intesa-san-paolo.png" alt="">
						<div>The Intesa Sanpaolo Group is one of the leading banking groups in Europe</div></li>
				</ul>
			</div>

			<div id="side-bar">
				<div class="barre-menu"></div>
				<div class="barre-menu"></div>
				<div class="barre-menu"></div>
			</div>

			<div id="lista-esercizi">
			<form action="/GearsOfCode/eseguiesercizio" name="inviaId">
			<input type="hidden" name="idUtente" value=<%=utenteLoggato.getId() %>>
			</form>

				<ul>

				</ul>

			</div>
	</section>

	<footer>
		<div id="marchio" class="footer">© 2022 Gears of Code</div>
		<a href="#" class="footer">About</a> 
		<a href="https://www.instagram.com/gears_of_code/" class="footer"> <img src="../materiali/instagram.ico" alt="" width="22px" height="22px"></a>
		<!--  <a href="" class="footer"><img src="../materiali/facebook.png" alt="" width="22px" height="22px"></a>-->


	</footer>

	<!--  <script src="../JavaScript/homepage.js"></script>-->
	<script src="../JavaScript/homepage.js"></script>
</body>
</html>