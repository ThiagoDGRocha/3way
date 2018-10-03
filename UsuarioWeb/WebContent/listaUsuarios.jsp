<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<form method="post" action="user" name="frmBuscarUsuario">
		<input type="text" name="usuarioBusca"
			placeholder="Consultar usuario..." /> <input type="submit"
			value="Consultar" />
	</form>
	<table border=1>
		<thead>
			<tr>
				<th>Código</th>
				<th>Login</th>
				<th>Nome</th>
				<th>Matricula</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.usuarios}" var="usuario"
				varStatus="id">
				<tr bgcolor="${id.count % 2 == 0 ? '#4ddbff' : '#e6f9ff'}">
					<td><c:out value="${usuario.id }" /></td>
					<td><c:out value="${usuario.login }" /></td>
					<td><c:out value="${usuario.nome }" /></td>
					<td><c:out value="${usuario.matricula }" /></td>
					<td><a
						href="user?action=editar&usuarioId=<c:out value="${usuario.id }"/>">Update</a></td>
					<td><a
						href="user?action=deletar&usuarioId=<c:out value="${usuario.id }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="user?action=insert">Adicionar um novo Usuário</a>
	</p>
</body>
</html>