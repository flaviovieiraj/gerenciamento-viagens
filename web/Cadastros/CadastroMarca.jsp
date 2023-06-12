

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
      <center><h1>${(requestScope.marca eq null)?'Cadastro':'Alteração'} de Marca</h1></center>
      
      <form method="post" action="MarcaServlet" >
             ${(requestScope.marca ne null)?'<input type="hidden" name ="op" value="alterar"/>':''}
             <table class="table">
                 <tr>
                     <th>Nome:</th>
                     <td>
                         <input type="text" name="nome" class="form-control" value="${requestScope.marca ne null?requestScope.marca.nome:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Nacionalidade:</th>
                     <td>
                         <input type="text" name="nacionalidade" class="form-control" value="${requestScope.marca ne null?requestScope.marca.nacionalidade:''}"/>
                     </td>
                 </tr>
                 <tr>
                     <th>Descrição:</th>
                     <td>
                         <input type="text" name="descricao" class="form-control" value="${requestScope.marca ne null?requestScope.marca.descricao:''}"/>
                     </td>
                 </tr>
             </table>
                         <input type="submit" value="${(requestScope.marca eq null)?'Cadastrar':'Alterar'}"/>
    </body>
</html>
