/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Servico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.DALServico;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "TelaAdmin", urlPatterns = {"/TelaAdmin"})
public class TelaAdmin extends HttpServlet {

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
        String categoria = request.getParameter("categoria");
        int cod;
        try {
            cod = Integer.parseInt(request.getParameter("cod"));
        } catch (Exception e) {
            cod = 0;
        }
        if(acao != null)
        {
            DALServico ctrl = new DALServico();
            switch(acao.toLowerCase())
            {
                case "mostrar":
                    String resposta = buscaCategorias(categoria);
                    response.getWriter().print(resposta);
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
            }
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
