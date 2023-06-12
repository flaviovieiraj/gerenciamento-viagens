

<%@page import="com.gerenciamentoViagens.model.entities.TipoVeiculo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Tipos de Veículo</title>
    </head>
    <body class="bg-secondary">
        
<c:import url="menuGerenciamento.jsp"/>
         
        <h1 class="modal-title">Tipos de veículo cadastrados</h1>
        
        <%
            String msg = (String) session.getAttribute("msg");

            if (msg != null) {
        %>
        <h2><%= (String) session.getAttribute("msg")%></h2>
        <%

                session.removeAttribute("msg");

            }
        %>
        <br>
        <button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar tipo de veículo</button><br><br>
        
        <table class="table table-striped table-bordered" >
            <tr class="table-dark">
                <th>Tipo</th>
                <th>Descrição</th>
                <th>codigo</th>
                <th>Opcões</th>
            </tr>
            <%
                List<TipoVeiculo> tiposveiculo = (List) session.getAttribute("tiposveiculo");
                
                if(tiposveiculo ==null){
                    response.sendRedirect("TipoVeiculoServlet");
                    return;
                }
                for(TipoVeiculo tipov : tiposveiculo){
                                    
                %>
                
                <tr>
                    <td><%= tipov.getTipo()%></td>
                    <td><%= tipov.getDescricao()%></td>
                    <td><%= tipov.getCodigo()%></td>
                    
                    <td>                        
                        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
  <button type="button" class="btn btn-success" onclick="window.location.href='TipoVeiculoServlet?cod=<%= tipov.getCodigo() %>&op=detalhar'">detalhar</button>
  <button type="button" class="btn btn-warning" onclick="window.location.href='TipoVeiculoServlet?cod=<%= tipov.getCodigo() %>&op=alterar'">alterar</button>
  <button type="button" class="btn btn-danger" onclick="window.location.href='TipoVeiculoServlet?cod=<%= tipov.getCodigo() %>&op=deletar'">deletar</button>
</div>                </tr>
              <%  }%>
                </table>
        
        <div class="modal" id="modalCadastro" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <%@include file="/Cadastros/CadastroTipoVeiculo.jsp" %>
                        </div>
                </div>
            </div>
        </div>
    </body>
</html>
