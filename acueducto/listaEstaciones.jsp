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
  <h2>Listado de estaciones</h2>
  <% List estaciones = (List)request.getAttribute("estaciones"); %>
  <table class="tablalista">
    <tr><th>Presi&oacute;n estrada</th><th>Presi&oacute;n salida</th><th>Tipo</th><th>Capacidad m&aacute;xima</th><th>Cantidad bombas</th><th>Encargado</th><th>Tel&eacute;fono</th></tr>
    <% for(int i = 0, n = estaciones.size(); i < n; i++) {
         Map estacion = (Map) estaciones.get(i); %>
        <tr><td><%= estacion.get("presionEntrada") %></td>
        <td><%= estacion.get("presionSalida") %></td>
        <td><%= estacion.get("tipo") %></td>
		<td><%= estacion.get("capacidadMaxima") %></td>
        <td><%= estacion.get("cantidadBombas") %></td>
		<td><%= estacion.get("encargadoEstacion") %></td>
		<td><%= estacion.get("telefono") %></td>
        <td class="tdnoborder"><a href='/acueducto/detalleEstacion?tp=2&id=<%= estacion.get("id") %>'>
              <input class="btn_blue" type="submit" value="Detalle"/></a>
            <a href='/acueducto/eliminarEstacion?tp=3&id=<%= estacion.get("id") %>'>
              <input class="btn_blue" type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/acueducto/agregarEstacion?tp=1'>
        <input class="btn_blue" type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>