<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Access denied</title>


</head>
<body>
Welcome to Spring MVC! exception page


    <div class="container">

      <div class="starter-template">
        <h1>Access is denied</h1>
        
      </div>

    </div>
    
<footer class="footer">
      <div class="container">
        <p class="text-muted">Java Spring new project.</p>
        <a href="<%=request.getContextPath() %>?language=en">EN</a>
        <a href="<%=request.getContextPath() %>?language=ru">RU</a>
        <spring:message code="language"/>
        <font color="green"><b><spring:message code="welcome.text"/></b></font>
      </div>
    </footer>
</body>
</html>