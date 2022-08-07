/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductDAO;

/**
 *
 * @author 84337
 */
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        ProductDAO pDAL = new ProductDAO();
        String rmpid = request.getParameter("pid");
        try {
            HashMap<String, Integer> hashCart = (HashMap< String, Integer>) session.getAttribute("hashCart");
            if (hashCart == null) {
                hashCart = pDAL.getCart((String) session.getAttribute("user"));
            }
            List<Product> listCart = new ArrayList<>();
            for (String pid : hashCart.keySet()) {
                Product pCart = pDAL.getProductById(pid);
                Product pCart_Amout = new Product(pCart.getPid(), pCart.getName(), pCart.getDescription(), pCart.getPrice(), hashCart.get(pid), pCart.getCatid(), pCart.getImage());
                listCart.add(pCart_Amout);
            }
            if (rmpid != null) {
                pDAL.removeProductCart((String) session.getAttribute("user"), rmpid);
                session.setAttribute("hashCart", null);
                response.sendRedirect("cart");
            }
            session.setAttribute("listCart", listCart);
        } catch (Exception e) {
            request.getRequestDispatcher("cart.jsp").include(request, response);
        }

        request.getRequestDispatcher("cart.jsp").include(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String pid = request.getParameter("pid");
        HttpSession session = request.getSession();
        List<Product> listCart = (List<Product>) session.getAttribute("listCart");
        for (Product p : listCart) {
            if (p.getPid().equals(pid)) {
                listCart.remove(p);
            }
        }
        session.setAttribute("listCart", listCart);
    }

}
