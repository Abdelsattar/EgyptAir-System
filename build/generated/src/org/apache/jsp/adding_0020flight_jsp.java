package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adding_0020flight_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Adding Flight page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/Style1.css\">\n");
      out.write("        <script>\n");
      out.write("            function validateForm() {\n");
      out.write("                var source = document.forms[\"flightForm\"][\"source\"].value;\n");
      out.write("                var destination = document.forms[\"flightForm\"][\"destination\"].value;\n");
      out.write("                var day = document.forms[\"flightForm\"][\"day\"].value;\n");
      out.write("                var month = document.forms[\"flightForm\"][\"month\"].value;\n");
      out.write("                var year = document.forms[\"flightForm\"][\"year\"].value;\n");
      out.write("                var dept_place = document.forms[\"flightForm\"][\"dept_place\"].value;\n");
      out.write("                var cost = document.forms[\"flightForm\"][\"cost\"].value;\n");
      out.write("                var aircraftID = document.forms[\"flightForm\"][\"aircraftID\"].value;\n");
      out.write("                var name = document.forms[\"flightForm\"][\"name\"].value;\n");
      out.write("                \n");
      out.write("                if (name == null || name == \"\") {\n");
      out.write("                    alert(\"Name must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (source == null || source == \"\") {\n");
      out.write("                    alert(\"Source must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (destination == null || destination == \"\") {\n");
      out.write("                    alert(\"Destination must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (day == null || day == \"\") {\n");
      out.write("                    alert(\"Day must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (day <1 || day >31) {\n");
      out.write("                    alert(\"Invalid Day value\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (month == null || month == \"\") {\n");
      out.write("                    alert(\"Month must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (month <1 || month >12) {\n");
      out.write("                    alert(\"Invalid month value\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (year == null || year == \"\") {\n");
      out.write("                    alert(\"Year must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (year <2015 || year >2016) {\n");
      out.write("                    alert(\"Invalid year value\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (dept_place == null || dept_place == \"\") {\n");
      out.write("                    alert(\"Depature Place must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (cost == null || cost == \"\") {\n");
      out.write("                    alert(\"cost must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (cost < 200)\n");
      out.write("                {\n");
      out.write("                    alert(\"cost cannot be less than 200 LE\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if (aircraftID == null || aircraftID == \"\") {\n");
      out.write("                    alert(\"Aircraft must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Flight details</h1>\n");
      out.write("        <form name=\"flightForm\" action =\"AddFlightDB\" onsubmit=\"return validateForm();\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Name</td> <td><input type=\"text\" name =\"name\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Source</td> <td><input type=\"text\" name =\"source\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Destination</td><td><input type =\"text\" name =\"destination\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Date</td><td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Day</td> <td><input type=\"text\" name =\"day\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Month</td> <td><input type=\"text\" name =\"month\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Year</td> <td><input type=\"text\" name =\"year\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Departure Place</td><td><input type =\"text\" name =\"dept_place\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Cost</td><td><input type =\"text\" name =\"cost\"></td>\n");
      out.write("                </tr> \n");
      out.write("                <tr>\n");
      out.write("                    <td align =\"right\">Aircraft</td><td><input type =\"text\" name =\"aircraftID\"></td>\n");
      out.write("                </tr> \n");
      out.write("                <tr>\n");
      out.write("                    <td></td><td align =\"right\"><input type =\"submit\" value =\"Add flight\" ></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
