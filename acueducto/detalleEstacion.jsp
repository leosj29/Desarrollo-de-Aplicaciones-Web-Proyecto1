<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Detalle de Estaci&oacute;n</h2>
  <% Map estacion = (Map)request.getAttribute("estacion"); %>
  <form name="ActualizarEstacion" action="/acueducto/actualizarEstacion" method="get">
  <input type="hidden" name="id" value="<%= estacion.get("id") %>"/>
  <table>
    <tr>
		<td>Presi&oacute;n entrada:</td><td><input class="input_txt" type="text" name="presionEntrada" value="<%= estacion.get("presionEntrada") %>"/></td>
	</tr>
    <tr>
		<td>Presi&oacute;n salida:</td><td><input class="input_txt" type="text" name="presionSalida"  value="<%= estacion.get("presionSalida") %>"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= estacion.get("tipo") %>"/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima:</td><td><input class="input_txt" type="text" name="capacidadMaxima" value="<%= estacion.get("capacidadMaxima") %>"/></td>
	</tr>
	<tr>
		<td>Capacidad bombas:</td><td><input class="input_txt" type="text" name="cantidadBombas" value="<%= estacion.get("cantidadBombas") %>"/></td>
	</tr>
	<tr>
		<td>Encargado:</td><td><input class="input_txt" type="text" name="encargadoEstacion" value="<%= estacion.get("encargadoEstacion") %>"/></td>
	</tr>
	<tr>
		<td>Tel&eacute;fono:</td><td><input class="input_txt" type="text" name="telefono" value="<%= estacion.get("telefono") %>"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Actualizar" /></td></tr>
  </table>
  </form>
</html>