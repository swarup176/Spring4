<html>
	<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
	<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
	<f:view>
		<head>
			<title>Sample JSF Application</title>
		</head>
	
		<body>
			<h3>Please enter your credentials here.</h3>
			<h:form>
				<h:panelGrid>
					<h:outputText value="UserId: " />
					<h:inputText value="#{user.id}"/>
					<h:outputText value="Password: " />
					<h:inputSecret value="#{user.password}"/>
				</h:panelGrid>
				<div align="center">
					<h:commandButton value="Login" action="#{user.login}" />
				</div>
			</h:form>
		</body>
	</f:view>
	
</html>
