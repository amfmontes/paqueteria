<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<p><h2>Reg�strese para realizar un pedido</h2></p>
<form action="Entrega" method="post">
Nombre: <input type="text" name="nombre"></br></br>
Contrase�a: <input type="password" name="password"></br></br>
E-mail: <input type="text" name="mail"></br></br>
<input type="submit" value="Entrar"></br></br>
</form>

<p><strong>Tambi�n puede reg�strarse con su cuenta de Twitter para realizar un pedido</strong></p>
<form action="Entrega" method="post">
	<input type="submit" value="Registro en Twitter">

</form>
<br>
<hr>
<p>Si no tiene cuenta Twitter, puede cre�rsela <a href="https://twitter.com/?lang=es">aqu�</a></p>

</body>
</html>