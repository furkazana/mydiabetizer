<%-- 
    Document   : header
    Created on : Jun 22, 2015, 11:20:10 PM
    Author     : Tsvetelin
--%>
<%
//allow access only if session exists
   

  
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script>
            // TODO CHANGE HARCODED USER ID!!!
            $(document).ready(function() {
                $.ajax({
                type: "GET",
                    url: "/mydiabetizer-war/UpdateHandler",
                    data: JSON.stringify({"userId": 2}),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                        console.log(data.result);
                        if(data.result == 0) {
                            $(".update-ratios").addClass("green-transparent-button");
                        } else if(data.result == 1) {
                            $(".update-ratios").addClass("orange-transparent-button");
                        } else if(data.result == 2) {
                            $(".update-ratios").addClass("red-transparent-button");
                        }
                    }
                });
                
                $(".update-ratios").on("click", function(event) {
                    event.preventDefault();
                    var _this = $(this);
                    $.ajax({
                        type: "POST",
                        url: "/mydiabetizer-war/UpdateHandler",
                        data: JSON.stringify({"userId": 2}),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (data) {
                            var regex = /^(\w)*-transparent-button$/;
                            var classes = $(this).attr("class");
                            _this.removeClass();
                           _this.addClass("update-ratios btn btn-primary btn-transparent pull-right green-transparent-button");
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <section class="header white-background">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 margin-top-20">
                        <span class="logo main-text-color">My Diabetiser</span>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-9 margin-top-20">
                        <ul class="main-menu">
                            <li><a href="./account">My account</a></li>
                            <li><a href="./home.jsp">Diary</a></li>
                            <li><a href="./calculator">Calculator</button></a></li>
                            <li><a href="./graphs">Graphs</button></a></li>
                            <li><a href="./reports.jsp">Reports</button></a></li>
                            <a style="margin-top: -5px;" href="./logout" class="btn btn-primary btn-transparent pull-right">Log Out</a>
                            <a style="margin-top: -5px; margin-right: 20px;" href="" class="update-ratios btn btn-primary btn-transparent pull-right">Update ratios</a>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <section class="content">
            <div class="container">
                <div class="row">
