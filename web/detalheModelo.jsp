<%-- 
    Document   : detalheModelo
    Created on : Jun 12, 2023, 5:53:14 PM
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
        <title>JSP Page</title>
    </head>
    <body class="bg-secondary">
        <c:import url="menuGerenciamento.jsp"/>
        <br><h1>Detalhes do modelo</h1><br>
        
            <div class="col-md-6">
        <table class="table table-dark table-hover">
            <tr>
                <th>Código</th>
                <td>#${requestScope.modelo.codigo}</td>
                <tr></tr>
                <th>Modelo</th>
                <td>${requestScope.modelo.nome}</td>
                <tr></tr>
                <th>Marca</th>
                <td>${requestScope.modelo.marca}</td>
                <tr></tr>
                <th>Tipo de veículo</th>
                <td>${requestScope.modelo.tipoVeiculo}</td>
                <tr></tr>
            </tr>
        </table>
            </div>
    </body>
</html>
