<%-- 
    Document   : home
    Created on : Oct 22, 2023, 2:18:59 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
            background-image: url('/prj302/assets/theme.hstatic.net/home.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .image-frame {
            border: 2px solid #fff; /* Màu và độ rộng của khung */
            border-radius: 10px; /* Bo tròn góc khung */
        }
        a {
            display: block;
            background-color: rgba(0, 0, 0, 0.5);
            color: #fff;
            padding: 15px 30px;
            text-align: center;
            text-decoration: none;
            font-size: 20px;
            border-radius: 5px;
        }
        a:hover {
            background-color: #e2e2cfc0;
        }
    </style>
    </head>
    <body>
        <div class="image-frame">
        <a href="/prj302/product">Khám phá</a>
    </div>
    </body>
</html>
