<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Tratamiendo de datos en formulario</h1>
	<form method="post" action="Formularios">
		<p>
			<label for="simple">Campo simple</label>			
			<input type="text" name="simple"/>
		</p>
		<p><label for="checkbox">Campo compuesto usando un checkbox</label></p>
		<input type="checkbox" name="checkbox" value="A" />OPCIÓN A<br>
		<input type="checkbox" name="checkbox" value="B" />OPCIÓN B<br>
		<input type="checkbox" name="checkbox" value="C" />OPCIÓN C<br>
		<input type="checkbox" name="checkbox" value="D" />OPCIÓN D<br>	
		
		<p><label for="mutiple">Campo compuesto usando un select de opción múltiple</label></p>
		<select name="multiple" multiple>
			<option>Selección A</option>
			<option>Selección B</option>
			<option>Selección C</option>
			<option>Selección D</option>
			<option>Selección E</option>
		</select>
		
		<p><input type="submit" name="submit" value="ENVIAR" /></p>
	</form>
</body>
</html>