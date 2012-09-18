<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Inventario del Acueducto Urbano</title>
	<link type="text/css" rel="stylesheet"  href="../css.css">
  </head>
  <h1>Sistema de Inventario del Acueducto Urbano</h1>
  <h2>Agregar Pozo</h2>
  <form name="InsertarPozo" action="/acueducto/insertarPozo" method="get">
  <table>
    <tr>
		<td>Profundidad:</td><td><input class="input_txt" type="text" name="profundidad" value=""/></td>
	</tr>
    <tr>
		<td>Revestimiento:</td><td><input class="input_txt" type="text" name="tipoRevestimiento" value=""/></td>
	</tr>
    <tr>
		<td>Di&aacute;metro:</td><td><input class="input_txt" type="text" name="diametro" value=""/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima epoca seca:</td><td><input class="input_txt" type="text" name="capacidadMaximaEpocaSeca"  value=""/></td>
	</tr>
    <tr>
		<td>Capacidad m&aacute;xima epoca lluviosa:</td><td><input class="input_txt" type="text" name="capacidadMaximaEpocaLLuviosa" value=""/></td>
	</tr>
    <tr>
		<td></td><td><input class="btn_blue" type="submit" value="Agregar" /></td>
	</tr>
  </table>
  </form>
</html>
