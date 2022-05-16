<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>single file name</h1>
<form action="${pageContext.request.contextPath}/quick/user22" method="post" enctype="multipart/form-data">
    name<input type="text" name="username"><br>
    file<input type="file" name="uploadFile"><br>
    file2<input type="file" name="uploadFile2"><br>
    <input type="submit" value="submit">
</form>

<h1>several file name</h1>
<form action="${pageContext.request.contextPath}/quick/user23" method="post" enctype="multipart/form-data">
    name<input type="text" name="username"><br>
    file<input type="file" name="uploadFile"><br>
    file2<input type="file" name="uploadFile"><br>
    <input type="submit" value="submit">
</form>


</body>
</html>
