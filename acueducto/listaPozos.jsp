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
  <h2>Listado de pozos</h2>
  <% List pozos = (List)request.getAttribute("pozos"); %>
  <table class="tablalista">
    <tr><th>Profundidad</th><th>Revestimiento</th><th>Di&aacute;metro</th><th>Capacidad m&aacute;xima en epoca seca</th><th>Capacidad m&aacute;xima en epoca lluviosa</th></tr>
    <% for(int i = 0, n = pozos.size(); i < n; i++) {
         Map pozo = (Map) pozos.get(i); %>
        <tr><td><%= pozo.get("profundidad") %></td>
        <td><%= pozo.get("tipoRevestimiento") %></td>
        <td><%= pozo.get("diametro") %></td>
		<td><%= pozo.get("capacidadMaximaEpocaSeca") %></td>
		<td><%= pozo.get("capacidadMaximaEpocaLLuviosa") %></td>
        <td class="tdnoborder"><a href='/acueducto/detallePozo?tp=2&id=<%= pozo.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarPozo?tp=3&id=<%= pozo.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarPozo?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>

