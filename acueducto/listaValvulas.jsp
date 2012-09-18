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
  <h2>Listado de Valvulas</h2>
  <% List valvulas = (List)request.getAttribute("valvulas"); %>
  <table class="tablalista">
    <tr><th>Marca</th><th>Di&aacute;metro</th><th>Tipo</th><th>N&uacute;mero Serie</th><th>Presi&oacute;n M&aacute;xima</th><th>Fecha Instalacion</th><th>Fecha Ultima Inspecci&oacute;n</th><th>Estado</th></tr>
    <% for(int i = 0, n = valvulas.size(); i < n; i++) {
         Map valvula = (Map) valvulas.get(i); %>
        <tr><td><%= valvula.get("marca") %></td>
        <td><%= valvula.get("diametro") %></td>
        <td><%= valvula.get("tipo") %></td>
		<td><%= valvula.get("numeroSerie") %></td>
        <td><%= valvula.get("presionMaxima") %></td>
		<td><%= valvula.get("fechaInstalacion") %></td>
		<td><%= valvula.get("fechaUltimaInspeccion") %></td>
		<td><%= valvula.get("estado") %></td>
        <td class="tdnoborder"><a href='/acueducto/detalleValvula?tp=2&id=<%= valvula.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarValvula?tp=3&id=<%= valvula.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarValvula?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>