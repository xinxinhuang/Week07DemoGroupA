<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <br>
        <br>
        <h2>Users</h2>
        <br>
        <table>
            <tr>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Email</td>
                <td>Password</td>
                <td>SIN</td>
                <td>Delete</td>
                <td>Edit</td>
            </tr>
            <form action="users" method="POST">
                <c:forEach items="${users}" var="users">             
                    <tr>                 
                        <td>${users.firstname}</td>
                        <td>${users.lastname}</td>
                        <td>${users.email}</td>
                        <td>${users.password}</td>
                        <td>${users.sin}</td>
                        <td>input type="submit" value="Delete"></td>
                        <td>input type="submit" value="Edit"></td>
                        
                    </tr>            
                </c:forEach>
            </form>
        </table>
        <br>
        <h3>Add User</h3>
         <form action="users" method="POST">
                First Name: <input type="text" name="firstname" value="${firstname}" ><br>
                 Last Name: <input type="text" name="lastname" value="${lastname}" ><br>
                  Email: <input type="text" name="email" value="${email}" ><br>
               Password: <input type="password" name="password" value="${password}" ><br>
               SIN: <input type="text" name="sin" value="${sin}" ><br>
                <input type="submit" value="Save">
            </form>
                ${message}
    </body>
</html>
