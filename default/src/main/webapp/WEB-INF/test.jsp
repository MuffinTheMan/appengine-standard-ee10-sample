<%@ page import="java.util.logging.Logger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if ("true".equals(request.getParameter("fail"))) {
        Logger.getLogger("test.jsp").severe("About to fail.");
        throw new RuntimeException("fail");
    }
%>
<html>
<head>
    <title>Test JSP</title>
</head>
<body>
<p>Test JSP</p>
</body>
</html>
