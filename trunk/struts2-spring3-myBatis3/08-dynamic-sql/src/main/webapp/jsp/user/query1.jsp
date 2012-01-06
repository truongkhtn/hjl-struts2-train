<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>if用例</title></head>

<body>
<s:form method="post" action="UserQuery1">
    <s:textfield name="user.name" key="label.name"/>
    <s:submit/>
</s:form>
</body>
</html>