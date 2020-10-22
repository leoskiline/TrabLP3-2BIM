/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import persistencia.DALUsuario;

@MultipartConfig(
        location="/",
        fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*100,
        maxRequestSize = 1024*1024*10*10
)

@WebServlet(name = "TelaCadastro", urlPatterns = {"/TelaCadastro"})
public class TelaCadastro extends HttpServlet {

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
        String caminho_foto = "";
        try{
                        Part foto = request.getPart("foto");
                        byte[] imagem_foto = new byte[(int)foto.getSize()];
                        foto.getInputStream().read(imagem_foto);
                        FileOutputStream arquivo_foto = new FileOutputStream(new File(getServletContext().getRealPath("/imagens/")+usuario+"-"+foto.getSubmittedFileName()));
                        caminho_foto = getServletContext().getContextPath()+"/imagens/"+usuario+"-"+foto.getSubmittedFileName();
                        arquivo_foto.write(imagem_foto);
                        arquivo_foto.close();
        }catch(IOException e)
        {
            response.getWriter().print("<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                            "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "    <strong>Falha ao Cadastrar Usuario!</strong> \n" +
                            "  </div>");
        }
        String nome = request.getParameter("nome");
        String logradouro = request.getParameter("logradouro");
        DALUsuario ctrl = new DALUsuario();
        Usuario u = new Usuario(usuario,senha,"prestador de servico",caminho_foto,nome,logradouro);
        String resposta = "<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                            "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "    <strong>Falha ao Cadastrar Usuario!</strong> \n" +
                            "  </div>";
        if(ctrl.inserir(u))
        {
            resposta = "<div class=\"alert alert-success alert-dismissible fade show\">\n" +
                            "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                            "    <strong>Usuario Cadastrado com Sucesso!</strong> \n" +
                            "  </div>";
        }
        response.getWriter().print(resposta);
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
