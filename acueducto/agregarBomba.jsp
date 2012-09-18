<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <% List pozos = (List)request.getAttribute("pozos"); %>
  <h2>Agregar Bomba</h2>
  <form name="InsertarBomba" action="/acueducto/insertarBomba" method="get">
  <table>
    <tr>
		<td>Marca:</td><td><input class="input_txt" type="text" name="marca" value=""/></td>
	</tr>
	<tr>
		<td>Modelo:</td><td><input class="input_txt" type="text" name="modelo" value=""/></td>
	</tr>
	<tr>
		<td>Capacidad:</td><td><input class="input_txt" type="text" name="capacidad" value=""/></td>
	</tr>	
	<tr>
		<td>Fecha instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value=""/></td>
	</tr>	
	<tr>
		<td>Fecha &uacute;ltimo mantenimiento:</td><td><input class="input_txt" type="text" name="fechaUltimoMantenimiento" value=""/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value=""/></td>
	</tr>	
	<tr><td>Pozo:</td>
		<td>
			<select name="idPozo"> 
				<% for(int i = 0, n = pozos.size(); i < n; i++) {
				Map pozo = (Map) pozos.get(i); %>		
				<option value="<%= pozo.get("id") %>"> <%= pozo.get("id") %> </option>		
				<% } %>
			</select>
		</td></tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Agregar" /></td></tr>
  </table>
  </form>
</html>
