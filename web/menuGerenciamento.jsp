<%-- 
    Document   : menuGerenciamento
    Created on : May 22, 2023, 5:08:24 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:if test="${sessionScope.adminLogado eq null}">
    <script>
        location.href="loginAdmin.jsp";
    </script>
</c:if>
    
    

    <nav class="navbar navbar-expand-lg bg-body-tertiary " data-bs-theme="dark">
  <div class="container-fluid" >
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
          
        <li class="nav-item">
          <a class="nav-link active" onclick="window.location.href='indexGerenciamento.jsp'" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" onclick="window.location.href='TipoVeiculoServlet'" href="#">Tipos de veículo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#" onclick="window.location.href='MarcaServlet'">Marcas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#" onclick="window.location.href='MotoristaServlet'">Motoristas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" onclick="window.location.href='LocalServlet'" href="#">Locais</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                ${sessionScope.adminLogado.nome}
          </a>
          <ul class="dropdown-menu me-10" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="AdminServlet?operacao=logout">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
          
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>