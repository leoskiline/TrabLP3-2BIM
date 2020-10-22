<%-- 
    Document   : index
    Created on : 17/10/2020, 11:08:09
    Author     : Leonardo
--%>
<%@page import="entidades.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="persistencia.DALServico"%>
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
        <script src="js/ControllerUsuario.js" type="text/javascript"></script>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="login.jsp">Area do Usuario</a>
                    </li>
            </ul>
            </nav>
            <div class="container p-3 my-3 border">
                <div class='container border pb-3 pt-3' style='text-align:center;font-size:30px'>Pagina do Prestador de Servico<form action='Logout' class="float-right mt-1"><input type='submit' value='Deslogar' class='btn btn-outline-danger float-right'/></form><br></div>
                    <div class='row ml-1 mt-3'>
                        <div class='card' style='width:400px;height:400px'>
                            <img class='card-img-top' src="<%=user.getFoto()%>"/>
                            <div class="card-body">
                                <h4>Bem-vindo <%=user.getNome()%></h4>
                                <b>Usuario: </b><%=user.getUsuario()%><br>
                                <b>Nivel de Acesso: </b><%=user.getNivel()%><br>
                                <b>Logradouro: </b><%=user.getLogradouro()%>
                            </div>
                        </div>
                            <div style="width: 60%">
                                <div class="col-sm-8" style="margin-left:15%;margin-top:3%" align="center">
                                    <h5>Cadastrar Anuncio</h5><div id="gravouAnuncio"></div>
                                    <form method="POST" name="dados" onsubmit="CadastrarAnuncio()" id="fdados" enctype="multipart/form-data" class="form ml-5">
                                        <input type='hidden' id='acao' name='acao' value='gravaranuncio'/>
                                        <input type='text' class='form-control mb-2 ml-2' placeholder='Descricao' name='descricao' id='descricao'/>
                                        <input type='text' class='form-control mb-2 ml-2' placeholder='Contato' name='contato' id='contato'/>
                                        <input type='text' class='form-control mb-2 ml-2' placeholder='Horario Atendimento' name='horario_atendimento' id='horario_atendimento'/>
                                        <select class='custom-select mb-2 ml-2' id='categoriaCad' name='categoriaCad'>
                                            <%
                                                DALServico ctrlserv = new DALServico();
                                                ArrayList<Servico> servarray = ctrlserv.getServico("");
                                                for(int i = 0;i < servarray.size();i++)
                                                {
                                                    %><option value="<%=servarray.get(i).getId_servico()%>"><%=servarray.get(i).getCategoria()%></option><%
                                                }
                                            %>
                                        </select>
                                        <input class='form-control-file mb-2 ml-2' type='file' placeholder='URL FOTO 1' accept="image/png, image/jpeg" name='foto1' id="foto1"/>
                                        <input class='form-control-file mb-2 ml-2' type='file' placeholder='URL FOTO 2' accept="image/png, image/jpeg" name='foto2' id="foto2"/>
                                        <input class='form-control-file mb-2 ml-2' type='file' placeholder='URL FOTO 3' accept="image/png, image/jpeg" name='foto3' id="foto3"/>
                                        <input value='Gravar' type='submit' class='btn btn-success mb-2 ml-2'/>
                                        <div id='cadAnuncio'></div>
                                    </form>
                                </div>
                            </div>
                    </div>
            </div>
        </div>
    </body>
</html>
