/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class PayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        ProductDAO pDAL = new ProductDAO();
        List<Product> listPay = new ArrayList<>();
        listPay = (List<Product>) session.getAttribute("listCart");
        pDAL.removeAllCart((String) session.getAttribute("user"));
        session.setAttribute("listCart", null);
        for (Product p : listPay) {
            pDAL.addToBill((String) session.getAttribute("user"), p.getPid(), p.getQuantity(), p.getTotal());
        }
        response.sendRedirect("history");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

    }

}
