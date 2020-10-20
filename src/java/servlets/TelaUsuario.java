/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Anuncio;
import entidades.Servico;
import entidades.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistencia.DALAnuncio;
import persistencia.DALServico;
import persistencia.DALUsuario;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "TelaUsuario", urlPatterns = {"/TelaUsuario"})
public class TelaUsuario extends HttpServlet {

    public String tipoTela(String usuario,String senha,HttpSession sessao)
    {
        DALUsuario ctrl = new DALUsuario();
        Usuario user = ctrl.getUsuario(usuario, senha);
        String res = "";
        if(user != null && user.getNivel().equalsIgnoreCase("administrador"))
        {
            res = String.format("<div class='container border pb-3 pt-3' style='text-align:center;font-size:30px'>Seja bem vindo(a) ao Sistema<form action='Logout' class=\"float-right mt-1\"><input type='submit' value='Deslogar' class='btn btn-outline-danger float-right'/></form><br></div>"
                              + "<div class='row pl-3'><div class='card' style=\"width:400px;height:400px\">\n" +
                                "  <img class=\"card-img-top\" src=\"%s\" alt=\"Card image\">\n" +
                                "  <div class=\"card-body\">\n" +
                                "    <h4>bem-vindo %s</h4>\n" +
                                "    <br><b>Usuario:</b> %s.\n" +
                                "    <br><b>Nivel de Acesso:</b> %s.\n" +
                                "    <br><b>Logradouro:</b> %s.\n" +
                                "  </div></div><div class='col-sm-7' align='center'><h5>Gerenciar Categorias</h5>"
                                + "<form name='dados' id='fdados' class=\"form-inline ml-5\">\n" +
                                "  <input type=\"text\" size='1' class=\"form-control mb-2 mr-sm-2\" placeholder=\"COD\" name='cod' id='cod' disabled><input type=\"text\" class=\"form-control mb-2 mr-sm-2\" placeholder=\"Digite a Categoria\" name='categoria' id='categoria' required>\n" +
                                "  <input onclick='GravarCategoria()' name='acao' value='Gravar' type='submit' class='btn btn-success mb-2'/><input style='margin-left:10px;margin-bottom:8px;' value='Listar' onclick='MostrarCategoria2()' type='submit' class='btn btn-info'/><div id='mostrarCat'></div><div id='gravouCat'></div>\n" +
                                "</form></div>" +
                                "</div></div>"
                    , user.getFoto(),""+user.getNome(),""+user.getUsuario(),""+user.getNivel(),""+user.getLogradouro());
        }
        if(user != null && user.getNivel().equalsIgnoreCase("prestador de servico"))
        {
            DALServico serv = new DALServico();
            ArrayList<Servico> servarray = serv.getServico("");
            res = "<div class='container border pb-3 pt-3' style='text-align:center;font-size:30px'>PAGINA DO PRESTADOR DE SERVICO<form action='Logout' class=\"float-right mt-1\"><input type='submit' value='Deslogar' class='btn btn-outline-danger float-right'/></form><br></div>"
                              + "<div class='row pl-3'><div class='card' style=\"width:400px;height:400px;margin-top:2%\">\n" +
                                "  <img class=\"card-img-top\" src='"+user.getFoto()+"' alt=\"Card image\">\n" +
                                "  <div class=\"card-body\">\n" +
                                "    <h4>bem-vindo "+user.getNome()+"</h4>\n" +
                                "    <br><b>Usuario:</b> "+user.getUsuario()+".\n" +
                                "    <br><b>Nivel de Acesso:</b> "+user.getNivel()+".\n" +
                                "    <br><b>Logradouro:</b> "+user.getLogradouro()+".\n" +
                                "  </div></div><div style='width:60%;'><div class='col-sm-8' style='margin-left:15%;margin-top:3%;' align='center'><h5>Cadastrar Anuncio</h5><div id='gravouAnuncio'></div>"
                                + "<form method='GET' action='TelaUsuario' name='dados' id='fdados' class='form ml-5'>" +
                                "<input type='hidden' name='usuario2' value='"+user.getUsuario()+"'/><input type='hidden' name='senha' value='"+user.getSenha()+"'/><input type='hidden' id='acao' name='acao' value='gravarAnuncio'/><input type='text' class='form-control mb-2 ml-2' placeholder='Descricao' onselect='SelectCategorias()' name='descricao' id='descricao'/>"
                                + "<input type='text' class='form-control mb-2 ml-2' placeholder='Contato' name='contato' id='contato'/>"
                                + "<input type='hidden' id='userid' name='userid' value='"+user.getId_usuario()+"'></input><input type='text' class='form-control mb-2 ml-2' placeholder='Horario Atendimento' name='horario_atendimento' id='horario_atendimento'/>"
                                 + "<select class='custom-select mb-2 ml-2' id='categoriaCad' name='categoriaCad'>\n" +
                                    "    <option value='' disabled selected>Categoria</option>";
                                    for(int i = 0; i < servarray.size();i++)
                                    {
                                        res += "<option value='"+servarray.get(i).getId_servico()+"'>"+servarray.get(i).getCategoria()+"</option>";
                                    }
            res += "  </select><input class='form-control mb-2 ml-2' type='text' placeholder='URL FOTO 1' name='foto1'/><input class='form-control mb-2 ml-2' type='text' placeholder='URL FOTO 2' name='foto2'/><input class='form-control mb-2 ml-2' type='text' placeholder='URL FOTO 3' name='foto3'/><input value='Gravar' type='submit' class='btn btn-success mb-2 ml-2'/></form><div></div>"
                    + "</div></div>";
            
        }
        if(user == null)
            res = "<div style='text-align:center' class=\"alert alert-danger alert-dismissible fade show\">\n" +
                    "    <strong>Usuario e/ou Senha Incorreta</strong>\n" +
                    "  </div>";
        return res;
    }
    
    public String buscaCategorias(String filtro) {
        String res = "<table class='table table-hover'><thead><tr><th>ID</th><th>Tipo de Servico</th><th>Opcoes</th></tr></thead><tbody>";
        ArrayList<Servico> servicos = new DALServico().getServico(filtro);
        for (Servico s : servicos) {
          res += String.format("<tr><td style='width:20%%'>%s</td><td style='width:60%%'>%s</td><td style='width:20%%'><img onclick='ApagaAlteraCategoria(\"apagar\",%s)' src='icones/apagar.png'/><img onclick='ApagaAlteraCategoria(\"alterar\",%s)' class='ml-3' src='icones/alterar.png'/></td></tr>",s.getId_servico(),""+ s.getCategoria(),""+s.getId_servico(),""+s.getId_servico());
        }
        res += "</tbody></table>";
        return res;
    }
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String erro = "";
        String acao = request.getParameter("acao");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String categoria = request.getParameter("categoria");
        int cod;
        try {
            cod = Integer.parseInt(request.getParameter("cod"));
        } catch (Exception e) {
            cod = 0;
        }
        DALServico ctrl = new DALServico();
        if(acao != null)
        {
            switch(acao.toLowerCase())
            {
                case "mostrar":
                    String resultado = buscaCategorias(categoria);
                    response.getWriter().print(resultado);
                    break;
                case "apagar":
                    if(!ctrl.apagar(cod)) 
                    {
                         erro = "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                "    <strong>Falha ao Apagar Categoria!</strong> \n" +
                                "  </div>";
                    }
                    response.getWriter().print(erro);
                    break;
                case "alterar":
                    Servico s = ctrl.getServico(cod);
                    String retorno = s.getId_servico()+","+s.getCategoria();
                    response.getWriter().print(retorno);
                    break;
                case "confirmar":
                    erro = "<div class=\"alert alert-success alert-dismissible fade show\">\n" +
                            "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "    <strong>Operacao Efetuada Com Sucesso!</strong> \n" +
                            "  </div>";
                    Servico serv = new Servico(cod,categoria);
                    if (cod == 0) 
                        { 
                            if (!ctrl.inserir(serv))
                            {
                                erro = "<div class=\"alert alert-dar alert-dismissible fade show\">\n" +
                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                        "    <strong>Falha ao Apagar Categoria!</strong> \n" +
                                        "  </div>";
                            }
                                
                        }
                        else 
                        {   
                            if (!ctrl.alterar(serv))
                            {
                                erro = "<div class=\"alert alert-dar alert-dismissible fade show\">\n" +
                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                        "    <strong>Falha ao Apagar Categoria!</strong> \n" +
                                        "  </div>";
                            }
                        }
                        response.getWriter().print(erro);
                    break;
                case "gravaranuncio":
                    Anuncio a = new Anuncio();
                    a.setContato(request.getParameter("contato"));
                    a.setDescricao(request.getParameter("descricao"));
                    a.setUsuario(request.getParameter("userid"));
                    a.setHorario_atendimento(request.getParameter("horario_atendimento"));
                    a.setServicos(request.getParameter("categoriaCad"));
                    a.setFoto1(request.getParameter("foto1"));
                    a.setFoto2(request.getParameter("foto2"));
                    a.setFoto3(request.getParameter("foto3"));
                    DALAnuncio anunctrl = new DALAnuncio();
                    if(a.getDescricao().length()>0 && a.getContato().length()>0 && a.getFoto1().length()> 0 && a.getFoto2().length()>0 && a.getHorario_atendimento().length()>0 && a.getServicos().length()>0 && a.getUsuario().length()>0)
                    {
                        anunctrl.inserir(a);
                    }
                    else
                    response.sendRedirect(".");
                    break;

            }
        }
        HttpSession sessao=request.getSession(true);
        sessao.setAttribute("usuario", new Usuario(usuario,senha));
        if(usuario != null)
        {
            String resultado = tipoTela(usuario,senha,sessao);
            response.getWriter().print(resultado);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
