<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title><s:text name="title.updateUser"/></title></head>

<body>
    <s:text name="label.name"/>:${user.id}
    <br>
    <s:text name="label.birthday"/>: ${user.birthday}
    <br>
<s:url id="userListUrl" action="UserList" namespace="/user"/>
<s:a href="%{userListUrl}"><s:text name="label.return"/></s:a>
</body>
</html>