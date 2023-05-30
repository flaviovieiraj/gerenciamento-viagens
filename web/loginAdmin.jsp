<%-- 
    Document   : loginAdmin
    Created on : May 22, 2023, 6:06:09 PM
    Author     : flaviovieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <title>Login</title>
    </head>
     <body>
        <section class="vh-100">
  <div class="container-fluid h-custom bg-secondary">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://yata2.s3-object.locaweb.com.br/809ab6715ad319328e8ffca46f299448e1b38c71e7c98d29297f04aae3f9cede"
          class="img-fluid" alt="Sample image">
      </div>
        <div class=" text-center"><h1 id="titulo" class="display-1">Gerenciamento de Viagens</h1></div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          
          <form method="post" action="AdminServlet">
          <input type="hidden" name="operacao" value="login"/>

                    
          <!-- código -->
          <div class="form-outline mb-4">
              <input type="codigo" name="codigo"  class="form-control form-control-lg"
              placeholder="Código de administrador" />
          </div>

          <!-- senha -->
          <div class="form-outline mb-3">
            <input type="password" name="senha" class="form-control form-control-lg"
              placeholder="Senha" />
          </div>

          

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-lg btn-dark"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0">Não é um administrador? <a href="#!"
                class="link-light">Cadastre-se</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
  <div
    class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-dark" >
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0">
      Copyright © 2020. All rights reserved.
    </div>
  </div>
</section>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

        <div style="color:red"><small>${msg}</small></div>
        
    </body>
</html>
