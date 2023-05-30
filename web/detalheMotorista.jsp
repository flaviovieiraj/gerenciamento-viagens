<%-- 
    Document   : detalheMotorista
    Created on : May 1, 2023, 5:31:21 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Detalhes do Motorista</title>
    </head>
    <body>
        
<c:import url="menuGerenciamento.jsp"/>
        <h1>Detalhes do motorista</h1>
        
        <table class="table">
            <tr>
                <th>Nome</th>
                <td>${requestScope.motorista.nome}</td>
                <tr></tr>
                <th>CNH</th>
                <td>${requestScope.motorista.cnh}</td>
                <tr></tr>
                <th>Endereco</th>
                <td>${requestScope.motorista.endereco}</td>
                <tr></tr>
                <th>Categoria da Habilitação</th>
                <td>${requestScope.motorista.categoriaHabilitacao}</td>
                <tr></tr>
                <th>Telefone</th>
                <td>${requestScope.motorista.telefoneContato}</td>
                <tr></tr>
            </tr>
        </table>
    </body>
</html>