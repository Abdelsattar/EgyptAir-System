package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class edit_0020aircraft_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Editing aircraft page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/Style1.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            boolean checkDB = (boolean) request.getSession().getAttribute("aircraftexsit");
                String model = (String) request.getSession().getAttribute("model");
                String name = (String) request.getSession().getAttribute("name");
                String weight =( String) request.getSession().getAttribute("weight");
                String country = (String) request.getSession().getAttribute("country");
                String seatsNum = (String) request.getSession().getAttribute("seats");
                String aircraftId = (String) request.getSession().getAttribute("aircraftid");
                String classes = (String) request.getSession().getAttribute("classes");
            
      out.write("\n");
      out.write("      <h1>Aircraft details</h1>\n");
      out.write("      <form>\n");
      out.write("\t     <table>\n");
      out.write("                   <tr>\n");
      out.write("                        <td align =\"right\">Name</td> \n");
      out.write("                        <td><p> ");
      out.print( name );
      out.write("  </p></td>\n");
      out.write("   \t\t    </tr>\n");
      out.write("   \t\t    <tr>\n");
      out.write("   \t\t\t   <td align =\"right\">Model</td>\n");
      out.write("                           <td><input type=\"text\" name =\"model\" value =\"");
      out.print( model );
      out.write("\" ></td>\n");
      out.write("   \t\t    </tr>\n");
      out.write("                     \n");
      out.write("   \t\t    <tr>\n");
      out.write("   \t\t    \t<td align =\"right\">Manufacturer country</td>\n");
      out.write("                        <td><input type =\"text\" name =\"countary\" value =\"");
      out.print( country );
      out.write("\"></td>\n");
      out.write("   \t\t    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td align =\"right\">Weight</td>\n");
      out.write("                      <td><input type=\"text\" name =\"weight\" value =\"");
      out.print( weight );
      out.write("\" ></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td align =\"right\">Number of Seats</td>\n");
      out.write("                      <td><input type =\"text\" name =\"seats\" value =\"");
      out.print( seatsNum );
      out.write("\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td align =\"right\">Number of Classes</td>\n");
      out.write("                      <td><input type =\"text\" name =\"classes\" value =\"");
      out.print( classes );
      out.write("\"></td>\n");
      out.write("                    </tr> \n");
      out.write("   \t\t    <tr>\n");
      out.write("   \t\t    \t<td></td><td align =\"right\">\n");
      out.write("                            <input type =\"submit\" value =\"updateAircraft\" ></td>\n");
      out.write("   \t\t    </tr>\n");
      out.write("         </table>\n");
      out.write("      </form>\n");
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
