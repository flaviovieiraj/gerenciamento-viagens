<%-- 
    Document   : detalheTipoveiculo
    Created on : May 2, 2023, 6:14:50 PM
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
        <title>Detalhes do tipo de veículo</title>
    </head>
    <body> 
        
<c:import url="menuGerenciamento.jsp"/>
        <h1>Detalhes do tipo de veículo</h1>
        
        <table class="table">
            <tr>
                <th>Tipo</th>
                <td>${requestScope.tipoveiculo.tipo}</td>
                <tr></tr>
                <th>Descrição</th>
                <td>${requestScope.tipoveiculo.descricao}</td>
            </tr>
        </table>
    </body>
</html>
