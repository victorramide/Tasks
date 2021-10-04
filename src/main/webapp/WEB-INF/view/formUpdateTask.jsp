<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entry" var="linkEntryServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar tarefa</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<c:import url="nav.jsp" />
	<div class="container">
	<form action="${linkEntryServlet}" method="post" class="row align-items-center">
	
		<div class="col-12">
		<label class="form-label">Título: </label>
		<input type="text" name="title" value="${task.title}" class="form-control"/>
		</div>
		
		<div class="col-12">
		<label class="form-label">Descrição: </label>
		<textarea name="description" rows="4" cols="50" class="form-control">${task.description}</textarea>
		</div>
		
		<div class="col-6">
		<label for="status" class="form-label">Status:</label> 
		<input class="form-control" list="status" name="status" placeholder="Escolha o status">
		<datalist id="status">
			<option value="Não iniciado">Não iniciado</option>
			<option value="Em andamento">Em andamento</option>
			<option value="Concluído">Concluído</option>
		</datalist>
		</div>
		
		<input type="hidden" name="id" value="${task.id}" />
		<input type="hidden" name="action" value="UpdateTask" />
		<p></p>
		<div class="d-grid gap-2 col-6 mx-auto">
		<input type="submit" class="btn btn-lg btn-primary"/>
		</div>
	</form>
</div>
</body>
</html>