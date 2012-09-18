<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Agregar Tuber&iacute;a</h2>
  <form name="InsertarTuberia" action="/acueducto/insertarTuberia" method="get">
  <table>
    <tr>
		<td>Material:</td><td><input class="input_txt" type="text" name="material" value=""/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro"  value=""/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value=""/></td>
	</tr>
    <tr>
		<td>Largo:</td><td><input class="input_txt" type="text" name="largo" value=""/></td>
	</tr>
	<tr>
		<td>Presi&oacute;n m&aacute;xima:</td><td><input class="input_txt" type="text" name="presionMaxima" value=""/></td>
	</tr>
	<tr>
		<td>Fecha Instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value=""/></td>
	</tr>
	<tr>
		<td>Fecha Ultima Inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value=""/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value=""/></td>
	</tr>
	<tr><td></td><td><input class="btn_blue" type="submit" value="Agregar" /></td></tr>
  </table>
  </form>
</html>
