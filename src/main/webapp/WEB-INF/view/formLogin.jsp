<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entry" var="linkEntryServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >

<title>Login</title>
</head>
<body class="container-sm">
		<form action="${linkEntryServlet}" method="post" class="row align-items-center">
			<h1 class="col-12 text-center">Sistema de Tarefas</h1>
			
			<div class="col-12">
			<label class="form-label">Login:</label> 
			<input type="text" class="form-control" name="login" />
			</div>
			
			<div class="col-12">
			<label class="form-label">Senha:</label>
			<input type="password" class="form-control" name="passwd" /> 
			</div>
			<input type="hidden" name="action" value="Login" />
			<p>
				<a href="entry?action=NewUserForm">Criar conta</a>
			</p>
			<div class="d-grid gap-2 col-6 mx-auto">
			<input type="submit" class="btn btn-primary"/>
			</div>
			
		</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>