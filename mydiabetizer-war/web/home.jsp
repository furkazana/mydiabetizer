<%-- 
    Document   : MyPage
    Created on : 26-Jan-2016, 11:54:33
    Author     : Rock n Roll
--%>
<%
//allow access only if session exists.
    String user = null;
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/register.jsp");

    } else {
        user = (String) session.getAttribute("user");
    }
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                userName = cookie.getValue();
            }
            if (cookie.getName().equals("JSESSIONID")) {
                sessionID = cookie.getValue();
            }
        }
    }
%>
<jsp:include page="header.jsp" />
<div class="col-xs-12 col-sm-12 col-md-12 margin-top-100" >
    <h3 class="main-text-color">Daily organizer</h3>
    <div class="col-xs-12 col-sm-12 col-md-7 margin-top-20">
        <form class="form-inline" action="diaryHandler" method="post">
            <div class="form-group col-md-12">
                <div class="pull-left">
                    <label class="control-label main-text-color do-label first-label">Out of bed</label>
                    <div class="narrow">
                        <label class="control-label main-text-color margin-left-10">SL</label>
                        <input type="text" class="form-control first-input" name="oobSL">
                    </div>
                    <div class="narrow">
                        <label class="control-label main-text-color margin-left-10">Ins</label>
                        <input type="text" class="form-control second-input" name="oobINS">
                    </div>
                    <div class="wide">
                        <label class="control-label main-text-color margin-left-10">Notes</label>
                        <input type="text" class="form-control third-input" name="oobNotes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">BB</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="bbSL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="bbINS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="bbNotes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">B+2</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="b2SL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="b2INS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="b2Notes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">BL</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="blSL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="blINS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="blNotes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">L+2</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="l2SL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="l2INS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="l2Notes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">BD</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="bdSL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="bdINS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="bdNotes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">D+2</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="d2SL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="d2INS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="d2Notes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">BBed</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="bbedSL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="bbedINS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="bbedNotes">
                    </div>
                </div>
                <div class="pull-left">
                    <label class="control-label main-text-color do-label">Random</label>
                    <div class="narrow">
                        <input type="text" class="form-control first-input" name="rSL">
                    </div>
                    <div class="narrow">
                        <input type="text" class="form-control second-input" name="rINS">
                    </div>
                    <div class="wide">
                        <input type="text" class="form-control third-input" name="rNotes">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-transparent pull-right margin-top-20">Save</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp" />
