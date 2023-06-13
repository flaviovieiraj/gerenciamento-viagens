<%-- 
    Document   : CadastroLogin
    Created on : Jun 1, 2023, 3:32:34 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Cadastro</title>
    </head>
    <body>
    <center><h1>Cadastro de Motorista</h1></center>
        
         <form method="post" action="AdminServlet" >
             <input type="hidden" name ="op" value="cadastro"/>
             <table class="table">
                 <tr>
                     <th>Nome:</th>
                     <td>
                         <input type="text" name="nome" class="form-control" value="${requestScope.admin ne null?requestScope.admin.nome:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>CNH:</th>
                     <td>
                         <input type="text" name="cnh" class="form-control" value="${requestScope.admin ne null?requestScope.admin.cnh:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Categoria da Habilitação:</th>
                     <td>
                         <input type="text" name="categoriaHabilitacao" class="form-control" value="${requestScope.admin ne null?requestScope.admin.categoriaHabilitacao:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Endereço:</th>
                     <td>
                        <input type="text" name="endereco" class="form-control" value="${requestScope.admin ne null?requestScope.admin.endereco:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Telefone:</th>
                     <td>
                         <input type="text" name="telefoneContato" class="form-control" value="${requestScope.admin ne null?requestScope.admin.telefoneContato:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Senha:</th>
                     <td>
                         <input type="password" name="senha" class="form-control" value="${requestScope.admin ne null?requestScope.admin.senhaMotorista:''}"/>
                     </td>
                 </tr>
                 
                 </table>
                         <input type="submit" value="Cadastrar"/>
         </form>
                    
    </body>
</html>
