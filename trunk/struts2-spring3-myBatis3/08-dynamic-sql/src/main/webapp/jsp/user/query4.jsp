<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>if用例</title></head>

<body>

<s:form method="post" action="UserQuery4">
    <s:checkboxlist
            name="selectedIds"
            list="#request.availdIds"
            listValue="key"
            listKey="value"
            labelposition="left">
    </s:checkboxlist>
    <s:submit/>
</s:form>
</body>
</html>