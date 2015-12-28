package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adding_0020aircraft_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Adding aircraft page</title>\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"Style1.css\">\n");
      out.write("         <script type=\"text/javascript\" src=\"aircraftFormVaildation.js\"></script>\n");
      out.write("         <script>\n");
      out.write("             \n");
      out.write("             function validateForm() {\n");
      out.write("                var model = document.forms[\"aircraftForm\"][\"model\"].value;\n");
      out.write("                var name = document.forms[\"aircraftForm\"][\"name\"].value;\n");
      out.write("                var weight = document.forms[\"aircraftForm\"][\"weight\"].value;\n");
      out.write("                var country = document.forms[\"aircraftForm\"][\"country\"].value;\n");
      out.write("                var seatsNum = document.forms[\"aircraftForm\"][\"seats\"].value;\n");
      out.write("                var classesNum = document.forms[\"aircraftForm\"][\"classes\"].value;\n");
      out.write("                if ( model == null || model== \"\") {\n");
      out.write("                    alert(\"model must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (name == null || name == \"\") {\n");
      out.write("                    alert(\"Name must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (name.length <=2) {\n");
      out.write("                    alert(\"Name must be bigger than 3 char\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if (weight == null || weight== \"\") {\n");
      out.write("                    alert(\"weight must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }if (country == null || country == \"\") {\n");
      out.write("                    alert(\"country must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }if (seatsNum == null || seatsNum == \"\") {\n");
      out.write("                    alert(\"seatsNum must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }if (classesNum == null || classesNum == \"\") {\n");
      out.write("                    alert(\"classes must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("\t\t\t\treturn true;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("          </script>\n");
      out.write("     </head>\n");
      out.write("    <body>\n");
      out.write("      <h1>Aircraft details</h1>\n");
      out.write("      <!-- action =\"confirm adding aircraft.html\"--> \n");
      out.write("      <form name=\"aircraftForm\"  action = \"addAirCarftDB\" onsubmit=\"return validateForm()\">\n");
      out.write("\t     <table>\n");
      out.write("   \t\t    <tr>\n");
      out.write("   \t\t      <td align =\"right\">Model</td>\n");
      out.write("                      <td><input type=\"text\" name =\"model\"></td>\n");
      out.write("   \t\t    </tr> <tr>\n");
      out.write("   \t\t      <td align =\"right\">Name</td>\n");
      out.write("                      <td><input type=\"text\" name =\"name\"></td>\n");
      out.write("   \t\t    </tr>\n");
      out.write("   \t\t    <tr>\n");
      out.write("   \t\t    \t<td align =\"right\">Manufacturer country</td>\n");
      out.write("                        <td><input type =\"text\" name =\"country\"></td>\n");
      out.write("   \t\t    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td align =\"right\">Weight</td> \n");
      out.write("                      <td><input type=\"number\" name =\"weight\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td align =\"right\">Number of Seats</td>\n");
      out.write("                      <td><input type =\"number\" name =\"seats\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td align =\"right\">Number of Classes</td>\n");
      out.write("                      <td><input type =\"number\" name =\"classes\"></td>\n");
      out.write("                    </tr> \n");
      out.write("   \t\t    <tr>\n");
      out.write("   \t\t    \t<td></td><td align =\"right\">\n");
      out.write("                        <input type =\"submit\" value =\"Add Aircraft\" ></td>\n");
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
