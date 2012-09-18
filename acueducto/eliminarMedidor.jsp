<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Eliminar Medidor</h2>
  <% Map medidor = (Map)request.getAttribute("medidor"); %>
  <form name="BorrarMedidor" action="/acueducto/borrarMedidor" method="get">
  <input type="hidden" name="id" value="<%= medidor.get("id") %>"/>
  <table>
    <tr>
		<td>Material:</td><td><input class="input_txt" type="text" name="material" value="<%= medidor.get("material") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Marca:</td><td><input class="input_txt" type="text" name="marca" value="<%= medidor.get("marca") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= medidor.get("tipo") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro"  value="<%= medidor.get("diametro") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Presi&oacute;n de trabajo:</td><td><input class="input_txt" type="text" name="presionTrabajo" value="<%= medidor.get("presionTrabajo") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Fecha de instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value="<%= medidor.get("fechaInstalacion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Fecha de &uacute;ltima inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value="<%= medidor.get("fechaUltimaInspeccion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value="<%= medidor.get("estado") %>" readonly="true"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>
