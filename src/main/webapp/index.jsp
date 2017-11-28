<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>WebApp</title>
</head>
<body>
<form method="post" action="servlet">
    <input type="text" name="param1" required>
    <input type="submit" value="Submit">
</form>

<table>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value = "${item}"/><p></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>