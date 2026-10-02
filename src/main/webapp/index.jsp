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
    <body>
        <h1 style="text-align: center;"> BV Web-Shop </h1>

        <p style="text-align: center;">Welcome, Please Log In</p>

        <form action="index.jsp" method="post" style="text-align: center;">
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