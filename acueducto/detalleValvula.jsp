<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Detalle de V&aacute;lvula</h2>
  <% Map valvula = (Map)request.getAttribute("valvula"); %>
  <form name="ActualizarValvula" action="/acueducto/actualizarValvula" method="get">
  <input type="hidden" name="id" value="<%= valvula.get("id") %>"/>
  
  <table>
    <tr>
		<td>Marca:</td><td><input class="input_txt" type="text" name="marca" value="<%= valvula.get("marca") %>"/></td>
	</tr>
    <tr>
		<td>Di&aacute;nmetro:</td><td><input class="input_txt" type="text" name="diametro"  value="<%= valvula.get("diametro") %>"/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value="<%= valvula.get("tipo") %>"/></td>
	</tr>
    <tr>
		<td>N&uacute;mero Serie:</td><td><input class="input_txt" type="text" name="numeroSerie" value="<%= valvula.get("numeroSerie") %>"/></td>
	</tr>
	<tr>
		<td>Presi&oacute;n M&aacute;xima:</td><td><input class="input_txt" type="text" name="presionMaxima" value="<%= valvula.get("presionMaxima") %>"/></td>
	</tr>
	<tr>
		<td>Fecha Instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value="<%= valvula.get("fechaInstalacion") %>"/></td>
	</tr>
	<tr>
		<td>Fecha Ultima Inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value="<%= valvula.get("fechaUltimaInspeccion") %>"/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value="<%= valvula.get("estado") %>"/></td>
	</tr>
    <tr>
		<td></td><td><input class="btn_blue" type="submit" value="Actualizar" /></td>
	</tr>
  </table>
  </form>
</html>
