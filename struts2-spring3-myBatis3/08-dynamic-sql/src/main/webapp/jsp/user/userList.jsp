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
            <th><s:text name="label.gender"/></th>
            <th><s:text name="label.state"/></th>
            <th><s:text name="label.email"/></th>
        </tr>
        <s:iterator value="userList">
            <tr>
                <td>${userId}</td>
                <td>${name}</td>
                <td>${gender}</td>
                <td>${state}</td>
                <td>${email}</td>
                <td>
                    <a href="ViewUser.action?id=${userId}"><s:text name="href.view"/></a>|
                    <a href="InitUpdateUser.action?id=${userId}"><s:text name="href.edit"/></a>|
                    <a href="DeleteUser.action?id=${userId}"><s:text name="href.delete"/></a>
                </td>
            </tr>
        </s:iterator>
    </s:else>
</table>

<s:url id="initCreateUserUrl" action="InitCreateUser"/>
<s:a href="%{initCreateUserUrl}"><s:text name="href.create"/></s:a>
<br>
<br>
动态sql用例:
<br>
<s:url id="initQuery1Url" action="InitQuery1"/>
<s:a href="%{initQuery1Url}">仅按姓名(if 用例)</s:a>
<br>
<s:url id="initQuery2Url" action="InitQuery2"/>
<s:a href="%{initQuery2Url}">单条件(choose 用例)</s:a>
<br>
<s:url id="initQuery3Url" action="InitQuery3"/>
<s:a href="%{initQuery3Url}">多条件(where 用例)</s:a>
<br>
<s:url id="initQuery4Url" action="InitQuery4"/>
<s:a href="%{initQuery4Url}">迭代(foreach 用例)</s:a>

</body>
</html>
