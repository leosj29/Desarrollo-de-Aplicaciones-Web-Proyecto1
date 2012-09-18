<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Detalle de Medidor</h2>
  <% Map medidor = (Map)request.getAttribute("medidor"); %>
  <%  List lecturas = (List)request.getAttribute("lecturas"); %>
  <form name="ActualizarMedidor" action="/acueducto/actualizarMedidor" method="get">
  <input type="hidden" name="id" value="<%= medidor.get("id") %>"/>
  <table>
    <tr>
		<td>Material:</td><td><input class="input_txt" type="text" name="material" value="<%= medidor.get("material") %>"/></td>
	</tr>
    <tr>
		<td>Marca:</td><td><input class="input_txt" type="text" name="marca" value="<%= medidor.get("marca") %>"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= medidor.get("tipo") %>"/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro"  value="<%= medidor.get("diametro") %>"/></td>
	</tr>
    <tr>
		<td>Presi&oacute;n de trabajo:</td><td><input class="input_txt" type="text" name="presionTrabajo" value="<%= medidor.get("presionTrabajo") %>"/></td>
	</tr>
	<tr>
		<td>Fecha de instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value="<%= medidor.get("fechaInstalacion") %>"/></td>
	</tr>
	<tr>
		<td>Fecha de &uacute;ltima inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value="<%= medidor.get("fechaUltimaInspeccion") %>"/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value="<%= medidor.get("estado") %>"/></td>
	</tr>	
    <tr><td></td><td><input class="btn_blue" type="submit" value="Actualizar" /></td></tr>
  </table>
  </form>
  <br/><br/>
  <h2>Listado de &uacute;ltimas 10 lecturas</h2>	
	<% if(lecturas.size() > 0) { %>	
		<table class="tablalista">
			<tr><th>Fecha</th><th>Medici&oacute;n</th><th>Responsable</th><th>N&uacute;mero de lectura</th></tr>
			<% for(int i = 0, n = lecturas.size(); i < n; i++) {
			Map lectura = (Map) lecturas.get(i); %>
			<tr><td><%= lectura.get("fecha") %></td>
			<td><%= lectura.get("medicion") %></td>
			<td><%= lectura.get("responsable") %></td>
			<td><%= lectura.get("numeroLectura") %></td>
			</tr>
			<% } %>
		</table>	
	<% }else{ %>
		<h2>No posee lecturas registradas....</h2>
	<% } %>	
</html>