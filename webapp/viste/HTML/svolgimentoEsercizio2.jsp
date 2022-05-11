<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/svolgimentoEsercizio2.css">
<link rel="stylesheet" href="../CSS/home-media.css">
<title>Test exercise</title>
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
			<img src="../materiali/LOGOicona2.png" alt="">
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
					<li><a href="../HTML/nuovoesercizio.jsp"
						id="aggiungi-esercizio">Add a new exercise</a></li>
					<li><a href=<%=request.getContextPath() + "/logout"%>>Logout</a></li>
				</ul>
			</div>
		</div>
	</section>
	<div id="esercizio-wrapper">
		<div name="" id="corpo">Your task is to make two functions (max
			and min, or maximum and minimum, etc., depending on the language)
			that receive a list of integers as input and return, respectively,
			the largest and lowest number in that list. Examples (Input ->
			Output) * [4,6,2,1,9,63,-134,566] -> max = 566, min = -134 * [-52,
			56, 30, 29, -54, 0, -110] -> min = -110, max = 56 * [42, 54, 65, 87,
			0] -> min = 0, max = 87 * [5] -> min = 5, max = 5 Notes You may
			consider that there will not be any empty arrays/vectors.</div>
		<div id="scegli">Choose the right option</div>

		<div id="opzioni">
			<div id="opzione1">
				  <input type="radio" id="opzione1" name="[opzione]"
					value="opzione1">   <label for="opzione">int
					min(const int *arr, int len) { int min = *arr; while (--len) if
					(min > *(arr+len)) min = *(arr+len); return min; } int max(const
					int *arr, int len) { int max = *arr; while (--len) if (max <
					*(arr+len)) max=*(arr+len); return max; }</label> <br>
			</div>
			<div id="opzione2">

				  <input type="radio" id="opzione2" name="[opzione]"
					value="opzione2">   <label for="opzione"> { int
					min = *arr; while (--len) if (min > *(arr+len)) min = *(arr+len);
					return min; } int max(const int *arr, int len) { int max = *arr;
					while (--len) if (max < *(arr+len)) max=*(arr+len); return max; }</label> <br>
			</div>
			<div id="opzione3">
				  <input type="radio" id="opzione3" name="[opzione]"
					value="opzione3">   <label for="opzione"> { int
					min = *arr; while (--len) if (min > *(arr+len)) min = *(arr+len);
					return min; } int max(const int *arr, int len) { int max = *arr;
					while (--len) if (max < *(arr+len)) max=*(arr+len); return max; }</label>
			</div>
			<br>
		</div>

		<div id="bottoni">
			<button id="invia" type="submit" value="Test">Test</button>
			<a href="homepage.jsp"><button id="forfait" type="submit" value="Test">Forfait</button></a>
		</div>

		<form action="/GearsOfCode/risultatoesercizio">
			<input type="hidden" name="risultatoesercizio" value="false" autocomplete="off"> 
			<input type="hidden" name="idUtente" value=<%=utenteLoggato.getId()%> autocomplete="off"> 
			<input type="hidden" name="idEsercizio"  autocomplete="off"> 
			<input id="inviarisultato" type="submit" value="Send result">
		</form>
	</div>
	<div id="risultatoEsatto">Success!</div>
	<div id="risultatoErrato">You failed</div>

	
</body>

</html>