<%@ page import="org.example.bo.Facade" %>
<%@ page import="org.example.bo.Item" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Item> basket = Facade.getBasket();
%>

<!DOCTYPE html>
<html>

<head>
    <title>Basket - BV Web-Shop</title>
</head>

<body>

    <h1 style="text-align: center;">
        Basket
    </h1>


    <div style="text-align: center;">

        <%
            if (basket.isEmpty()) {
        %>

            <p>Your basket is empty.</p>

        <%
            } else {

                for (Item item : basket) {
        %>

                    <div style="margin-bottom: 10px;">
                        <%= item.getName() %>: <%= item.getPrice() %> kr
                    </div>

        <%
                }
            }
        %>

    </div>


    <div style="text-align: center; margin-top: 30px;">

        <form action="home.jsp" method="get">

            <button type="submit"
                    style="width: 100px; height: 40px;">
                Back
            </button>

        </form>

    </div>

</body>

</html>