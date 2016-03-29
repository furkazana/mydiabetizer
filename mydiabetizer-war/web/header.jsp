<%-- 
    Document   : header
    Created on : Jun 22, 2015, 11:20:10 PM
    Author     : Tsvetelin
--%>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null)
{
    response.sendRedirect(request.getContextPath() + "/register.jsp");
    
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Diabetes Organizer</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" href="./css/style.css" />
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <section class="header white-background">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 margin-top-20">
                        <span class="logo main-text-color">My Diabetizer</span>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9 margin-top-20">
                        <ul class="main-menu">
                            <li><a href="./account.jsp">My account</a></li>
                            <li><a href="./home.jsp">Diary</a></li>
                            <li><a href="./calculator">Calculator</button></a></li>
                            <li><a href="./graphs.jsp">Graphs</button></a></li>
                            <a style="margin-top: -5px;" href="./logout" class="btn btn-primary btn-transparent pull-right">Log Out</a>            
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <section class="content">
            <div class="container">
                <div class="row">