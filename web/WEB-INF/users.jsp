<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <form method="POST" action="users">
            <h1>Add User</h1>
            <label>Email address</label>
            <input type="email" name="email"><br>
            <label>First name</label>
            <input type="text" name="fname"><br>
            <label>Last name</label>
            <input type="text" name="lname"><br>
            <label>Password</label>
            <input type="text" name="password"><br>
            <select name="roleID">
                <option value="1">system admin</option>
                <option value="2">regular user</option>
                <option value="3">company admin</option>
            </select>
            <label>Add</label>
            <input type="submit" value="add">
        </form>
        <form method="POST" action="users">
            <h1>Manage Users</h1>
            <input type="email" name="email3">
            <label>Delete</label>
            <input type="submit" value="delete">
        </form>
        <form method="POST" action="users">
            <h1>Edit User</h1>
            <label>Email address</label>
            <input type="email" name="email2"><br>
            <label>First name</label>
            <input type="text" name="fname2"><br>
            <label>Last name</label>
            <input type="text" name="lname2"><br>
            <label>Password</label>
            <input type="text" name="password2"><br>
            <select name="roleID2">
                <option value="1">system admin</option>
                <option value="2">regular user</option>
                <option value="3">company admin</option>
            </select>
            <label>Edit</label>
            <input type="submit" value="save">
        </form>
        <table>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Role</th>
            </tr>
            <br>
            <br>
            <c:forEach items="${userlist}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.role.roleName}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
