<%-- 
    Document   : index
    Created on : Feb 1, 2017, 12:14:02 AM
    Author     : mghasemy
--%>

<%@page import="soap.SOAPClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
        soap.SOAPClient mnm=new SOAPClient();
        String token=mnm.getToket("2060", "123123", "123123");
            %>
            <form method="post" action="https://ikc.shaparak.ir/TPayment/Payment/index">
            <input  value="<%=token%>" name="Token"/>
            <input  value="B6A3" name="MerchantId"/>
            <button type="submit" value="Buy">Buy</button>
        </form>
    </body>
</html>
