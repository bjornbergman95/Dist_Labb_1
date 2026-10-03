<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.bo.User" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    User user = Facade.logIn(username, password);

    if (user != null) {
        session.setAttribute("user", user);
        response.sendRedirect("home.jsp");
        return;
    }

%>

<!DOCTYPE html>
<html>
<head>
    <title>BV Web-shop</title>
    <link rel="stylesheet" href="style.css">
</head>
    <body>
        <nav class="navbar">
            <div class="logo">BV Web-Shop</div>

            <div class="nav-links">
                <a href="basket.jsp">Shopping Cart</a>
                <a href="login.jsp">Login</a>
            </div>
        </nav>
    <h1 style="text-align: center;">
        Please login in order to see available products
    </h1>
    </body>
</html>