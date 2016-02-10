<%-- 
    Document   : register
    Created on : Jun 22, 2015, 11:31:54 PM
    Author     : Tsvetelin
--%>
<jsp:include page="index-header.jsp" />

<%
   String firstName=request.getParameter("firstName");
%>


<section class="register">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h4 class="white-text">Sign up and start using MyDiabetizer today.</h4>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-4 col-md-offset-4">
                <form action="signup" method="post">
                    <div class="form-group">
                     <%--   <div class="form-error"<% if(!error.getFirstNameError.equals(NULL)){error.get} %>></div>
                        <input type="firstName" name="firstName" class="form-control" id="firstName" placeholder="First name" value="<%if(!firstName.equals(null){firstName}%>">
                     --%>
                    </div>
                    <div class="form-group">
                        <input type="text" name="name" class="form-control" id="name" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" id="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <input type="password" name="passwordRetyped" class="form-control" id="password" placeholder="Retype password">
                    </div>
                    <span><a class="white-text" href="./login.jsp">Already have an account?</a></span>
                    <button type="submit" class="btn btn-primary btn-transparent pull-right">Sign up</button>
                </form>
            </div>
        </div>
    </div>
</section>    
<jsp:include page="index-footer.jsp" />
