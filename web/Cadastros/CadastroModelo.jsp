<%-- 
    Document   : CadastroModelo
    Created on : May 30, 2023, 2:42:23 PM
    Author     : flaviovieira
--%>

<%@page import="com.gerenciamentoViagens.model.entities.TipoVeiculo"%>
<%@page import="com.gerenciamentoViagens.model.entities.Modelo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Cadastro Modelo</title>
    </head>
    <body>
        
        <center><h1>${(requestScope.modelo eq null)?'Cadastro':'Alteração'} de Modelo</h1></center>
        
        
        <form method="post" action="ModeloServlet" >
             ${(requestScope.modelo ne null)?'<input type="hidden" name ="op" value="alterar"/>':''}
             <table class="table">
                 
                 <tr>
                     <th>Modelo:</th>
                     <td>
                         <input type="text" name="nome" class="form-control" value="${requestScope.modelo ne null?requestScope.modelo.nome:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Marca:</th>
                     <td>
                         <select name="marca" class="form-control"/>
                         <option value="">Selecione</option>
                         <c:forEach items="${marcas}" var="opcao">
                             <option value="${opcao.nome}">
                                 ${opcao.nome}
                             </option>
                         </c:forEach>
             </select>
                     </td>
                 </tr>
                 <tr>
                     <th>Tipo de veículo:</th>
                     <td>
                         <select name="tipoVeiculo" class="form-control"/>
                         <option value="">Selecione</option>
                         <c:forEach items="${tiposveiculo}" var="opcao">
                             <option value="${opcao.tipo}">
                                 ${opcao.tipo}
                             </option>
                         </c:forEach>
             </select>
            </td>
                             
                     </td>
                 </tr>
                 
             </table>
                         <input type="submit" value="${(requestScope.modelo eq null)?'Cadastrar':'Alterar'}"/>
         </form>
    </body>
</html>
