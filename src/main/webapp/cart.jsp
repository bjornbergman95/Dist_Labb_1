<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.ui.ItemDTO" %>
<%@ page import="org.example.bo.User" %>
<%@ page import="java.util.ArrayList" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    ArrayList<ItemDTO> cart = Facade.getCart(user);
%>

<%
    int total = Facade.getTotalPrice(user);
%>

<!DOCTYPE html>
<html>

<head>
    <title>Cart - BV Web-Shop</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <nav class="navbar">

        <div class="logo">
            BV Web-Shop
        </div>

        <div class="nav-links">
            <a href="cart.jsp">Shopping Cart</a>
            <a href="logout.jsp">Logout</a>
        </div>

    </nav>

    <h1 class="cart-title">
        Shopping Cart
    </h1>

    <div class="cart-container">

        <%
            if (cart.isEmpty()) {
        %>

            <p class="empty-cart">
                Your shopping cart is empty.
            </p>

        <%
            } else {

                for (ItemDTO item : cart) {
        %>

            <div class="cart-item">

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

    <h2 style="text-align: center;">Total: <%= total %> kr</h2>

    <div class="back-button">
        <form action="home.jsp" method="get">
            <button type="submit">
                Back to shop
            </button>
        </form>
    </div>

    <div class="back-button">
        <button type="button">
            Cash Out
        </button>
    </div>

</body>

</html>