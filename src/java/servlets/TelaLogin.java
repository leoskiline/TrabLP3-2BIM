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
                response.getWriter().print("<html>\n" +
"    <head>\n" +
"        <title>Bom Servico</title>\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
"        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container border\">\n" +
"            <div class=\"jumbotron text-black text-center\" style=\"margin-bottom:0\">\n" +
"                <h1>BOMSERVICO.COM</h1>\n" +
"                <p>Plataforma feita para voce realizar um bom negocio ao contratar servicos.</p>\n" +
"            </div>\n" +
"            <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n" +
"                <ul class=\"navbar-nav\">\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a class=\"nav-link\" href=\"index.jsp\">Anuncios</a>\n" +
"                    </li>\n" +
"                    <li class=\"nav-item active\">\n" +
"                        <a class=\"nav-link\">Area do Usuario</a>\n" +
"                    </li>\n" +
"                 </ul>\n" +
"            </nav>\n" +
"            <div class=\"container p-3 my-3 border\" >\n" +
"                <div class=\"container\" id=\"formUser\">\n" +
"                    <form class=\"form-signin\" action=\"TelaLogin\">\n" +
"                        <div class=\"text-center mb-4\">\n" +
"                        <h1 class=\"h3 mb-3 font-weight-normal\">Area do Usuario</h1>\n" +
"                        </div>\n" +
"\n" +
"                        <div class=\"form-label-group\">\n" +
"                        <label for=\"inputEmail\">Usuario</label>\n" +
"                        <input type=\"text\" id=\"usuario\" name=\"usuario\" class=\"form-control\" placeholder=\"Usuario\" autofocus=\"\">\n" +
"                        </div>\n" +
"\n" +
"                        <div class=\"form-label-group pt-3\">\n" +
"                        <label for=\"inputPassword\">Senha</label>\n" +
"                        <input type=\"password\" id=\"senha\" name=\"senha\" class=\"form-control\" placeholder=\"Senha\">\n" +
"\n" +
"                        </div>\n" +
"                            <div class=\"mt-3 mb-3 text-center\"><a href='cadastro.jsp'>Cadastrar</a></div>\n" +
"                            <button class=\"btn btn-lg btn-dark btn-block\" type=\"submit\">Autenticar</button><br>\n" +
"                        <div id=\"ViewUser\"><div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                            "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                            "    <strong>Usuario e/ou Senha Incorretos!</strong>" +
                                            "  </div></div>\n" +
"                        <p class=\"mt-5 mb-3 text-muted text-center\">© 2020</p>\n" +
"                    \n" +
"                    </form>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
        }
        else
            response.getWriter().print("<html>\n" +
"    <head>\n" +
"        <title>Bom Servico</title>\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
"        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container border\">\n" +
"            <div class=\"jumbotron text-black text-center\" style=\"margin-bottom:0\">\n" +
"                <h1>BOMSERVICO.COM</h1>\n" +
"                <p>Plataforma feita para voce realizar um bom negocio ao contratar servicos.</p>\n" +
"            </div>\n" +
"            <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n" +
"                <ul class=\"navbar-nav\">\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a class=\"nav-link\" href=\"index.jsp\">Anuncios</a>\n" +
"                    </li>\n" +
"                    <li class=\"nav-item active\">\n" +
"                        <a class=\"nav-link\">Area do Usuario</a>\n" +
"                    </li>\n" +
"                 </ul>\n" +
"            </nav>\n" +
"            <div class=\"container p-3 my-3 border\" >\n" +
"                <div class=\"container\" id=\"formUser\">\n" +
"                    <form class=\"form-signin\" action=\"TelaLogin\">\n" +
"                        <div class=\"text-center mb-4\">\n" +
"                        <h1 class=\"h3 mb-3 font-weight-normal\">Area do Usuario</h1>\n" +
"                        </div>\n" +
"\n" +
"                        <div class=\"form-label-group\">\n" +
"                        <label for=\"inputEmail\">Usuario</label>\n" +
"                        <input type=\"text\" id=\"usuario\" name=\"usuario\" class=\"form-control\" placeholder=\"Usuario\" autofocus=\"\">\n" +
"                        </div>\n" +
"\n" +
"                        <div class=\"form-label-group pt-3\">\n" +
"                        <label for=\"inputPassword\">Senha</label>\n" +
"                        <input type=\"password\" id=\"senha\" name=\"senha\" class=\"form-control\" placeholder=\"Senha\">\n" +
"\n" +
"                        </div>\n" +
"                            <div class=\"mt-3 mb-3 text-center\"><a href='cadastro.jsp'>Cadastrar</a></div>\n" +
"                            <button class=\"btn btn-lg btn-dark btn-block\" type=\"submit\">Autenticar</button><br>\n" +
"                        <div id=\"ViewUser\"><div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                        "    <strong>Preencha os Campos Obrigatorios!</strong>" +
                                        "  </div></div>\n" +
"                        <p class=\"mt-5 mb-3 text-muted text-center\">© 2020</p>\n" +
"                    \n" +
"                    </form>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
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
