<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, dev.ramide.tasks.model.Task"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Tarefas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<c:import url="nav.jsp" />
	<p>
		<c:if test="${not empty task}">Tarefa ${task} cadastrada com
		 sucesso!</c:if>
	</p>
	<div class="container">
	<h1 class="text-start fs-1">Suas tarefas:</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Nome</th>
				<th scope="col">Descrição</th>
				<th scope="col">Status</th>
				<th scope="col">Ações</th>
			</tr>
		</thead>

		<tbody>
		<c:forEach items="${tasks}" var="task">
			<tr>	
				<td>${task.title}</td>
				<td>${task.description}</td>
				<td>${task.status}</td>
				<td><a class="btn btn-warning btn-sm" href="/tasks/entry?action=ShowTask&id=${task.id}">editar</a>
				<a class="btn btn-danger btn-sm" href="/tasks/entry?action=DeleteTask&id=${task.id}">remover</a></td>		
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="entry?action=NewTaskForm" class="btn btn-secondary">Adicionar nova tarefa</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>