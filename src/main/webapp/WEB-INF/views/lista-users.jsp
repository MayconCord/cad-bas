<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Usuários Cadastrados</title>
</head>
<body>
	<table border="1">
		<thead>
	      	<tr>
	            <th>Jogador</th>
	            <th>Fase</th>
	            <th>Pontuação</th>
	            <th colspan="2">Ação</th>
	        </tr>
	    </thead>
	    <tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.nome}</td>
					<td>${user.fase}</td>
					<td>${user.pontuacao}</td>
					<td><a href="UserServlet?acao=editar&id=${user.id}">Editar</a></td>
					<td><a href="UserServlet?acao=remover&id=${user.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	 </table>
</body>
</html>