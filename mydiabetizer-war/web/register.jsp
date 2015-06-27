<%-- 
    Document   : register
    Created on : Jun 22, 2015, 11:31:54 PM
    Author     : Tsvetelin
--%>
<jsp:include page="logRegHeader.jsp" />
<section class="register">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="logo">My Diabetizer</div>
                <h4>Sign up and start using MyDiabetizer today.</h4>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-4 col-md-offset-4">
                <form action="" method="post">
                    <div class="form-group">
                        <input type="firstName" name="firstName" class="form-control" id="firstName" placeholder="First name">
                    </div>
                    <div class="form-group">
                        <input type="lastName" name="lastName" class="form-control" id="lastName" placeholder="Last name">
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
                    <button type="submit" class="btn btn-primary">Sign up</button>
                </form>
            </div>
        </div>
    </div>
</section>    
<jsp:include page="footer.jsp" />
