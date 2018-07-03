<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Another jsp</title>
</head>
<body>
Hello from another.jsp<br>
some_attr from servlet is
${some_attr}
<jsp:include page="links.jsp"/>
</body>
</html>
