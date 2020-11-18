<%-- 
    Document   : index
    Created on : 17/10/2020, 11:08:09
    Author     : Leonardo
--%>
<%@page import="entidades.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="persistencia.DALServico"%>
<%@page import="servlets.TelaAnuncios"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Bom Servico</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="js/ControllerAPI.js" type="text/javascript"></script>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container border">
            <div class="jumbotron text-black text-center" style="margin-bottom:0">
                <h1>BOMSERVICO.COM</h1>
                <p>Plataforma feita para voce realizar um bom negocio ao contratar servicos.</p>
            </div>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Anuncios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Area do Usuario</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="api.jsp">Usar API</a>
                    </li>
  </ul>
            </nav>
            <div class="container p-3 my-3 border">
                <form name="pesquisa" onsubmit="MostraAnuncios()">
                <div class="form-inline float-right" >
                    <input class="form-control ml-3" placeholder="Digite a Categoria" name="categoria" style="width: 50%" id="categoria" type="text">
                    <input class="btn btn-success ml-3" type="submit" value="Obter JSON">
                </div>
                </form>
                <div class="container p-3 border mt-5 text-break" id="JSON">
                <%-- Aqui vai ser apresentado o JSON --%>
                </div>
            </div>
            
        </div>
    </body>
</html>
