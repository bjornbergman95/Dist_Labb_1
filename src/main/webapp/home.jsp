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
    </body>
</html>