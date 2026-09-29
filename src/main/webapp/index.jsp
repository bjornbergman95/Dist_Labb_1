<!DOCTYPE html>
<html>
    <head>
        <title>BV Web-Shop</title>
    </head>
    <body>
        <h1 style="text-align: center;"> BV Web-Shop</h1>
        <!-- <div style="position: absolute; right: 10%">
            <button style="width: 100px; height: 100px;">
                kundkorg
            </button>
        </div> -->
        <p style="text-align: center;">Welcome, Please Log In</p>
        <form action="LoginServlet" method="post" style="text-align: center;">
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