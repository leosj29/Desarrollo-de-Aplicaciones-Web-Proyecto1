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
  <h2>Listado de medidores</h2>
  <% List medidores = (List)request.getAttribute("medidores"); %>
  <table class="tablalista">
    <tr><th>Material</th><th>Marca</th><th>Tipo</th><th>Di&aacute;metro</th><th>Presi&oacute;n de trabajo</th><th>Fecha de instalaci&oacute;n</th><th>Fecha de &uacute;ltima inspecci&oacute;n</th><th>Estado</th></tr>
    <% for(int i = 0, n = medidores.size(); i < n; i++) {
         Map medidor = (Map) medidores.get(i); %>
        <tr><td><%= medidor.get("material") %></td>
        <td><%= medidor.get("marca") %></td>
        <td><%= medidor.get("tipo") %></td>
		<td><%= medidor.get("diametro") %></td>
		<td><%= medidor.get("presionTrabajo") %></td>
		<td><%= medidor.get("fechaInstalacion") %></td>
		<td><%= medidor.get("fechaUltimaInspeccion") %></td>
		<td><%= medidor.get("estado") %></td>
        <td class="tdnoborder"><a href='/acueducto/detalleMedidor?tp=2&id=<%= medidor.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarMedidor?tp=3&id=<%= medidor.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarMedidor?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>

