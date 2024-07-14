<%-- 
    Document   : register
    Created on : Oct 20, 2023, 12:11:02 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="/prj302/assets/hstatic.net/design/css/bootstrap.3.3.1.css">
        <link href='/prj302/assets/hstatic.net/design/plugins/font-awesome/4.6.3/css/font-awesome.min.css'
              rel='stylesheet' type='text/css' media='all' />
        <link href='/prj302/assets/theme.hstatic.net/styles.css?v=90' rel='stylesheet'
              type='text/css' media='all' />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Creat Account Page</title>
        <style>
            body {
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
                margin: 0;
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                text-align: center;
            }

            #login-container {
                width: 400px;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                color: #333333;
            }

            label {
                display: block;
                margin-bottom: 8px;
                color: #555555;
            }

            input[type="text"],
            input[type="password"],
            select {
                width: 100%;
                padding: 10px;
                margin: 8px 0;
                box-sizing: border-box;
            }

            table {
                width: 100%;
                margin-top: 15px;
            }

            td {
                padding: 5px;
                text-align: center;
            }

            input[type="submit"] {
                background-color: #4caf50;
                color: white;
                padding: 12px 20px;
                margin: 10px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            p {
                margin-top: 20px;
                color: #555555;
            }

            .forget {
                margin-top: 20px;
                padding-left: 100px;
            }

            .forget a{
                font-size: 15px;
            }
            .line1 {
                text-decoration: none;
                background-color: #4caf50;
                color: white;
                padding: 12px 20px;
                margin: 10px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>

        <div id="login-container">
            <h2>Change Information</h2>

            <form action="changeinfoclient" method="post">
                <div style="color: red"> ${mes}</div>
                <table>
                    <tr>
                        <td><label for="password">Password:</label></td>
                        <td><input type="text" id="password" name="uppass" placeholder="New password" ></td>
                    </tr>
                    <tr>
                        <td><label for="password">Realname:</label></td>
                        <td><input type="text" id="password" name="upname" placeholder="New realname" ></td>
                    </tr>
                    <tr>
                        <td><label for="password">Phone:</label></td>
                        <td><input type="text" id="password" name="upphone" placeholder="New phone" ></td>
                    </tr>
                    <tr>
                        <td><label for="password">Email:</label></td>
                        <td><input type="text" id="password" name="upemail" placeholder="New email" ></td>
                    </tr>
                    <tr>
                        <td><label for="password">Address:</label></td>
                        <td><input type="text" id="password" name="upadd" placeholder="New address" ></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td id="dha"><a href="thongtintaikhoan.jsp" class="line1">Back</a></td>
                        <td id="dha"><input type="submit" value="Change"/></td>       
                    </tr>
                </table>
            </form>

        </div>

    </body>
</html>