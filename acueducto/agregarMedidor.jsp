<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Agregar Medidor</h2>
  <form name="InsertarMedidor" action="/acueducto/insertarMedidor" method="get">
  <table>
    <tr>
		<td>Material:</td><td><input class="input_txt" type="text" name="material" value=""/></td>
	</tr>
    <tr>
		<td>Marca:</td><td><input class="input_txt" type="text" name="marca" value=""/></td>
	</tr>
    <tr>
		<td>Tipo:</td><td><input class="input_txt" type="text" name="tipo" value=""/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro"  value=""/></td>
	</tr>
    <tr>
		<td>Presi&oacute;n de trabajo:</td><td><input class="input_txt" type="text" name="presionTrabajo" value=""/></td>
	</tr>
	<tr>
		<td>Fecha de instalaci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaInstalacion" value=""/></td>
	</tr>
	<tr>
		<td>Fecha de &uacute;ltima inspecci&oacute;n:</td><td><input class="input_txt" type="text" name="fechaUltimaInspeccion" value=""/></td>
	</tr>
	<tr>
		<td>Estado:</td><td><input class="input_txt" type="text" name="estado" value=""/></td>
	</tr>
    <tr>
		<td></td><td><input class="btn_blue" type="submit" value="Agregar" /></td>
	</tr>
  </table>
  </form>
</html>
