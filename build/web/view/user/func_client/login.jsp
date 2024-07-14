<%-- 
    Document   : login
    Created on : Oct 19, 2023, 11:50:16 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
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
    </style>
</head>
<body>

    <div id="login-container">
        <h2>Login</h2>

        <form action="loginclient" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter username" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter password" required><br>

            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option name="role" value="lecture">Lecture</option>
                <option name="role" value="student">Student</option>
            </select><br>

            <table>
                <tr>
                    <td id="dha"><input type="submit" value="Login"/></td>
                    <td id="dha"><a href="register.jsp"><input type="submit" value="Register"/></a></td>
                </tr>
            </table>
            <div class="forget">
		<a href="forget.jsp">Forget your password ?</a>
            </div>
        </form>
    </div>

</body>
</html>
