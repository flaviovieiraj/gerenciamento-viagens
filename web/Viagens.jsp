<%-- 
    Document   : Viagens
    Created on : Jun 1, 2023, 2:38:58 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.gerenciamentoViagens.model.entities.Viagem"%>
<%@taglib prefix="ifpe" uri="com.gerenciamentoviagens.tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Minhas viagens</title>
    </head>
    <body class="bg-secondary">
        <c:import url="menuGerenciamento.jsp"/>
        <c:if test="${sessionScope.adminLogado eq null}">
    <script>
        location.href="loginAdmin.jsp";
    </script>
</c:if>
        

        <h1 class="modal-title">Minhas Viagens</h1><br>
        <button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modalCadastro">Registrar nova viagem</button><br><br>

        <table class="table table-striped table-bordered">
            <tr class="table-dark">
                <th>Destino</th>
                <th>Data de Ida</th>
                <th>Veículo</th>
                <th>codigo</th>
                <th>Opções</th>
            </tr>

            <c:forEach var="vg" items="${sessionScope.adminLogado.viagens}">

                <tr>
                    <td>${vg.localDestino}</td>
                    <td>${vg.dataInicio}</td>
                    <td>${vg.modeloVeiculo}</td>
                    <td>${vg.codigo}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                            <button type="button" class="btn btn-success" onclick="window.location.href ='ViagemServlet?cod=${vg.codigo}&op=detalhar'">detalhar</button>
                        </div>
                </tr>
            </td>
        </tr> 

    </c:forEach>

</table>

<div class="modal" id="modalCadastro" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <%@include file="RegistroViagem.jsp"%>
            </div>
        </div>
    </div>
</div>

</body>
</html>
