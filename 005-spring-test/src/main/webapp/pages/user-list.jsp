<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/">home</a></h1>

<h2> User list</h2>

<table>
    <tr>
        <th>userid</th>
        <th>username</th>
        <th>email</th>
        <th>password</th>
        <th>phone number</th>
        <th>roles</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.phoneNum}</td>
            <td>
                <ul>
                    <c:forEach items="${user.roleList}" var="role">
                        <li>${role}</li>
                    </c:forEach>

                </ul>

            </td>
            <td>
               <a href="javascript:void(0);" onclick="delUser('${user.id}')" >delete user</a>
            </td>
        </tr>
    </c:forEach>

</table>
<script>
    function delUser(userId){
        if (confirm("are you going to delete it?")){
           location.href="${pageContext.request.contextPath}/user/delete/"+userId;
        }
    }
</script>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<%--<ul>--%>
<%--    <c:forEach items="${userList}" var="user">--%>
<%--        <li>${user}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

</body>
</html>
