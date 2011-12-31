<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="HelloWorld.message"/></title>
</head>

<body>
<h2><s:property value="message"/></h2>
<s:url id="urlInitLogin" action="InitLogin"/>
<s:a href="%{urlInitLogin}"><s:text name="login"/></s:a>

<s:url id="userListUrl" action="UserList" namespace="/user"/>
<s:a href="%{userListUrl}"><s:text name="label.userList"/></s:a>

<ul>
    <li>
        <s:url id="url" action="HelloWorld">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="HelloWorld">
            <s:param name="request_locale">zh</s:param>
        </s:url>
        <s:a href="%{url}">中文</s:a>
    </li>
</ul>

</body>
</html>
