<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.bo.Item" %>
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
        Facade.addToBasket(id, user);
    }

    ArrayList<Item> items = Facade.getAllItems();
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
                <a href="basket.jsp">Shopping Cart</a>
                <a href="logout.jsp">Logout</a>
            </div>

        </nav>
    <p style="text-align: center;">
        Welcome <%= user.getUsername() %>!
    </p>

    <div class="product-grid">

        <%
            for (Item item : items) {
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
                        Add to basket
                    </button>

                </form>

            </div>

        <%
            }
        %>

    </div>

</body>
</html>