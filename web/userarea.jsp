<%-- 
    Document   : index
    Created on : 17/10/2020, 11:08:09
    Author     : Leonardo
--%>
<%@page import="servlets.TelaUsuario"%>
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
        <script src="js/ControllerUsuarios.js" type="text/javascript"></script>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="userarea.jsp">Area do Usuario</a>
                    </li>
                 </ul>
            </nav>
            <div class="container p-3 my-3 border" id="ViewUser">
                <div class="container" id="formUser">
                    <form class="form-signin" onsubmit="LogarUsuario()">
                    <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal">Area do Usuario</h1>
                    </div>

                    <div class="form-label-group">
                    <label for="inputEmail">Usuario</label>
                    <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required="" autofocus="">
                    </div>

                    <div class="form-label-group pt-3">
                    <label for="inputPassword">Senha</label>
                    <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required="">
                    
                    </div>

                    <div class="checkbox mb-3 pt-3">
                    <label>
                    <input type="checkbox" value="remember-me"> Lembrar-me
                    </label>
                    </div>
                    <button class="btn btn-lg btn-dark btn-block" type="submit">Autenticar</button>
                    <p class="mt-5 mb-3 text-muted text-center">© 2020</p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
