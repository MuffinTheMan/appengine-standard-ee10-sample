<%@ page import="java.util.logging.Logger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Logger.getLogger("redirect-test.jsp").info("About to redirect to /jsp.");
    response.sendRedirect("/jsp");
%>