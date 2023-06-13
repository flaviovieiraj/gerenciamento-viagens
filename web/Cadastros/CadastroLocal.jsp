<%-- 
    Document   : CadastroLocal
    Created on : Apr 25, 2023, 10:46:17 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Cadastro Local</title>
    </head>
    <body>
    <center><h1>${(requestScope.local eq null)?'Cadastro':'Alteração'} de Local</h1></center>
    
        
         <form method="post" action="LocalServlet" >
             ${(requestScope.local ne null)?'<input type="hidden" name ="op" value="alterar"/>':''}
             <table class="table">
                 <tr>
                     <th>Nome:</th>
                     <td>
                         <input type="text" name="nome" class="form-control" value="${requestScope.local ne null?requestScope.local.nome:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Endereco:</th>
                     <td>
                         <input type="text" name="endereco" class="form-control" value="${requestScope.local ne null?requestScope.local.endereco:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Cidade:</th>
                     <td>
                         <input type="text" name="cidade" class="form-control" value="${requestScope.local ne null?requestScope.local.cidade:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Estado:</th>
                     <td>
                         <input type="text" name="estado" class="form-control" value="${requestScope.local ne null?requestScope.local.estado:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Ponto de Referencia:</th>
                     <td>
                         <input type="text" name="pontoReferencia" class="form-control" value="${requestScope.local ne null?requestScope.local.pontoReferencia:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Descricao:</th>
                     <td>
                         <input type="text" name="descricao" class="form-control" value="${requestScope.local ne null?requestScope.local.descricao:''}"/>
                     </td>
                 </tr>
                 
             </table>
                         <input type="submit" value="${(requestScope.local eq null)?'Cadastrar':'Alterar'}"/>
         </form>
    </body>
</html>
