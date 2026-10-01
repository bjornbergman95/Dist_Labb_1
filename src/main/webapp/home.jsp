<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.bo.Item" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Item> items = Facade.getAllItems();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>BV Web-Shop</title>
    </head>
    <body>
        <h1 style="text-align: center;"> BV Web-Shop</h1>
        <p style="text-align: center;">Welcome <%= request.getAttribute("username") %>!</p>
        <div style="position: absolute; right: 10%">
            <button style="width: 100px; height: 100px;">
                Basket
            </button>
        </div>
        <%
            for (Item item : items) {
                %>
                    <div>
                        <p>Namn: <%= item.getName() %></p>
                        <p>Pris: <%= item.getPrice() %> kr</p>
                    </div>
                <%
            }
        %>
    </body>
</html>