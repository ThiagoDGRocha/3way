<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro usuarios</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	<div class="panel-bory">
		<form name="myForm" method="post" action="user">
			<fieldset>
				<div class="form-group">
					<label for="login">Login</label> <input type="text" name="login"
						size="25" placeholder="Informe o login aqui!">
				</div>
				<div class="form-group">
					<label for="nome">Nome</label> <input type="text" name="nome"
						size="25" placeholder="Informe o nome aqui!">
				</div>
				<div class="form-group">
					<label for="matricula">Matricula</label> <input type="number"
						name="matricula" size="10" placeholder="Informe o matricula aqui!">
				</div>
			</fieldset>
			<input type="submit" value="SALVAR" class="btn btn-primary">
		</form>
	</div>
</body>
</html>