<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Eliminar Tanque</h2>
  <% Map tanque = (Map)request.getAttribute("tanque"); %>
  <form name="BorrarTanque" action="/acueducto/borrarTanque" method="get">
  <input type="hidden" name="id" value="<%= tanque.get("id") %>"/>
  
  <table>
    <tr>
		<td>Capacidad:</td><td><input class="input_txt" type="text" name="capacidad" value="<%= tanque.get("capacidad") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Material:</td><td><input class="input_txt" type="text" name="material"  value="<%= tanque.get("material") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= tanque.get("tipo") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Fecha Instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value="<%= tanque.get("fechaInstalacion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Fecha Ultima Inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value="<%= tanque.get("fechaUltimaInspeccion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value="<%= tanque.get("estado") %>" readonly="true"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>
