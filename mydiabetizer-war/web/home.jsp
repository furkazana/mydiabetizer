<%-- 
    Document   : MyPage
    Created on : 26-Jan-2016, 11:54:33
    Author     : Rock n Roll
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
<jsp:include page="header.jsp" />
Home
<jsp:include page="footer.jsp" />
