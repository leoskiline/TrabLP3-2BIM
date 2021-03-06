/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Anuncio;
import entidades.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import persistencia.DALAnuncio;

@MultipartConfig(
        location="/",
        fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*100,
        maxRequestSize = 1024*1024*10*10
)
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
                    try{
                        Part foto1 = request.getPart("foto1");
                        byte[] imagem_foto1 = new byte[(int)foto1.getSize()];
                        foto1.getInputStream().read(imagem_foto1);
                        FileOutputStream arquivo_foto1 = new FileOutputStream(new File(getServletContext().getRealPath("/imagens")+"/1"+foto1.getSubmittedFileName()));
                        String caminho_foto1 = "imagens/1"+foto1.getSubmittedFileName();
                        a.setFoto1(caminho_foto1);
                        arquivo_foto1.write(imagem_foto1);
                        arquivo_foto1.close();
                        Part foto2 = request.getPart("foto2");
                        byte[] imagem_foto2 = new byte[(int)foto2.getSize()];
                        foto2.getInputStream().read(imagem_foto2);
                        FileOutputStream arquivo_foto2 = new FileOutputStream(new File(getServletContext().getRealPath("/imagens")+"/2"+foto2.getSubmittedFileName()));
                        String caminho_foto2 = "imagens/2"+foto2.getSubmittedFileName();
                        a.setFoto2(caminho_foto2);
                        arquivo_foto2.write(imagem_foto2);
                        arquivo_foto2.close();
                        Part foto3 = request.getPart("foto3");
                        byte[] imagem_foto3 = new byte[(int)foto3.getSize()];
                        foto3.getInputStream().read(imagem_foto3);
                        FileOutputStream arquivo_foto3 = new FileOutputStream(new File(getServletContext().getRealPath("/imagens")+"/3"+foto3.getSubmittedFileName()));
                        String caminho_foto3 = "imagens/3"+foto3.getSubmittedFileName();
                        a.setFoto3(caminho_foto3);
                        arquivo_foto3.write(imagem_foto3);
                        arquivo_foto3.close();
                    }catch(IOException e)
                    {
                        response.getWriter().print("<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                                        "    <strong>Falha ao Cadastrar o Anuncio!</strong> \n" +
                                                        "  </div>"+e.toString());
                    }
                    DALAnuncio anunctrl = new DALAnuncio();
                    if(a.getDescricao().length()>0 && a.getContato().length()>0 && a.getFoto1().length()> 0 && a.getFoto2().length()>0 && a.getFoto3().length()>0 && a.getHorario_atendimento().length()>0 && a.getServicos().length()>0 && a.getUsuario().length()>0)
                    {
                        if(anunctrl.inserir(a))
                            response.getWriter().print("<div class=\"alert alert-success alert-dismissible fade show\">\n" +
                                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                                        "    <strong>Anuncio Cadastrado com Sucesso!</strong> \n" +
                                                        "  </div>");
                        else
                            response.getWriter().print("<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                                        "    <strong>Falha ao Cadastrar o Anuncio!</strong> \n" +
                                                        "  </div>");
                    }
                    else
                        response.getWriter().print("<div class=\"alert alert-danger alert-dismissible fade show\">\n" +
                                                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                                                        "    <strong>Preencha todos os Campos!</strong> \n" +
                                                        "  </div>");
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
