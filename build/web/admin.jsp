<%-- 
    Document   : index
    Created on : 17/10/2020, 11:08:09
    Author     : Leonardo
--%>
<%@page import="entidades.Usuario"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  HttpSession sessao = request.getSession(false);
    Usuario user = (Usuario)sessao.getAttribute("usuario");
    if(user == null)
        response.sendRedirect(".");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bom Servico</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/ControllerAdmin.js" type="text/javascript"></script>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="MostrarCategoria()">
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
                    <li class="nav-item active">
                        <a class="nav-link" href="login.jsp">Area do Usuario</a>
                    </li>
            </ul>
            </nav>
            <div class="container p-3 my-3 border">
                <div class='container border pb-3 pt-3' style='text-align:center;font-size:30px'>Pagina do Administrador<form action='Logout' class="float-right mt-1"><input type='submit' value='Deslogar' class='btn btn-outline-danger float-right'/></form><br></div>
                    <div class='row ml-1 mt-3'>
                        <div class='card' style='width:400px;height:400px;'>
                            <img class='card-img-top pl-5' style='width:300px;height:200px' src="<%=user.getFoto()%>"/>
                            <div class="card-body">
                                <h4>Bem-vindo <%=user.getNome()%></h4>
                                <b>Usuario: </b><%=user.getUsuario()%><br>
                                <b>Nivel de Acesso: </b><%=user.getNivel()%><br>
                                <b>Logradouro: </b><%=user.getLogradouro()%>
                            </div>
                        </div>
                            <div class="col-sm-7" align="center">
                                <h5>Gerenciar Categorias</h5>
                                <form name="dados" id="fdados" class="form-inline ml-5">
                                    <input type="text" size="1" class="form-control mb-2 mr-sm-2" placeholder="COD" name="cod" id="cod" disabled/>
                                    <input type="text" class="form-control mb-2 mr-sm-2" placeholder="Digite a Categoria" name="categoria" id="categoria"/>
                                    <input onclick="GravarCategoria()" name="acao" value="Gravar" type="submit" class="btn btn-success mb-2"/>
                                    <input style="margin-left:10px;margin-bottom:8px" value="Listar" onclick="MostrarCategoria()" type="submit" class="btn btn-info"><div id="mostrarCat"></div><div id='gravouCat'></div>
                                </form>
                            </div>
                    </div>
            </div>
        </div>
    </body>
</html>
