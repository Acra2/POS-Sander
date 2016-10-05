<%--
  Created by IntelliJ IDEA.
  User: Sander
  Date: 22-9-2016
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="j_security_check">
    <input type="text" name="j_username"/>
    <input type="password" name="j_password"/>
    <button type="submit">Login</button>
</form>
</body>
</html>
