<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title><s:text name="title.createUser"/></title></head>

<body>
<s:form method="post" action="CreateUser">
    <table>
        <s:textfield name="user.name" key="label.name"/>
        <tr>
            <td colspan="2">
                <s:submit/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
