<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualização de Cadastro</title>
</head>
<body>
	
	<div class="user titulo">
    	<h1>Atualização dos dados do usuário:</h1>
    </div>
    
    <form action="UserServlet" method="POST">
    	<input type="hidden" name="id" value="${user.id}"></input>
		<label for="name">Nome</label>
		<input type="text" name="nome" placeholder="Digite seu nome" id="nome" value="${user.nome}"> <br>
		<label for="fase">Fase</label>
		<input type="text" name="fase" placeholder="Digite a fase" id="fase" value="${user.fase}"> <br>
		<label for="pontuacao">Pontuação</label>
		<input type="text" name="pontuacao" placeholder="Digite sua pontua��o" id="fase" value="${user.pontuacao}"></input><br><br>
		<button type="submit">Enviar</button>
    </form>
</body>
</html>