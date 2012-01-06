<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>if用例</title></head>

<body>
<%
java.util.HashMap map = new java.util.LinkedHashMap();
map.put("name","姓名");
map.put("email","邮件");
request.setAttribute("map",map);
%>

<s:form method="post" action="UserQuery2">
    <s:select list="#request.map"  label="查询条件" listKey="key" listValue="value"
        headerKey="0" name="condition" headerValue="please select..."></s:select>

    <s:textfield name="value" key="label.value"/>
    <s:submit/>
</s:form>
</body>
</html>