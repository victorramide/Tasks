<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Tarefas</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="entry?action=Home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="entry?action=NewTaskForm">Cadastrar Nova Tarefa</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="entry?action=TaskList">Listar Tarefas</a>
        </li>
        <li class="nav-item">
          <span class="nav-link">Olá, ${logged.firstName} ${logged.lastName} / <a href="entry?action=Logout">Sair</a></span>
        </li>
       </ul>
    </div>
  </div>
</nav>