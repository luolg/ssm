<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/">home</a></h1>

<h2> add user </h2>
<div>
    <form action="${pageContext.request.contextPath}/user/add" method="post">
        username <input type="text" name="username"><br>
        email <input type="text" name="email"><br>
        password <input type="text" name="password"><br>
        phoneNum <input type="text" name="phoneNum"><br>
        <ol>
            <c:forEach items="${roleList}" var="role">
                <input type="checkbox" name="roleIds" value="${role.id}"> ${role.roleName}
                <br>
            </c:forEach>
        </ol>
        <input type="submit" value="submit">

    </form>
</div>


</body>
</html>
