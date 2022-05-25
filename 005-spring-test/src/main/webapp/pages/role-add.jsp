<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/">home</a></h1>

<h2> role add </h2>
<div>
    <form action="${pageContext.request.contextPath}/role/add" , method="post">
        role name <input type="text" name="roleName"><br>
        role description <input type="text" name="roleDesc"><br>
        <input type="submit" value="submit">
    </form>
</div>


</body>
</html>
