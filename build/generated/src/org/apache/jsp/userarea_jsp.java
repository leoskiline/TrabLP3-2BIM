package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import servlets.TelaUsuario;
import java.sql.ResultSet;

public final class userarea_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 HttpSession sessao = request.getSession();


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Bom Negocio</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/ControllerUsuarios.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container border\">\r\n");
      out.write("            <div class=\"jumbotron text-black text-center\" style=\"margin-bottom:0\">\r\n");
      out.write("                <h1>BOMNEGOCIO.COM</h1>\r\n");
      out.write("                <p>Plataforma feita para voce realizar um bom negocio ao contratar servicos.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n");
      out.write("                <ul class=\"navbar-nav\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp\">Anuncios</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item active\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"userarea.jsp\">Area do Usuario</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                 </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("            <div class=\"container p-3 my-3 border\" id=\"ViewUser\">\r\n");
      out.write("                <div class=\"container\" id=\"formUser\">\r\n");
      out.write("                    <form class=\"form-signin\" onsubmit=\"LogarUsuario()\">\r\n");
      out.write("                    <div class=\"text-center mb-4\">\r\n");
      out.write("                    <h1 class=\"h3 mb-3 font-weight-normal\">Area do Usuario</h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-label-group\">\r\n");
      out.write("                    <label for=\"inputEmail\">Usuario</label>\r\n");
      out.write("                    <input type=\"text\" id=\"usuario\" name=\"usuario\" class=\"form-control\" placeholder=\"Usuario\" required=\"\" autofocus=\"\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-label-group pt-3\">\r\n");
      out.write("                    <label for=\"inputPassword\">Senha</label>\r\n");
      out.write("                    <input type=\"password\" id=\"senha\" name=\"senha\" class=\"form-control\" placeholder=\"Senha\" required=\"\">\r\n");
      out.write("                    \r\n");
      out.write("                    </div>\r\n");
      out.write("                        <div class=\"mt-3 mb-3\"></div>\r\n");
      out.write("                    <button class=\"btn btn-lg btn-dark btn-block\" type=\"submit\">Autenticar</button>\r\n");
      out.write("                    <p class=\"mt-5 mb-3 text-muted text-center\">© 2020</p>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
