<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 23.11.2017
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <%@ page isELIgnored="false" %>
</head>
<body>
<p>Users:</p>
<table border="1">
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value = "${item.getId()}"/></td>
            <td><c:out value = "${item.getLogin()}"/></td>
            <td><c:out value = "${item.getPassword()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
