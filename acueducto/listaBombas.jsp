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
  <h2>Listado de bombas</h2>
  <% List bombas = (List)request.getAttribute("bombas"); %>
  <table class="tablalista">
    <tr><th>Marca</th><th>Modelo</th><th>Capacidad</th><th>Fecha instalaci&oacute;n</th><th>Fecha &uacute;ltimo mantenimiento</th><th>Estado</th><th>Id pozo</th></tr>
    <% for(int i = 0, n = bombas.size(); i < n; i++) {
         Map bomba = (Map) bombas.get(i); %>
        <tr><td><%= bomba.get("marca") %></td>
        <td><%= bomba.get("modelo") %></td>
        <td><%= bomba.get("capacidad") %></td>
		<td><%= bomba.get("fechaInstalacion") %></td>
        <td><%= bomba.get("fechaUltimoMantenimiento") %></td>
		<td><%= bomba.get("estado") %></td>
		<td><%= bomba.get("idPozo") %></td>
        <td class="tdnoborder"><a href='/acueducto/detalleBomba?tp=2&id=<%= bomba.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarBomba?tp=3&id=<%= bomba.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarBomba?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>