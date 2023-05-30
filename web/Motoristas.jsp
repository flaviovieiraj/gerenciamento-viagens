<%-- 
    Document   : Motoristas
    Created on : May 1, 2023, 4:38:19 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.gerenciamentoViagens.model.entities.Motorista" %>
<%@taglib  prefix="ifpe" uri="/WEB-INF/tlds/IFPETags.tld"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Motoristas</title>
    </head>
    <body class="bg-secondary">
        <c:import url="menuGerenciamento.jsp"/>
        
        ${pageScope.motoristas.size()}
        
        <h1 class="modal-title">Motoristas cadastrados</h1>
        
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
        <button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar Motorista</button><br><br>
        
        <table class="table table-striped table-bordered" >
            <tr class="table-dark">
                <th>CNH</th>
                <th>Nome</th>
                <th>Categoria da Habilitação</th>
                <th>Telefone</th>
                <th>Endereço</th>                
                <th>Opcões</th>
            </tr>
            <%
                List<Motorista> motoristas = (List) session.getAttribute("motoristas");
                
                if(motoristas ==null){
                    response.sendRedirect("MotoristaServlet");
                    return;
                }
                for(Motorista mot : motoristas){
                                    
                %>
                
                 <tr>
                    <td><%= mot.getCnh()%></td>
                    <td><%= mot.getNome()%></td>
                    <td><%= mot.getCategoriaHabilitacao()%></td>
                    <td><%= mot.getTelefoneContato()%></td>
                    <td><%= mot.getEndereco()%></td>                    
                    <td>  
                         <div class="btn-group" role="group" aria-label="Basic mixed styles example">
  <button type="button" class="btn btn-success" onclick="window.location.href='MotoristaServlet?cnh=<%= mot.getCnh() %>&op=detalhar'">detalhar</button>
  <button type="button" class="btn btn-warning" onclick="window.location.href='MotoristaServlet?cnh=<%= mot.getCnh() %>&op=alterar'">alterar</button>
  <button type="button" class="btn btn-danger" onclick="window.location.href='MotoristaServlet?cnh=<%= mot.getCnh() %>&op=deletar'">deletar</button>
</div>                </tr>
              <%  }%>
        </table>
        
         <div class="modal" id="modalCadastro" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <%@include file="CadastroMotorista.jsp" %>
                        </div>
                </div>
            </div>
        </div>
                        
                            
                            <!--<ifpe:carrega nome="" motoristas="${motoristas}">Lista 2 de Motoristas:</ifpe:carrega> -->
                         
    </body>
</html>
