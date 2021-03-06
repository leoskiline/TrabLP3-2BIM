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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/ControllerAnuncios.js" type="text/javascript"></script>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="MostraAnuncios()">
        <div class="container border">
            <div class="jumbotron text-black text-center" style="margin-bottom:0">
                <h1>BOMSERVICO.COM</h1>
                <p>Plataforma feita para voce realizar um bom negocio ao contratar servicos.</p>
            </div>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link">Anuncios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Area do Usuario</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="api.jsp">Usar API</a>
                    </li>
  </ul>
            </nav>
            <div class="container p-3 my-3 border">
                <form name="pesquisa" onsubmit="MostraAnuncios()">
                <div class="form-inline float-right">
                    <label style="margin-right:8px" >Categoria: </label>
                    <select onchange="MostraCategorias()" style="position:relative;top:3px;" class='custom-select mb-2 mr-3' id='categoriaCad' name='categoriaCad'>
                                            <%
                                                DALServico ctrlserv = new DALServico();
                                                ArrayList<Servico> servarray = ctrlserv.getServico("");
                                                for(int i = 0;i < servarray.size();i++)
                                                {
                                                    %><option value="<%=servarray.get(i).getId_servico()%>"><%=servarray.get(i).getCategoria()%></option><%
                                                }
                                            %>
                    </select>
                    <label style="margin-right:8px" >Descricao: </label>
                    <input type="text" name="filtro" id="filtro" size="20" placeholder="Pesquisa" class="form-control mb-2 mr-sm-2" style="position:relative;top:3px;"/> 
                    <input type="submit" name="bpesq" value="Pesquisar" class="btn btn-dark" />
                    <br><br>
                </div>
                </form>
                <div class="container table-responsive">    
                <table class="table table-hover" >
                    <thead>
                        <tr style="text-align:center"><th>Categoria</th><th>Descricao</th><th>Fotos</th><th>Horario de Atendimento</th><th width="200px">Contato</th><th>Usuario</th></tr>
                    </thead>
                    <tbody id="tabelaAnuncios">                
                        <!-- será montada aqui a tabela de anuncios cadastrados-->
                    </tbody>
                </table>
                    <div class="text-center"><a href="ImprimirRelatorio" target="_blank">Imprimir Relatorio de Todos Anuncios</a></div>
            </div>
            </div>
        </div>
    </body>
</html>
