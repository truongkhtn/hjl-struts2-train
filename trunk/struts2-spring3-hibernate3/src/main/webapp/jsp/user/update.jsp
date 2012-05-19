<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
        $().ready(function() {
            $("#userUpdateForm").submit(function() {
                if ($("#COMPNAME").val() == "") {
                    alert("请填写公司名称");
                    return false;
                }
                if ($("#TRUENAME").val() == "") {
                    alert("请填写真实姓名");
                    return false;
                }
                if ($("#TELEPHONE").val() == "") {
                    alert("请填写联系电话");
                    return false;
                }
                if ($("#FAXESNO").val() == "") {
                    alert("请填写公司的传真号码");
                    return false;
                }
                if ($("#MOBILE").val() == "") {
                    alert("请填写手机号码");
                    return false;
                }
                if (!isMobile($("#MOBILE").val())) {
                    alert("手机号填写不正确,请重新输入");
                    return false;
                }
                return true;
            });
        });
    </script>

<s:form id="userUpdateForm" action="update" namespace="/user" method="post">
<table class="myTable01" widtd="100%" cellspacing="0" cellpadding="3">
    <s:hidden name="user.id"/>
    <tr>
        <th>
            用户名:
        </th>
        <td>
            <s:textfield name="user.username" readonly="true"/>
        </td>
    </tr>
    <tr>
        <th>
            所在区域:
        </th>
        <td>
            <s:textfield name="user.area" readonly="true"/>
        </td>
    </tr>
    <tr>
        <th>
            公司名称:
        </th>
        <td>
            <s:textfield name="user.companyName" size="60" id="COMPNAME"/>
            <span class="required">*</span>
        </td>
    </tr>
    <tr>
        <th>
            公司地址:
        </th>
        <td>
            <s:textfield name="user.companyAddress" size="60" id="ADDRESS"/>
        </td>
    </tr>
    <tr>
        <th>
            真实姓名:
        </th>
        <td>
            <s:textfield name="user.name" id="TRUENAME"/>
            <span class="required">*</span><s:property escape="false" value="%{getText('text.user.update.trueName')}" />
        </td>
    </tr>
    <tr>
        <th>
            联系电话:
        </th>
        <td>
            <s:textfield name="user.phone" id="TELEPHONE"/>
            <span class="required">*</span><s:property escape="false" value="%{getText('text.user.register.phone.format')}" />
        </td>
    </tr>
    <tr>
        <th>
            传真号码:
        </th>
        <td>
            <s:textfield name="user.fax" id="FAXESNO"/>
            <span class="required">*</span>
        </td>
    </tr>
    <tr>
        <th>
            手机号码:
        </th>
        <td>
            <s:textfield name="user.cellPhone" id="MOBILE"/>
            <span class="required">*</span>
        </td>
    </tr>
    <tr>
        <td align="center" colspan="2">
            <input class="myButton" type="submit" value="确认">
            <input class="myButton" type="button" onclick="history.go(-1)" value="返回">
        </td>
    </tr>
</table>
</s:form>
