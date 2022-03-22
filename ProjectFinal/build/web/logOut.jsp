<%-- 
    Document   : newjsp
    Created on : Feb 22, 2022, 12:22:57 AM
    Author     : 84337
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("home");
%>
