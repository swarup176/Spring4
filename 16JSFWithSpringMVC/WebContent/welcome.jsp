<html>
	<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
	<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
	<f:view>
		<head>
			<title>Sample JSF Application</title>
		</head>
	
		<body>
			Hello <h:outputText value="#{user.id}" />! 
			Welcome to JSF.
		</body>
	</f:view>
	
</html>
