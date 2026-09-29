<%@ page import="org.example.bo.Facade" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null) {

        Facade facade = new Facade();

        boolean success = Facade.logIn(username, password);

        if (success) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            out.println("Wrong password or username");
        }
    }
%>

<!DOCTYPE html>
<html>
    <body>
        <h1 style="text-align: center;"> BV Web-Shop</h1>

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