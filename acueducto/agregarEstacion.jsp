<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Agregar Estaci&oacute;n</h2>
  <form name="InsertarEstacion" action="/acueducto/insertarEstacion" method="get">
  <table>
    <tr>
		<td>Presi&oacute;n entrada:</td><td><input class="input_txt" type="text" name="presionEntrada" value=""/></td>
	</tr>
    <tr>
		<td>Presi&oacute;n salida:</td><td><input class="input_txt" type="text" name="presionSalida" value=""/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value=""/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima:</td><td><input class="input_txt" type="text" name="capacidadMaxima"  value=""/></td>
	</tr>
    <tr>
		<td>Capacidad bombas:</td><td><input class="input_txt" type="text" name="cantidadBombas" value=""/></td>
	</tr>
	<tr>
		<td>Encargado:</td><td><input class="input_txt" type="text" name="encargadoEstacion" value=""/></td>
	</tr>
	<tr>
		<td>Tel&eacute;fono:</td><td><input class="input_txt" type="text" name="telefono" value=""/></td>
	</tr>
    <tr>
		<td></td><td><input class="btn_blue" type="submit" value="Agregar" /></td>
	</tr>
  </table>
  </form>
</html>
