<%@ taglib prefix="jso" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <h1><a href="${pageContext.request.contextPath}/">home</a></h1>

    <h2>hello my man</h2>

    <a href="${pageContext.request.contextPath}/user/list">list user</a>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/role/list">list roles</a>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/user/add">add user</a>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/role/add">add role</a>


</div>
</body>
</html>
