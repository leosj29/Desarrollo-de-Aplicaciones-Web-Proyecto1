<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
   <title>Sistema de Inventario del Acueducto Urbano</title>
   <link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Detalle de Bomba</h2>
  <% Map bomba = (Map)request.getAttribute("bomba"); %>
  <% List pozos = (List)request.getAttribute("pozos"); %>
  <% String modoIngreso = (String)request.getAttribute("modoIngreso"); %>	
  <form name="ActualizarBomba" action="/acueducto/actualizarBomba" method="get">
  <input type="hidden" name="id" value="<%= bomba.get("id") %>"/>
  <table>
  <tr>
	<td>Marca:</td><td><input class="input_txt" type="text" name="marca" <% if(!modoIngreso.equals("1")){ %> readonly="true"<% } %> value="<%= bomba.get("marca") %>"/></td>
  </tr>
  <tr>
	<td>Modelo:</td><td><input class="input_txt" type="text" name="modelo" <% if(!modoIngreso.equals("1")){ %> readonly="true"<% } %> value="<%= bomba.get("modelo") %>"/></td>
  </tr>
  <tr>
	<td>Capacidad:</td><td><input class="input_txt" type="text" name="capacidad" <% if(!modoIngreso.equals("1")){ %> readonly="true"<% } %> value="<%= bomba.get("capacidad") %>"/></td>
  </tr>			
  <tr>
	<td>Fecha instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" <% if(!modoIngreso.equals("1")){ %> readonly="true"<% } %> value="<%= bomba.get("fechaInstalacion") %>"/></td>
  </tr>			
  <tr>
	<td>Fecha &uacute;ltimo mantenimiento:</td><td><input class="input_txt" type="text" name="fechaUltimoMantenimiento" <% if(!modoIngreso.equals("1")){ %> readonly="true"<% } %>	value="<%= bomba.get("fechaUltimoMantenimiento") %>"/></td>
  </tr>
  <tr>
	<td>Estado:</td><td><input class="input_txt" type="text" name="estado" <% if(!modoIngreso.equals("1")){ %> readonly="true"<% } %>	value="<%= bomba.get("estado") %>"/></td>
  </tr>
  <tr><td>Id Pozo:</td>
		<td>			
		<select name="idPozo" <% if(!modoIngreso.equals("1")){ %> disabled="true"<% } %> > 
		<% for(int i = 0, n = pozos.size(); i < n; i++) {
		Map pozo = (Map) pozos.get(i); %>			
		<option value="<%= pozo.get("id") %>" <% if(pozo.get("id").toString().equals(bomba.get("idPozo").toString())){ %> selected <% } %> > <%= pozo.get("id") %> </option>				
		<% } %>
		</select>
		</td>
	</tr>
		<% if(modoIngreso.equals("1")){ %>
    <tr><td></td><td><input class="btn_blue" type="submit" value="Actualizar" /></td></tr>
	<% } %>	
  </table>
  </form>
</html>
