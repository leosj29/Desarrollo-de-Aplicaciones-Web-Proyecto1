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
  <h2>Listado de Tanques</h2>
  <% List tanques = (List)request.getAttribute("tanques"); %>
  <table class="tablalista">
    <tr><th>Capacidad</th><th>Material</th><th>Tipo</th><th>Fecha Instalaci&oacute;n</th><th>Fecha UltimaInspecci&oacute;n</th><th>Estado</th></tr>
    <% for(int i = 0, n = tanques.size(); i < n; i++) {
         Map tanque = (Map) tanques.get(i); %>
        <tr><td><%= tanque.get("capacidad") %></td>
        <td><%= tanque.get("material") %></td>
        <td><%= tanque.get("tipo") %></td>
		<td><%= tanque.get("fechaInstalacion") %></td>
        <td><%= tanque.get("fechaUltimaInspeccion") %></td>
		<td><%= tanque.get("estado") %></td>
        <td class="tdnoborder"><a href='/acueducto/detalleTanque?tp=2&id=<%= tanque.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarTanque?tp=3&id=<%= tanque.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarTanque?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>