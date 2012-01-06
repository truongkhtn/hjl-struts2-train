<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title><s:text name="title.updateUser"/></title></head>

<body>
    <s:text name="label.id"/>:${user.userId}
    <br>
    <s:text name="label.name"/>: ${user.name}
    <br>
    <s:text name="label.gender"/>: ${user.gender}
    <br>
    <s:text name="label.state"/>: ${user.state}
    <br>
    <s:text name="label.email"/>: ${user.email}
    <br>
<s:url id="userListUrl" action="UserList" namespace="/user"/>
<s:a href="%{userListUrl}"><s:text name="label.return"/></s:a>
</body>
</html>