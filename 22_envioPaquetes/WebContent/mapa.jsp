<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Mapa de ruta</title>
</head>
<body>
<h2>Mapa de ruta</h2>
<p>Localización de los puntos de origen y destino y ruta a seguir</p>
<meta charset="utf-8">

<iframe
  width="600"
  height="450"
  frameborder="0" style="border:0"
  src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyBSBRmBc1ZYMrxuKjdkMdZkI8mX5S0Hx7s&origin=<%= session.getAttribute("origen") %>&destination=<%= session.getAttribute("destino") %>&avoid=tolls|highways">
</iframe>

  </body>

</html>