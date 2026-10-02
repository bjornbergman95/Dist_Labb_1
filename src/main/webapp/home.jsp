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
</head>

<body>

    <h1 style="text-align: center;">
        BV Web-Shop
    </h1>
    <p style="text-align: center;">
        Welcome <%= user.getUsername() %>!
    </p>
    <div style="position: absolute; right: 10%;">
        <form action="basket.jsp" method="get">
            <button type="submit" style="width: 100px; height: 100px;">
                Basket
            </button>
        </form>
    </div>


    <%
        for (Item item : items) {
    %>

        <div style="text-align: center; margin-bottom: 10px;">

            <span>
                <%= item.getName() %>: <%= item.getPrice() %> kr
            </span>

            <form method="post" action="home.jsp" style="display: inline;">

                <input
                    type="hidden"
                    name="itemId"
                    value="<%= item.getId() %>"
                >

                <button
                    type="submit"
                    style="width: 100px; height: 20px;"
                >
                    Add to basket
                </button>

            </form>

        </div>

    <%
        }
    %>

</body>
</html>