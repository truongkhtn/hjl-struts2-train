<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title><s:text name="title.userList"/></title></head>

<body>
<s:actionmessage/>
<table>
    <s:if test="userList.size == 0">
        No record found!
    </s:if>
    <s:else>
        <tr>
            <th><s:text name="label.id"/></th>
            <th><s:text name="label.name"/></th>
            <th><s:text name="label.birthday"/></th>
        </tr>
        <s:iterator value="userList">
            <tr>
                <td>${id}</td>
                <td>${name}</td>
                <td>${birthday}</td>
                <td>
                    <a href="ViewUser.action?id=${id}"><s:text name="href.view"/></a>|
                    <a href="InitUpdateUser.action?id=${id}"><s:text name="href.edit"/></a>|
                    <a href="DeleteUser.action?id=${id}"><s:text name="href.delete"/></a>
                </td>
            </tr>
        </s:iterator>
    </s:else>
</table>

<s:url id="initCreateUserUrl" action="InitCreateUser"/>
<s:a href="%{initCreateUserUrl}"><s:text name="href.create"/></s:a>

</body>
</html>
