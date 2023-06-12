<%-- 
    Document   : CadastroTipoVeiculo
    Created on : May 2, 2023, 6:14:13 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <center><h1>${(requestScope.tipoveiculo eq null)?'Cadastro':'Alteração'} de Tipo de veículo</h1></center>
        
        <form method="post" action="TipoVeiculoServlet" >
             ${(requestScope.tipoveiculo ne null)?'<input type="hidden" name ="op" value="alterar"/>':''}
             <table class="table">
                 
                 <tr>
                     <th>Tipo:</th>
                     <td>
                         <input type="text" name="tipo" class="form-control" value="${requestScope.tipoveiculo ne null?requestScope.tipoveiculo.tipo:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Descricao:</th>
                     <td>
                         <input type="text" name="descricao" class="form-control" value="${requestScope.tipoveiculo ne null?requestScope.tipoveiculo.descricao:''}"/>
                     </td>
                 </tr>
                 
             </table>
                         <input type="submit" value="${(requestScope.tipoveiculo eq null)?'Cadastrar':'Alterar'}"/>
         </form>
    </body>
</html>
