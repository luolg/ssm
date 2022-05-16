<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/quick/user14" method="post">
    <%--    explain the number of each User object about username & age--%>
    <input type="text" name="userList[0].username"><br>
    <input type="text" name="userList[0].age"><br>
    <input type="text" name="userList[1].username"><br>
    <input type="text" name="userList[1].age"><br>
    <input type="submit" value="submit">
</form>

</body>
</html>
