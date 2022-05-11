<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/homepage.css">
<link rel="stylesheet" href="../CSS/nuovoesercizio.css">
<link rel="stylesheet" href="../CSS/home-media-nuovoesercizio.css">
<title>Add new exercise</title>
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
			<a href="homepage.jsp">
				<img style="width: 14rem; height: 3rem; margin: 0 10px;" src="../materiali/LOGOicona2.png" alt="logo">
			</a>
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
					<li><a href="">Profile</a></li>
					<li><a href="">Add a new exercise</a></li>
					<li><a href=<%=request.getContextPath()+"/logout" %>>Logout</a></li>
				</ul>
			</div>
		</div>
	</section>
	<section id="sezione">
		<div>Add a new exercise</div>
	</section>
	<form action="/GearsOfCode/nuovoesercizio">
		<input type="hidden" name="comando" value="nuovoesercizio">
		<input type="hidden" name="idUtente" value=<%=utenteLoggato.getId()%>>

		<div id="linguaggio">
			<div class="comando">Insert a programming language</div>
			<!--  <input type="text" name="linguaggio" autocomplete="off"> -->
			<select name="linguaggio">
				<option value="Java" selected="selected">Java</option>
				<option value="PHP">PHP</option>
				<option value="C">C</option>
				<option value="JavaScript">JavaScript</option>
				<option value="Python">Python</option>
			</select>
		</div>
		<div id="titolo">
			<div class="comando">Insert a title</div>
			<input type="text" name="titolo" autocomplete="off">
		</div>
		<!--  
		<div id="livello">
			<div class="comando">Insert a level</div>
			<input type="text" name="livello" autocomplete="off">
		</div>
		-->
		<div id="scelta-livello">
			<div class="comando">Insert a level</div>
			<!--  <input type="text" name="linguaggio" autocomplete="off"> -->
			<select name="livello" id="select-livello">
				<option value="1" selected="selected">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
			</select>
		</div>
		<div id="corpo">
			<div class="comando">Insert your task</div>
			<textarea type="text" name="corpo" autocomplete="off" rows="4"
				cols="50"> </textarea>
		</div>
		<div id="soluzione1">
			<div class="comando">Insert a right option</div>
			<textarea type="text" name="opzione1" autocomplete="off" rows="4"
				cols="50"> </textarea>
		</div>
		<div id="soluzione2">
			<div class="comando">Insert a wrong option</div>
			<textarea type="text" name="opzione2" autocomplete="off" rows="4"
				cols="50"> </textarea>
		</div>
		<div id="soluzione3">
			<div class="comando">Insert another wrong option</div>
			<textarea type="text" name="opzione3" autocomplete="off" rows="4"
				cols="50"> </textarea>
		</div>
		
		<br> <input id="send-esercizio" type="submit" value="Send">
	</form>

</body>

</html>