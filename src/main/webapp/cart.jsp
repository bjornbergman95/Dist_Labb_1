<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.bo.Cart" %>
<%@ page import="org.example.ui.ItemDTO" %>
<%@ page import="org.example.ui.UserDTO" %>
<%@ page import="org.example.ui.CartDTO" %>

<%
    UserDTO user = (UserDTO) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    Cart cart = (Cart) session.getAttribute("cart");

    CartDTO cartDTO = Facade.getCart(cart);
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
            if (cartDTO.getItems().isEmpty()) {
        %>

            <p class="empty-cart">
                Your shopping cart is empty.
            </p>

        <%
            } else {
                for (ItemDTO item : cartDTO.getItems()) {
        %>

            <div class="cart-item">
                <p>
                    <%= item.getName() %>
                    <%= item.getPrice() %> kr
                </p>
            </div>

        <%
                }
            }
        %>

    </div>

    <h2 style="text-align: center;">
        Total: <%= cartDTO.getTotalPrice() %> kr
    </h2>

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