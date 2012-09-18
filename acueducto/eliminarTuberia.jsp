<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Eliminar Tuber&iacute;a</h2>
  <% Map tuberia = (Map)request.getAttribute("tuberia"); %>
  <form name="BorrarTuberia" action="/acueducto/borrarTuberia" method="get">
  <input type="hidden" name="id" value="<%= tuberia.get("id") %>"/>  
  <table>
    <tr>
		<td>Material:</td><td><input class="input_txt" type="text" name="material" value="<%= tuberia.get("material") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro"  value="<%= tuberia.get("diametro") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= tuberia.get("tipo") %>" readonly="true"/></td>
	</tr>
    <tr>
		<td>Largo:</td><td><input class="input_txt" type="text" name="largo" value="<%= tuberia.get("largo") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Presi&oacute;n m&aacute;xima:</td><td><input class="input_txt" type="text" name="presionMaxima" value="<%= tuberia.get("presionMaxima") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Fecha Instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value="<%= tuberia.get("fechaInstalacion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Fecha Ultima Inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value="<%= tuberia.get("fechaUltimaInspeccion") %>" readonly="true"/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value="<%= tuberia.get("estado") %>" readonly="true"/></td>
	</tr>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Eliminar" /></td></tr>
  </table>
  </form>
</html>
