<%-- 
    Document   : back
    Created on : Feb 1, 2017, 12:18:07 AM
    Author     : mghasemy
--%>

<%@page import="soap.SOAPClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
        soap.SOAPClient mnm=new SOAPClient();
        String token=request.getParameter("Token");
        String refid=request.getParameter("Token");
        String metchentid="B6A3";
        String verify=mnm.verify(token,refid);
            %>
    </head>
    <body>
        <h1>Back page!</h1>
        <%=verify%>
    </body>
</html>
