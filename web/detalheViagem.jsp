<%-- 
    Document   : detalheViagem
    Created on : Jun 11, 2023, 5:32:42 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="ifpe" uri="com.gerenciamentoviagens.tags"%>
<%@page import="com.gerenciamentoViagens.model.entities.Viagem"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Detalhes da viagem</title>
    </head>
    <body class="bg-secondary"><c:import url="menuGerenciamento.jsp"/>
        
        



        <h1>Detalhes da viagem</h1>

        <ifpe:carregaViagem codigo="${param.cod}"/>
            <div class="col-md-6">
                <table class="table table-dark table-hover">
                    <tr>
                        <th>Destino</th>
                        <td>${viagem.localDestino}</td>
                    </tr>
                    <tr>
                        <th>Data e hora de ida</th>
                        <td>${viagem.dataInicio} / ${viagem.horaInicio}</td>
                    </tr>
                    <tr>
                        <th>Data e hora de retorno</th>
                        <td>${viagem.dataRetorno} / ${viagem.horaRetorno}</td>
                    </tr>
                    <tr>
                        <th>Veículo</th>
                        <td>${viagem.modeloVeiculo}</td>
                    </tr>
                    <tr>
                        <th>Valor gasto em combustível</th>
                        <td>R$ ${viagem.valorCombustivel}</td>
                    </tr>
                    <tr>
                        <th>Descrição da viagem</th>
                        <td>${viagem.descricao}</td>
                    </tr>
                    <tr>
                        <th>Motivo da Viagem</th>
                        <td>${viagem.motivo}</td>
                    </tr>
                    <tr>
                        <th>Motorista</th>
                        <td>${adminLogado.nome}</td>
                    </tr>
                </table>

            </div>
    </body>
</html>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
