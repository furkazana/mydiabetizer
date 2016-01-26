<%-- 
    Document   : MyPage
    Created on : 26-Jan-2016, 11:54:33
    Author     : Rock n Roll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
            String sirname = request.getAttribute("SIRNAME").toString();
        %>
        <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 margin-top-20">
                        <a href="/" class="logo"> <%=sirname %> </a>
                        <a class="btn btn-primary pull-right" href="./pyramid.jsp">Diabetic Pyramid</a>
                        <a class="btn btn-primary pull-right margin-right-10"  href="./register.jsp">Sign up</a>
                    </div>
                </div>
            </div>
    </body>
</html>
