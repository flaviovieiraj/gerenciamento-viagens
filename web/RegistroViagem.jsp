<%-- 
    Document   : RegistroViagem
    Created on : Jun 10, 2023, 2:14:30 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.gerenciamentoViagens.model.entities.Viagem"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Registro Viagem</title>
    </head>
    <body>
        <center><h1>Registro de viagem</h1></center>
        
        <form method="post" action="AdminServlet" >
             <input type="hidden" name ="op" value="registroViagem"/>
             <table class="table">
                 
                
                <tr>
                    <th>
                        Local de destino:
                    </th>
                    <td>
                         <select name="localDestino" class="form-control"/>
                         <option value="">Selecione</option>
                         <c:forEach items="${locais}" var="local">
                             <option value="${local.nome}">
                                 ${local.nome}
                             </option>
                         </c:forEach>
             </select>                      
                    </td>
                </tr>
                <tr>
                    <th>
                        Data de ida:
                    </th>
                    <td>
                         <input type="text" name="dataInicio" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.dataInicio:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Data de retorno:
                    </th>
                    <td>
                         <input type="text" name="dataRetorno" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.dataRetorno:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Hora de início:
                    </th>
                    <td>
                         <input type="text" name="horaInicio" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.horaInicio:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Hora de retorno:
                    </th>
                    <td>
                         <input type="text" name="horaRetorno" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.horaRetorno:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Motivo da Viagem:
                    </th>
                    <td>
                         <input type="text" name="motivo" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.motivo:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Valor do combustível:
                    </th>
                    <td>
                         <input type="text" name="valorCombustivel" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.valorCombustivel:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Descrição:
                    </th>
                    <td>
                         <input type="text" name="descricao" class="form-control" value="${requestScope.viagem ne null?requestScope.viagem.descricao:''}"/>                          
                    </td>
                </tr>
                <tr>
                    <th>
                        Veículo:
                    </th>
                    <td>
                         <select name="modeloVeiculo" class="form-control"/>
                         <option value="">Selecione</option>
                         <c:forEach items="${modelos}" var="modelo">
                             <option value="${modelo.nome}">
                                 ${modelo.nome}
                             </option>
                         </c:forEach>
             </select>                          
                    </td>
                </tr>
                
                          
                 
             </table>
                         <input type="submit" value="Cadastrar"/>
         </form>
    </body>
</html>
