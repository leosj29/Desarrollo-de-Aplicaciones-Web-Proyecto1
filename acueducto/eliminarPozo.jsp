<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Eliminar Pozo</h2>
  <% Map pozo = (Map)request.getAttribute("pozo"); %>
  <form name="BorrarPozo" action="/acueducto/borrarPozo" method="get">
  <input type="hidden" name="id" value="<%= pozo.get("id") %>"/>
  <table>
    <tr>
		<td>Profundidad:</td><td><input class="input_txt" type="text" name="profundidad" value="<%= pozo.get("profundidad") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Revestimiento:</td><td><input class="input_txt" type="text" name="tipoRevestimiento"  value="<%= pozo.get("tipoRevestimiento") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro" value="<%= pozo.get("diametro") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima epoca seca:</td><td><input class="input_txt" type="text" name="capacidadMaximaEpocaSeca" value="<%= pozo.get("capacidadMaximaEpocaSeca") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Capacidad m&aacute;xima epoca lluviosa:</td><td><input class="input_txt" type="text" name="capacidadMaximaEpocaLLuviosa" value="<%= pozo.get("capacidadMaximaEpocaLLuviosa") %>" readonly="true"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>
