<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title><s:text name="title.updateUser"/></title></head>

<body>
<s:form method="post" action="UpdateUser">
    <table>
        <s:textfield name="user.name" key="label.name"/>
        <s:textfield name="user.birthday" key="label.birthday"/>
        <tr>
            <td colspan="2">
                <s:submit/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
