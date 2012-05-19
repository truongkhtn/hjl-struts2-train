<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th align="left">编辑用户信息</th>
    </tr>
</table>

<table class="myTable01" widtd="100%" cellspacing="0" cellpadding="3">
    <tr>
        <th>用户名:</th>
        <td><s:property escape="false" value="user.username"/></td>
    </tr>
    <tr>
        <th>所在区域:</th>
        <td><s:property escape="false" value="user.area"/></td>
    </tr>
    <tr>
        <th>公司名称:</th>
        <td><s:property escape="false" value="user.companyName"/></td>
    </tr>
    <tr>
        <th>公司地址:</th>
        <td><s:property escape="false" value="user.companyAddress"/></td>
    </tr>
    <tr>
        <th>真实姓名:</th>
        <td><s:property escape="false" value="user.name"/></td>
    </tr>
    <tr>
        <th>联系电话:</th>
        <td><s:property escape="false" value="user.phone"/></td>
    </tr>
    <tr>
        <th>传真号码:</th>
        <td><s:property escape="false" value="user.fax"/></td>
    </tr>
    <tr>
        <th>手机号码:</th>
        <td><s:property escape="false" value="user.cellPhone"/></td>
    </tr>
    <tr>
        <td align="center" colspan="2">
            <input class="return-button" type="submit" onclick="history.go(-1)" value="返回">
        </td>
    </tr>
</table>
