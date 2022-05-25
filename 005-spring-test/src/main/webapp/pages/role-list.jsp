<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="${pageContext.request.contextPath}/">home</a></h1>

<h2>role list</h2>



<ul>
    <c:forEach items="${roleList}" var="role">
        <li>${role}</li>
    </c:forEach>
</ul>

</body>
</html>
