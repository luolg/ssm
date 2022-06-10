<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>add account info</h2>
<div>
    <form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
        <span>
            account name: <input type="text" name="name">
        </span>
        <span>
            account money: <input type="text" name="money">
        </span>
        <span>
            <input type="submit" value="save">
        </span>
    </form>

</div>

</body>
</html>
