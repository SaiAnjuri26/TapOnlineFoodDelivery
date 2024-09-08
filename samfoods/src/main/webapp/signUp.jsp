<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
    <link rel="stylesheet" href="signup.css">
</head>
<body>
    <div class="signup-container">
    <div class="logo-header">
        <h1>Sam Foods</h1>
        <img src="<%= request.getContextPath() %>/SamFoodImages/signup.jpeg" alt="Signup Logo">
    </div>
    
        <form action="register">
            <table>
                <tr>
                	<td><label for="username">UserName</label></td>
                	<td><input type="text" id="username" name="username" required></td>
           	   </tr>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="text" id="email" name="email" required></td>
                </tr>
                <tr>
                    <td><label for="phonenumber">Phonenumber</label></td>
                    <td><input type="text" id="phonenumber" name="phonenumber" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password</label></td>
                    <td><input type="password" id="password" name="password" required></td>
                </tr>
                <tr>
                    <td><label for="address">Address</label></td>
                    <td><input type="text" id="address" name="address" required></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
