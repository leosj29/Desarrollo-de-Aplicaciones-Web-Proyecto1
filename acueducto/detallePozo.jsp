<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Detalle de Pozo</h2>
  <% Map pozo = (Map)request.getAttribute("pozo"); %>
  <% List bombas = (List)request.getAttribute("bombas"); %>
  <form name="ActualizarPozo" action="/acueducto/actualizarPozo" method="get">
  <input type="hidden" name="id" value="<%= pozo.get("id") %>"/>
  <table>
    <tr>
		<td>Profundidad:</td><td><input class="input_txt" type="text" name="profundidad" value="<%= pozo.get("profundidad") %>"/></td>
	</tr>
    <tr>
		<td>Revestimiento:</td><td><input class="input_txt" type="text" name="tipoRevestimiento"  value="<%= pozo.get("tipoRevestimiento") %>"/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro" value="<%= pozo.get("diametro") %>"/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima epoca seca:</td><td><input class="input_txt" type="text" name="capacidadMaximaEpocaSeca" value="<%= pozo.get("capacidadMaximaEpocaSeca") %>"/></td>
	</tr>
	<tr>
		<td>Capacidad m&aacute;xima epoca lluviosa:</td><td><input class="input_txt" type="text" name="capacidadMaximaEpocaLLuviosa" value="<%= pozo.get("capacidadMaximaEpocaLLuviosa") %>"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Actualizar" /></td></tr>
  </table>
  </form>
  <br/><br/>
  <h2>Listado de bombas</h2>	
	<% if(bombas.size() > 0) { %>	
		<table class="tablalista">
			<tr><th>Marca</th><th>Modelo</th><th>Capacidad</th><th>Fecha instalaci&oacute;n</th><th>Fecha &uacute;ltimo mantenimiento</th><th>Estado</th></tr>
			<% for(int i = 0, n = bombas.size(); i < n; i++) {
			Map bomba = (Map) bombas.get(i); %>
			<tr><td><%= bomba.get("marca") %></td>
			<td><%= bomba.get("modelo") %></td>
			<td><%= bomba.get("capacidad") %></td>
			<td><%= bomba.get("fechaInstalacion") %></td>
			<td><%= bomba.get("fechaUltimoMantenimiento") %></td>
			<td><%= bomba.get("estado") %></td>	
			<td class="tdnoborder"><a href='/acueducto/detalleBomba?tp=4&id=<%= bomba.get("id") %>'>
			<input class="btn_blue" type="submit" value="Detalle"/></a></td>
			</tr>
			<% } %>
		</table>	
	<% }else{ %>
		<h2>No posee bombas asignados....</h2>
	<% } %>	
</html>