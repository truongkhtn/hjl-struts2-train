<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>if用例</title></head>

<body>

<s:form method="post" action="UserQuery3">
    <s:textfield name="user.name" key="label.name"/>
    <s:textfield name="user.state" key="label.state"/>
    <s:textfield name="user.email" key="label.email"/>
    <s:submit/>
</s:form>
</body>
</html>