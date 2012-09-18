<%@ page import="java.util.*" %>
<html>
  <head>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <div id="menuhorizontal">
		<ul>
			<li><a href="index" id="primero">&nbsp;Regresar M&eacute;nu Principal&nbsp;</a></li>
		</ul>
	</div><br/>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Listado de Tuberias</h2>
  <% List tuberias = (List)request.getAttribute("tuberias"); %>
  <table class="tablalista">
    <tr><th>Material</th><th>Di&aacute;metro</th><th>Tipo</th><th>Largo</th><th>Presi&oacute;n m&aacute;xima</th><th>Fecha Instalacion</th><th>Fecha UltimaInspeccion</th><th>Estado</th></tr>
    <% for(int i = 0, n = tuberias.size(); i < n; i++) {
         Map tuberia = (Map) tuberias.get(i); %>
        <tr><td><%= tuberia.get("material") %></td>
        <td><%= tuberia.get("diametro") %></td>
        <td><%= tuberia.get("tipo") %></td>
		<td><%= tuberia.get("largo") %></td>
        <td><%= tuberia.get("presionMaxima") %></td>
		<td><%= tuberia.get("fechaInstalacion") %></td>
		<td><%= tuberia.get("fechaUltimaInspeccion") %></td>
		<td><%= tuberia.get("estado") %></td>
        <td class="tdnoborder"><a href='/acueducto/detalleTuberia?tp=2&id=<%= tuberia.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarTuberia?tp=3&id=<%= tuberia.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarTuberia?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>