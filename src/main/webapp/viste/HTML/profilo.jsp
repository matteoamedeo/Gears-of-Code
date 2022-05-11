<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/profilo.css">
<title>Profilo</title>
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
			<a href="homepage.jsp"><img  src="../materiali/LOGOicona2.png" alt="logo"></a>
			<!-- <div id="nome">Gears of Code</div> -->
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
	<section id="profilo-utente">
		<div id="descrizione-pagina">
			<h3>This is your Profile</h3>
			<h5>here you can edit your credentials</h5>
		</div>

		<div id="descrizione-dati">
			<div id="dati">
				<form action="/GearsOfCode/profilo">
					<p id="nome">
						<label for="">Username:</label> 
						<input type="text"
							id="inpNomeUtente" placeholder="" name="username"
							readonly="readonly" value=<%=utenteLoggato.getUsername()%>>
					</p>
					<p id="password">
						<label for="">Password:</label> 
						<input type="password"
							id="inputPassword" name="password"
							placeholder="6 characters minimum" minlength="6"
							readonly="readonly" value=<%=utenteLoggato.getPassword()%>>
					</p>
					<p id="mail">
						<label for="">E-mail:</label> 
						<input type="text" id="inputEmail"
							placeholder="" name="email" readonly="readonly"
							value=<%=utenteLoggato.getEmail()%>>
					</p>
					<p id="livello-utente">
						<label for="">level:</label> <span><%=utenteLoggato.getLivello()%></span>
					</p>
					<p id="punti-utente">
						<label for="">level points:</label> <span><%=utenteLoggato.getPunteggio()%></span>
					</p>
			</div>
			<div id="bottoni">
			<input type="hidden" name="idUtente" value=<%=utenteLoggato.getId()%>>
				<button type="submit" id="invia-modifiche" disabled>Confirm</button>
				</form>
			<button type="text" id="edit">Edit</button>

			</div>
		</div>
		<div id="video">
			<video src="../materiali/video2.mp4" width="768" height="520"
				name="media" autoplay loop muted> Il browser non supporta il
				tag video
			</video>
		</div>

	</section>
	<footer>
		<div id="marchio" class="footer">© 2022 Gears of Code</div>
		<a href="" class="footer">About</a> <a
			href="https://www.instagram.com/gears_of_code/" class="footer"><img
			src="../materiali/instagram.ico" alt="" width="22px" height="22px"></a>
	</footer>

	<script src="../JavaScript/profilo.js"></script>
</body>

</html>