<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title><s:text name="title.updateUser"/></title></head>

<body>
按实例更新 (set 用例)
<br>
<s:form method="post" action="UpdateUser">
    <table>
        <s:textfield name="user.name" key="label.name"/>
        <s:textfield maxLength="1" name="user.gender" key="label.gender"/>
        <s:textfield name="user.state" key="label.state"/>
        <s:textfield name="user.email" key="label.email"/>
        <tr>
            <td colspan="2">
                <s:submit/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
