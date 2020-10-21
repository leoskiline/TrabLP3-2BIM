/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Anuncio;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistencia.DALAnuncio;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "TelaUsuario", urlPatterns = {"/TelaUsuario"})
public class TelaUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if(acao != null)
        {
            switch(acao.toLowerCase())
            {
                case "gravaranuncio":
                    Anuncio a = new Anuncio();
                    HttpSession sessao = request.getSession(false);
                    Usuario user = (Usuario)sessao.getAttribute("usuario");
                    a.setContato(request.getParameter("contato"));
                    a.setDescricao(request.getParameter("descricao"));
                    String userid = Integer.toString(user.getId_usuario());
                    a.setUsuario(userid);
                    a.setHorario_atendimento(request.getParameter("horario_atendimento"));
                    a.setServicos(request.getParameter("categoriaCad"));
                    a.setFoto1(request.getParameter("foto1"));
                    a.setFoto2(request.getParameter("foto2"));
                    a.setFoto3(request.getParameter("foto3"));
                    DALAnuncio anunctrl = new DALAnuncio();
                    if(a.getDescricao().length()>0 && a.getContato().length()>0 && a.getFoto1().length()> 0 && a.getFoto2().length()>0 && a.getHorario_atendimento().length()>0 && a.getServicos().length()>0 && a.getUsuario().length()>0)
                    {
                        if(anunctrl.inserir(a))
                            response.getWriter().print("<script>function sucesso(){alert('Anuncio Gravado com Sucesso!')}</script><body align='center' onload='sucesso()'><a style='font-size:40px' href='login.jsp'>Voltar</a></body>");
                        else
                            response.getWriter().print("<script>function falha(){alert('Falha ao Gravar Anuncio!')}</script><body align='center' onload='falha()'><a style='font-size:40px' href='login.jsp'>Voltar</a></body>");
                    }
                    else
                        response.getWriter().print("<script>function falha(){alert('Falha ao Gravar Anuncio!')}</script><body align='center' onload='falha()'><a style='font-size:40px' href='login.jsp'>Voltar</a></body>");
                    //response.sendRedirect("index.jsp");
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
