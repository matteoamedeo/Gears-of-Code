<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/sign-in.css">
    <title id="titolo-pagina">Login</title>
</head>

<body>

    <section id="login-wrapper">
        <img id="logo-img" src="../materiali/LOGOicona2.png" alt="logo">
        <section id="credenziali">
            <h2 id="account" style="color: white">Please login</h2>
            <form action=<%=request.getContextPath()+"/login"%> method="POST">
            <p id="nome">
                Username
                <input type="text" id="inpNomeUtente" placeholder="your username" name="username" required style="color: black;">
            </p>
            <p id="password">
                Password
                <input type="password" id="password" name="password" placeholder="your password" style="color: black;">
            </p>
            <div id="invia">
                <button class=".btn-grad button-default" type="submit" name="login">
                    <a>Sign-in</a>
                </button>
            </div>
            </form>
        </section>
    </section>

</body>

</html>