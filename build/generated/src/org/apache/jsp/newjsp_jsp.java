package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Order;
import model.Category;
import java.util.ArrayList;
import model.Product;
import model.Account;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <meta name=\"author\" content=\"\" />\n");
      out.write("        <title>Manage Page</title>\n");
      out.write("        <!-- Favicon-->\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Font Awesome icons (free version)-->\n");
      out.write("        <script src=\"https://use.fontawesome.com/releases/v5.15.3/js/all.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!-- Google fonts-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!-- Core theme CSS (includes Bootstrap)-->\n");
      out.write("        <link href=\"css/styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("    ");

        Account account = (Account) session.getAttribute("account");
        ArrayList<Account> listA = (ArrayList<Account>) request.getAttribute("listA");
        ArrayList<Category> listC = (ArrayList<Category>) request.getAttribute("listC");
        ArrayList<Order> listO = (ArrayList<Order>) request.getAttribute("listO");
        ArrayList<Product> listP = (ArrayList<Product>) request.getAttribute("listP");
        if (account == null || account.isIsAdmin() == false) {
    
      out.write("\n");
      out.write("    <h2>You must be admin to access this</h2>\n");
      out.write("    ");
 } else { 
      out.write("\n");
      out.write("    <body class=\"masthead\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-2\">\n");
      out.write("                    <div class=\"card bg-light mb-3\">\n");
      out.write("                        <div class=\"card-header bg-primary text-white text-uppercase\"><i class=\"fa fa-list\"></i> Management </div>\n");
      out.write("                        <ul class=\"list-group category_block\">\n");
      out.write("                            <li class=\"list-group-item text-white \" > <a class=\"tablinks\"  onclick=\"openObject(event, 'Product')\" style=\"text-decoration: none; color: black;\"> Product Management </a></li>\n");
      out.write("                            <li class=\"list-group-item text-white \" > <a class=\"tablinks\"  onclick=\"openObject(event, 'Account')\" style=\"text-decoration: none; color: black;\"> Account Management </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                    Object mess = request.getAttribute("mess");
                    if (mess == null) {
                        mess = "";
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Form addP -->\n");
      out.write("                <div class=\"col-sm-6\" id=\"AddP\" name=\"tabcontent\" style=\" background-color: white; margin: 0 1%;border-radius: 2px;display: none;\" >\n");
      out.write("                    <div id=\"content\" class=\"row\">\n");
      out.write("                        <h6 style=\"color: red\" style=\"font-size: small\" >");
      out.print( mess);
      out.write("</h6>\n");
      out.write("                        <form action=\"admin\" method=\"get\">\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">ProductID:</label> <br>\n");
      out.write("                                <input name=\"pid\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">ProductName:</label><br>\n");
      out.write("                                <input name=\"pname\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">Link image:</label><br>\n");
      out.write("                                <input name=\"image\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">Price:</label><br>\n");
      out.write("                                <input name=\"price\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">Quantity:</label><br>\n");
      out.write("                                <input name=\"quantity\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">Title:</label><br>\n");
      out.write("                                <input name=\"title\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <label style=\"color: black;\">Description:</label><br>\n");
      out.write("                                <input name=\"description\" type=\"text\" required>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div>\n");
      out.write("                                <select name=\"cid\" aria-label=\"Default select example\">\n");
      out.write("                                    ");

                                        for (Category c : listC) {
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( c.getCid());
      out.write("\"> ");
      out.print( c.getCname());
      out.write("</option>\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-success\" value=\"Add Product\">\n");
      out.write("                                <input type=\"hidden\" name=\"service\" value=\"addP\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Product -->\n");
      out.write("                <div class=\"col-sm-6\" id=\"Product\" name=\"tabcontent\" style=\" background-color: white; margin: 0 1%;border-radius: 2px;display: block;\" >\n");
      out.write("                    <div id=\"content\" class=\"row\">\n");
      out.write("                        <div class=\"table-title\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-6\">\n");
      out.write("                                    <h2 style=\"color: black;\"> Features </h2>\n");
      out.write("                                    <h3 style=\"color: red;\" style=\"font-size: small\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-6\" style=\"text-align: right;\">\n");
      out.write("                                    <!--<a  class=\"btn btn-success\" data-toggle=\"modal\" href=\"#addEmployeeModal\" ><span>Add New Product</span></a>-->\n");
      out.write("                                    <a onclick=\"openObject(event, 'AddP')\"  class=\"btn btn-success\"  data-toggle=\"modal\"><span>Add New Product</span></a>\t\t\t\t\t\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <table class=\"table table-striped table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>ID</th>\n");
      out.write("                                    <th>Product</th>\n");
      out.write("                                    <th>Image</th>\n");
      out.write("                                    <th>Price</th>\n");
      out.write("                                    <th>Quantity</th>\n");
      out.write("                                    <th>Actions</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");

                                    for (Product p : listP) {
                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print( p.getPid());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( p.getName());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <img width=\"300\" height=\"370\" class=\"img-fluid\" src=\"");
      out.print( p.getImg());
      out.write("\">\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>");
      out.print( p.getPrice());
      out.write("đ</td>\n");
      out.write("                                    <td>");
      out.print( p.getQuantity());
      out.write(" left</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <button class=\"btn btn-danger\"><a style=\"text-decoration: none;color: black;\" href=\"admin?service=deleteP&pid=");
      out.print( p.getPid());
      out.write("\">Delete</a></button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Account -->\n");
      out.write("                <div class=\"col-sm-6\" id=\"Account\" name=\"tabcontent\" style=\" background-color: white; margin: 0 1%;border-radius: 2px;display: none;\" >\n");
      out.write("                    <div id=\"content\" class=\"row\">\n");
      out.write("                        <h6 style=\"color: red\" style=\"font-size: small\" >");
      out.print( mess);
      out.write("</h6>\n");
      out.write("                        <table class=\"table table-striped table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Username</th>\n");
      out.write("                                    <th>Password</th>\n");
      out.write("                                    <th>Action</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");

                                    for (Account a : listA) {
                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print( a.getUsername());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( a.getPassword());
      out.write("</td><td>\n");
      out.write("                                        <button class=\"btn btn-danger\"><a style=\"text-decoration: none;color: black;\" href=\"admin?service=deleteA&username=");
      out.print( a.getUsername());
      out.write("\">Delete</a></button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-6\" id=\"Account\" name=\"tabcontent\" style=\" background-color: white; margin: 0 1%;border-radius: 2px;display: none;\" >\n");
      out.write("                    <div id=\"content\" class=\"row\">\n");
      out.write("                        <h6 style=\"color: red\" style=\"font-size: small\" >");
      out.print( mess);
      out.write("</h6>\n");
      out.write("                        <table class=\"table table-striped table-hover\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Username</th>\n");
      out.write("                                    <th>Password</th>\n");
      out.write("                                    <th>Action</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");

                                    for (Account a : listA) {
                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print( a.getUsername());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( a.getPassword());
      out.write("</td><td>\n");
      out.write("                                        <button class=\"btn btn-danger\"><a style=\"text-decoration: none;color: black;\" href=\"admin?service=deleteA&username=");
      out.print( a.getUsername());
      out.write("\">Delete</a></button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div style=\"background-color: white; box-sizing: border-box; border-radius: 2px;\" class=\"col-sm-3\">\n");
      out.write("                    <table class=\"table table-striped table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>OrderID</th>\n");
      out.write("                                <th>Username</th>\n");
      out.write("                                <th>Total</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                for (Order o : listO) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href =\"order?oid=");
      out.print( o.getOrderid() );
      out.write('"');
      out.write('>');
      out.print( o.getOrderid() );
      out.write("</a>\n");
      out.write("                                </td>\n");
      out.write("                                <td>");
      out.print( o.getUsername() );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( o.getTotal() );
      out.write(" vnđ</td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Edit Modal HTML -->\n");
      out.write("            <div id=\"addEmployeeModal\" class=\"modal fade\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <form action=\"add\" method=\"get\">\n");
      out.write("                            <div class=\"modal-header\">\t\t\t\t\t\t\n");
      out.write("                                <h4 class=\"modal-title\">Add Product</h4>\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\t\t\t\t\t\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Name</label>\n");
      out.write("                                    <input name=\"name\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Image</label>\n");
      out.write("                                    <input name=\"image\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Price</label>\n");
      out.write("                                    <input name=\"price\" type=\"text\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Title</label>\n");
      out.write("                                    <textarea name=\"title\" class=\"form-control\" required></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Description</label>\n");
      out.write("                                    <textarea name=\"description\" class=\"form-control\" required></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Category</label>\n");
      out.write("                                    <select name=\"category\" class=\"form-select\" aria-label=\"Default select example\">\n");
      out.write("                                        <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCC}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"o\">\n");
      out.write("                                            <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.cid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.cname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                                        </c:forEach>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <input type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" value=\"Cancel\">\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-success\" value=\"Add\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function openObject(evt, Object) {\n");
      out.write("            // Declare all variables\n");
      out.write("            var i, tabcontent, tablinks;\n");
      out.write("            // Get all elements with class=\"tabcontent\" and hide them\n");
      out.write("            tabcontent = document.getElementsByName(\"tabcontent\");\n");
      out.write("            for (i = 0; i < tabcontent.length; i++) {\n");
      out.write("                tabcontent[i].style.display = \"none\";\n");
      out.write("            }\n");
      out.write("            // Get all elements with class=\"tablinks\" and remove the class \"active\"\n");
      out.write("            tablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("            for (i = 0; i < tablinks.length; i++) {\n");
      out.write("                tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n");
      out.write("            }\n");
      out.write("            // Show the current tab, and add an \"active\" class to the link that opened the tab\n");
      out.write("            document.getElementById(Object).style.display = \"block\";\n");
      out.write("            evt.currentTarget.className += \" active\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</html>");
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
