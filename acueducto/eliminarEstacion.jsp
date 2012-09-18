<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Eliminar Estaci&oacute;n</h2>
  <% Map estacion = (Map)request.getAttribute("estacion"); %>
  <form name="BorrarEstacion" action="/acueducto/borrarEstacion" method="get">
  <input type="hidden" name="id" value="<%= estacion.get("id") %>"/>
  <table>
    <tr>
		<td>Presi&oacute;n entrada:</td><td><input class="input_txt" type="text" name="presionEntrada" value="<%= estacion.get("presionEntrada") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Presi&oacute;n salida:</td><td><input class="input_txt" type="text" name="presionSalida"  value="<%= estacion.get("presionSalida") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= estacion.get("tipo") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima:</td><td><input class="input_txt" type="text" name="capacidadMaxima" value="<%= estacion.get("capacidadMaxima") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Capacidad bombas:</td><td><input class="input_txt" type="text" name="cantidadBombas" value="<%= estacion.get("cantidadBombas") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Encargado:</td><td><input class="input_txt" type="text" name="encargadoEstacion" value="<%= estacion.get("encargadoEstacion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Tel&eacute;fono:</td><td><input class="input_txt" type="text" name="telefono" value="<%= estacion.get("telefono") %>" readonly="true"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>
