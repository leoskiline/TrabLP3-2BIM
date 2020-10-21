/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistencia.DALUsuario;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "TelaLogin", urlPatterns = {"/TelaLogin"})
public class TelaLogin extends HttpServlet {

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
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        if(usuario != "" && senha != "")
        {
            DALUsuario ctrluser = new DALUsuario();
            Usuario user = ctrluser.getUsuario(usuario, senha);
            if(user != null)
            {
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("usuario", user);
                if(user.getNivel().equalsIgnoreCase("administrador"))
                {
                    response.sendRedirect("admin.jsp");
                }
                else
                    response.sendRedirect("user.jsp");
            }
            else
                response.getWriter().print("<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                            "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                            "    <strong>Usuario e/ou Senha Incorretos!</strong>" +
                                            "  </div>");
        }
        else
            response.getWriter().print("<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                        "    <strong>Preencha os Campos Obrigatorios!</strong>" +
                                        "  </div>");
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
