<%-- 
    Document   : index
    Created on : 17/10/2020, 11:08:09
    Author     : Leonardo
--%>
<%@page import="servlets.TelaCadastro"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bom Negocio</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/ControllerCadastro.js" type="text/javascript"></script>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container border">
            <div class="jumbotron text-black text-center" style="margin-bottom:0">
                <h1>BOMNEGOCIO.COM</h1>
                <p>Plataforma feita para voce realizar um bom negocio ao contratar servicos.</p>
            </div>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Anuncios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='userarea.jsp'>Area do Usuario</a>
                    </li>
                 </ul>
            </nav>
            <div class="container p-3 my-3 border">
                <div class="container" id="formUser">
                    <form class="form-signin" id='fdados' onsubmit="CadastrarUsuario()">
                    <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal">Cadastro de Usuario</h1>
                    </div>

                    <div class="form-label-group">
                    <label for="inputEmail">Usuario</label>
                    <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required="" autofocus="">
                    </div>

                    <div class="form-label-group pt-3">
                    <label for="inputPassword">Senha</label>
                    <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required="">
                    </div>
                        
                    <div class="form-label-group pt-3">
                    <label for="">URL da Foto</label>
                    <input type="text" id="foto" name="foto" class="form-control" placeholder="URL Foto" required="">
                    </div>
                    <div class="form-label-group pt-3">
                    <label for="">Nome Completo</label>
                    <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome" required="">
                    </div>
                    <div class="form-label-group pt-3">
                    <label for="">Logradouro</label>
                    <input type="text" id="logradouro" name="logradouro" class="form-control" placeholder="Logradouro" required="">
                    </div>
                        <div class="mt-3 mb-3 text-center"></div>
                    <button class="btn btn-lg btn-dark btn-block" type="submit">Cadastrar</button>
                    <div class="mt-3 mb-3 text-center" id='ViewUser'></div>
                    <p class="mt-5 mb-3 text-muted text-center">© 2020</p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>