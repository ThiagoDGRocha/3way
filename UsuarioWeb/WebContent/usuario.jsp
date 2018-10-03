<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Usuários</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	<div class="panel-primary">
		<form method="post" action="user" name="formAddUsuario">
			<div class="panel-heading">
				<label for="usuarioId">Ususario id: </label> <input type="number"
					name="usuarioId" readonly="readonly" value="${usuario.id}" />
			</div>
			<div class="panel-heading">
				<label for="usuarioLogin">Usuario login: </label> <input type="text"
					name="usuarioLogin" value="${usuario.login }" />
			</div>
			<div class="panel-heading">
				<label for="usuarioMatricula">Usuario matricula: </label> <input type="text"
					name="usuarioMatricula" value="${usuario.matricula }" />
			</div>
			<div class="panel-heading">
				<label for="usuarioNome">Usuario nome: </label> <input type="text"
					name="usuarioNome" value="${usuario.nome }" />
			</div>
			<input type="submit" value="SALVAR" class="btn btn-primary">
		</form>
	</div>
</body>
</html>