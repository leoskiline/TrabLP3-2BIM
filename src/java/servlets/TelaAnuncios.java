/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Anuncio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.DALAnuncio;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "TelaAnuncios", urlPatterns = {"/TelaAnuncios"})
public class TelaAnuncios extends HttpServlet {

    public String buscaAnuncios(String filtro) {
        String res = "";
        ArrayList<Anuncio> anuncios = new DALAnuncio().getAnuncio(filtro);
        for (Anuncio a : anuncios) {
          res += String.format("<tr><td>%s</td><td>%s</td><td><a href='%s' target='_blank'><img class='img-fluid' src='%s'/ style='width:60px;'><a/><a href='%s' target='_blank'><img class='img-fluid' src='%s'/ style='width:60px;'></a><a href='%s' target='_blank'><img class='img-fluid' src='%s'/ style='width:60px;'></a>"
                  + "</td><td>%s</td><td>%s</td><td>%s</td>"
              + "</tr>", "" + a.getServicos(), "" + a.getDescricao(), "" +a.getFoto1(), "" +a.getFoto1(), "" +a.getFoto2(), "" +a.getFoto2(), "" +a.getFoto3(),"" +a.getFoto3(),""+ a.getHorario_atendimento(),""+a.getContato(),""+a.getUsuario());
        }
        return res;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String erro = "";
            String acao = request.getParameter("acao");
            int cod;
            try {
                cod = Integer.parseInt(request.getParameter("cod"));
            } catch (Exception e) {
                cod = 0;
            }
            DALAnuncio ctr = new DALAnuncio();
            switch (acao.toLowerCase()) 
            {
                case "consultar":
                    String filtro = request.getParameter("filtro");
                    String resultado = buscaAnuncios(filtro);
                    response.getWriter().print(resultado);
                    break;
                case "apagar":
                    if (!ctr.apagar(cod))
                       erro = "Erro ao apagar o anuncio";
                    response.getWriter().print(erro);
                    break;
                case "alterar":
                    Anuncio a = ctr.getAnuncio(cod);
                    response.getWriter().print(a); // retorna todos os dados na forma de lista (,,,)
                    break;
                case "confirmar": //novo e alteração
                    erro="ok";
                    String foto1 = request.getParameter("foto1");
                    String foto2 = request.getParameter("foto2");
                    String foto3 = request.getParameter("foto3");
                    String descricao = request.getParameter("descricao");
                    String horario_atendimento = request.getParameter("horario_atendimento");
                    String contato = request.getParameter("contato");
                    String servicos = request.getParameter("servicos");
                    String usuario = request.getParameter("usuario");
                    Anuncio an = new Anuncio(cod,foto1,foto2,foto3,descricao,horario_atendimento,contato,servicos,usuario);
                    if (cod == 0) 
                    {   if (!ctr.inserir(an)) erro = "Erro ao gravar o anuncio";}
                    else 
                    {   if (!ctr.alterar(an)) erro = "Erro ao alterar o anuncio";}
                    response.getWriter().print(erro);
                    break;
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
