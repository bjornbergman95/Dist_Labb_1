<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.ui.UserDTO" %>
<%@ page import="org.example.ui.CartDTO" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null) {

        UserDTO user = Facade.logIn(username, password);

        if (user != null && user.getRole().equals("user")) {
            session.setAttribute("user", user);
            session.setAttribute("cart", new CartDTO());

            response.sendRedirect("home.jsp");
            return;
        } else {
            session.setAttribute("user", user);

            response.sendRedirect("home.jsp");
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Login - BV Web-shop</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <nav class="navbar">
        <div class="logo">BV Web-Shop</div>

        <div class="nav-links">
            <a href="cart.jsp">Shopping Cart</a>
        </div>
    </nav>

    <h1 style="text-align: center;">Login</h1>

    <p style="text-align: center;">
        Please Log In
    </p>

    <form action="login.jsp" method="post" style="text-align: center;">

        <label for="username">Username:</label>
        <br><br>
        <input type="text" id="username" name="username">

        <br><br>

        <label for="password">Password:</label>
        <br><br>
        <input type="password" id="password" name="password">

        <br><br>

        <button type="submit">Log In</button>

    </form>

</body>
</html>