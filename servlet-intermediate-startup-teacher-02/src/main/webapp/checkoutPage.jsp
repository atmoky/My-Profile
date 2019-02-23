<%@ page language="java" contentType="text/html; charset=US-ASCII"  pageEncoding="US-ASCII"%>

<%
    if (session.getAttribute ("user") == null){

        response.sendRedirect ("login.html");
    }

    String userName = null;
    Cookie[] cookies = request.getCookies();

    if(cookies !=null){
        for(Cookie cookie : cookies){
            if (cookie.getName ().equals ("user")) userName = cookie.getValue ();
        }
    }
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>

    <h3>Welcome <%=userName %>, to the real world...</h3>
    <br>
    <form action="logout" method="post">
        <input type="submit" value="Logout" >
    </form>

</body>
</html>