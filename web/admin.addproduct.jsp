<%-- 
    Document   : admin.addproduct
    Created on : Oct 29, 2023, 10:26:00 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <style>
            body {
                background-image: url('/prj302/assets/theme.hstatic.net/form.jpg');
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
                padding: 20px 20px 0px 20px;
                background-color: #ffffff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                color: #333333;
            }

            input[type="text"],
            input[type="number"],
            input[type="date"],
            select {
                width: 100%;
                padding: 4px;
                margin: 1px 0;
                box-sizing: border-box;
            }

            label {
                display: inline-block;
                margin-bottom: 8px;
                color: #555555;
                width: 100px; /* Điều chỉnh chiều rộng của label */
                text-align: right;
            }

            table {
                width: 100%;
                margin-top: 5px;
            }

            td {
                padding: 5px;
                text-align: center;
            }

            input[type="submit"] {
                background-color: #4caf50;
                color: white;
                padding: 8px 20px;
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
                padding: 11px 15px;
                margin: 10px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .line2 {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div id="login-container" >
            <h2>Product information</h2>
            <form action="adminaddproduct" method="post">
                TypeProduct:<select name="typeproduct"><br>
                    <option value="1">Đồng hồ Tevise</option>
                    <option value="2">Đồng hồ nam Skmei</option>
                    <option value="3">Đồng hồ nam Halei</option>
                    <option value="4">Đồng hồ Baishuns</option>
                    <option value="5">Đồng hồ LongBo</option>
                    <option value="6">Đồng hồ Curren</option>
                    <option value="7">Đồng hồ Beesister</option>
                    <option value="8">Đồng hồ nữ Skmei</option>
                    <option value="9">Đồng hồ nữ Halei</option>
                </select>
                Name:<input type="text" name="name" placeholder="Enter name" required><br>
                Describe:<input type="text" name="describe" placeholder="Enter describe" required><br>
                Price:<input type="number" min="100000" step="5000"  name="price" placeholder="Enter price" required><br>
                Dispercent:<input type="number" min="0" step="1"  max="100" name="dispercent" placeholder="Enter discount percent" required><br>
                Status:<select name="status" placeholder="Enter status" required><br>
                    <option value="Mới">Mới</option>
                    <option value="Cũ">Cũ</option>
                </select>
                Source:<select name="source" placeholder="Enter source" required><br>
                    <option value="Công ty">Công ty</option>
                    <option value="Đặc biệt">Đặc biệt</option>
                </select>
                Guarantee:<input type="number" min="1" max="12" name="guarantee" placeholder="Enter quarantee" required><br>
                Shell:<input type="text" name="shell" placeholder="Enter shell" required><br>
                Glasses:<input type="text" name="glasses" placeholder="Enter glasses" required><br>
                Energy:<input type="text" name="energy" placeholder="Enter Energy" required><br>
                Waterproof:<input type="text" name="waterproof" placeholder="Enter waterproof" required><br>
                <label>Link image:</label><br>
                <input type="text" name="link1" placeholder="Enter link"><br>
                <input type="text" name="link2" placeholder="Enter link"><br>
                <div style="color: red"> ${ms}</div>
                <table>
                    <tr>
                        <td id="dha" class="back"><a href="adminproduct" class="line1">Back</a></td>
                        <td id="dha"><input type="submit" value="Add"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
