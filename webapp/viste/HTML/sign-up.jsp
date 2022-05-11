<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/sign-up.css">
<title id="titolo-pagina">Login</title>
</head>

<body>

	<section id="login-wrapper">
		<form action="/GearsOfCode/registrazione">
			<h2 class="logo">
				<img src="../materiali/LOGOicona2.png" alt="">
			</h2>
			<section id="credenziali">
				<h2 id="account" style="color: white;">New account</h2>
				<p id="nome">
					Username <input type="text" id="inpNomeUtente" placeholder=""
						name="username" required>
				</p>
				<p id="mail">
					E-mail <input id="inpEmail" type="text" placeholder="" name="email" required>
				</p>
				<p id="password">
					Password <input type="password" id="inpPassword" name="password"
						placeholder="6 characters minimum" minlength="6">
				</p>
				<div id="pass-descrizione">
					<ion-icon name="information-circle-outline"></ion-icon>
					<!-- Le password devono essere composte &ensp; &ensp; almeno da 6 caratteri. -->
					password must be at least 6 characters
				</div>
				<p id="verifica-password">
					Repeat password <input type="password" id="ver-password" name="pwd"
						minlength="6">
				</p>

				<div id="invia">
					<button class=".btn-grad button-default" type="submit">
						Register
					</button>
				</div>
		</form>

	</section>


	</section>





	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	
</body>

</html>