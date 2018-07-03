<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="my" uri="http://geoorg.com" %>

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

<my:ifTag test="${2 < 3}">
    body of ifTag test = 2 < 3
</my:ifTag>
<br/>
<my:ifTag test="${3 > 6}">
    body of ifTag test = 3 > 6
</my:ifTag>
</body>
</html>
