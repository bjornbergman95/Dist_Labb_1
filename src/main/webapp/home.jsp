<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.ui.ItemDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.bo.User" %>

<%
    User user = (User) session.getAttribute("user");

    if(user == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    String itemId = request.getParameter("itemId");

    if (itemId != null) {
        int id = Integer.parseInt(itemId);
        Facade.addToCart(id, user);
    }

    ArrayList<ItemDTO> items = Facade.getAllItems();
%>

<!DOCTYPE html>
<html>

<head>
    <title>BV Web-Shop</title>
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
    <h2 style="text-align: center;">
        Welcome <%= user.getUsername() %>!
    </h2>

    <div class="product-grid">

        <%
            for (ItemDTO item : items) {
        %>

            <div class="product-card">

                <h2><%= item.getName() %></h2>

                <p class="price">
                    <%= item.getPrice() %> kr
                </p>

                <form method="post" action="home.jsp">

                    <input
                        type="hidden"
                        name="itemId"
                        value="<%= item.getId() %>"
                    >

                    <button type="submit">
                        Add to shopping cart
                    </button>

                    <p><%= item.getStock() %> in stock </p>

                </form>

            </div>

        <%
            }
        %>

    </div>

</body>
</html>