package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Dtos.ProfesorDTO;
import java.util.LinkedList;
import modelo.daos.ProfesorDAO;

public final class listado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listado de profesores</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Muestra el listado de profesores</h1>\n");
      out.write("\n");
      out.write("        ");

            ProfesorDAO pdao = new ProfesorDAO();
            LinkedList<ProfesorDTO> lista = new LinkedList<ProfesorDTO>();
            lista = (LinkedList<ProfesorDTO>) pdao.getAll();

        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Codigo</th>\n");
      out.write("                    <th>Nombre docente</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th>user</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    for (ProfesorDTO p : lista) {

                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(p.getClaveProfesor());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(p.getNombreCompleto());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(p.getCorreoElectronico());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(p.getUserName());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
      out.write("\n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
