<%--
  Created by IntelliJ IDEA.
  User: luolg
  Date: 2022/5/28
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
<h1>Login page</h1>
<br>
<div>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <table>
            <thead>
            <tr>
                <th>
                    Login System
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <input type="text" placeholder="input your username" name="username"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="password" placeholder="input your password" name="password">
                </td>
            </tr>
            </tbody>
        </table>
        <br>
        <input type="submit" value="submit">
    </form>
</div>

</body>
</html>
