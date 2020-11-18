/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import utils.Conexao;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "ImprimirRelatorio", urlPatterns = {"/ImprimirRelatorio"})
public class ImprimirRelatorio extends HttpServlet {

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
        response.setContentType("application/pdf");
        byte[] pdf=gerarRelatorioPDF("SELECT * FROM anuncios a INNER JOIN servicos s ON s.id_servico = a.servicos INNER JOIN usuarios u ON u.id_usuario = a.usuario",getServletContext().getRealPath("")+"relatorios\\RelatorioAnuncios.jasper");
        response.getOutputStream().write(pdf,0,pdf.length);
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
    private byte[] gerarRelatorioPDF(String sql, String relat)
        {   
            byte[] pdf;
            try { //sql para obter os dados para o relatorio
                JasperPrint jasperprint=null;
                ResultSet rs = new Conexao().consultar(sql);
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                jasperprint = JasperFillManager.fillReport(relat, null, jrRS);
                pdf=JasperExportManager.exportReportToPdf(jasperprint);
            } catch (JRException erro) {
                pdf=null;
            }
            return pdf;
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
