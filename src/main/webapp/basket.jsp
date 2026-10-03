<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.bo.Item" %>
<%@ page import="org.example.bo.User" %>
<%@ page import="java.util.ArrayList" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    ArrayList<Item> basket = Facade.getBasket(user);
%>

<!DOCTYPE html>
<html>

<head>
    <title>Basket - BV Web-Shop</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <nav class="navbar">

        <div class="logo">
            BV Web-Shop
        </div>

        <div class="nav-links">
            <a href="basket.jsp">Shopping Cart</a>
            <a href="logout.jsp">Logout</a>
        </div>

    </nav>

    <h1 class="basket-title">
        Shopping Cart
    </h1>

    <div class="basket-container">

        <%
            if (basket.isEmpty()) {
        %>

            <p class="empty-basket">
                Your basket is empty.
            </p>

        <%
            } else {

                for (Item item : basket) {
        %>

            <div class="basket-item">

                <div>
                    <h2><%= item.getName() %></h2>
                    <p><%= item.getPrice() %> kr</p>
                </div>

            </div>

        <%
                }
            }
        %>

    </div>

    <div class="back-button">

        <form action="home.jsp" method="get">
            <button type="submit">
                Back to shop
            </button>
        </form>

    </div>

</body>

</html>