<%-- 
    Document   : login
    Created on : Jun 22, 2015, 11:31:46 PM
    Author     : Tsvetelin
--%>
<jsp:include page="logRegHeader.jsp" />
<section class="login">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="logo">My Diabetizer</div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-4 col-md-offset-4">
                <h4 class="text-center">Sign in to your account</h4>
                <form action="login" method="post">
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" id="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary clear">Sign in</button>   
                </form>
                <div class="margin-top-20">
                    <a href="/forgottenPassword.jsp">Forgot your password?</a>
                    <a href="/register.jsp" class="pull-right">Create account</a>
                </div> 
            </div>
        </div>
    </div>
</section>    
<jsp:include page="footer.jsp" />