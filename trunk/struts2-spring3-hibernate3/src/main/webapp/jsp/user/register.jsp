<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户注册</title>
    <link href="../../styles/register.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="../../js/jquery-public.js"></script>
    <script type="text/javascript">
        $().ready(function() {
            $("#form").submit(function() {
                if ($("#CITY_ID").val() == "0") {
                    alert("请选择您的公司所在区域");
                    return false;
                }
                if ($("#COMPNAME").val() == "") {
                    alert("请填写您的公司名称");
                    return false;
                }
                if ($("#TRUENAME").val() == "") {
                    alert("请填写您的真实姓名");
                    return false;
                }
                if ($("#TELEPHONE").val() == "") {
                    alert("请填写您的联系电话");
                    return false;
                }
                if ($("#FAXESNO").val() == "") {
                    alert("请填写您公司的传真号码");
                    return false;
                }
                if ($("#MOBILE").val() == "") {
                    alert("请填写您的手机号码");
                    return false;
                }
                if (!isMobile($("#MOBILE").val())) {
                    alert("手机号填写不正确,请重新输入");
                    return false;
                }
                if ($("#USERNAME").val() == "") {
                    alert("请输入用户名");
                    return false;
                }
                if ($("#USERPWD").val() == "") {
                    alert("请输入密码");
                    return false;
                }
                if ($("#USERPWD1").val() == "") {
                    alert("请输入确认密码");
                    return false;
                }
                if($("#USERPWD").val() != $("#USERPWD1").val()){
                    alert("两次输入的密码并不相同,请重新输入");
                    return false;
                }
                if($("#SERVICE").attr("checked") != "checked"){
//                    alert($("#SERVICE").attr("checked"));
                    alert("您是否已阅读网站服务条款?");
                    return false;
                }
            });
        });
    </script>
</head>
<body class="body">
<div id="head"><img src="../../images/logo_zyym.jpg" height="70" width="150"><span>用户注册</span></div>

<div id="contentbox">
<div id="menu">
    <ul>
        <li>客服:001-12345678</li>
    </ul>
</div>
<div id="content">
<table align="left" border="0" cellpadding="0" cellspacing="0" width="80%">
<s:form cssClass="form" method="post" action="register" namespace="/user" id="form">
<tr>
    <td colspan="2" height="30"><strong>
        <s:property escape="false" value="%{getText('text.user.register.caution')}"/>
    </strong></td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.area')}" />：</td>
    <td>
        <s:select id="CITY_ID" name="user.area" list="areaList"
                  listKey="code" listValue="displayName"/>
        <span class="font1">*</span>
    </td>
</tr>
<tr>
    <td height="30" width="14%"><s:property escape="false" value="%{getText('label.companyName')}" />：</td>
    <td width="86%">
        <s:textfield name="user.companyName" id="COMPNAME" size="40" cssclass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
        <span class="font1">*<s:property escape="false" value="%{getText('text.user.register.companyOnly')}" /></span> <br>
    </td>
</tr>
<tr>
    <td height="30"></td>
    <td><s:property escape="false" value="%{getText('text.user.register.fullName')}" /></td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.companyAddress')}" />：</td>
    <td>
        <s:textfield name="user.companyAddress" id="ADDRESS" size="60" cssClass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
    </td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.trueName')}" />：</td>
    <td>
        <s:textfield name="user.name" id="TRUENAME" size="10" cssClass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
        <span class="font1">*</span><s:property escape="false" value="%{getText('text.user.register.trueName')}" />
    </td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.phone')}" />：</td>
    <td>
        <s:textfield name="user.phone" id="TELEPHONE" size="20" cssclass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
        <span class="font1">*</span><s:property escape="false" value="%{getText('text.user.register.phone.format')}" />
    </td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.fax')}" />：</td>
    <td>
        <s:textfield name="user.fax" id="FAXESNO" size="20" cssclass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
        <span class="font1">*</span>
    </td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.cell')}" />：</td>
    <td>
        <s:textfield name="user.cellPhone" id="MOBILE" size="20" cssclass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
        <span class="font1">*</span>
    </td>
</tr>
<tr>
    <td colspan="2" style="border-bottom: 1px dashed rgb(204, 204, 204);" height="15">&nbsp;</td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.username')}" />：</td>
    <td>
        <s:textfield name="user.username" id="USERNAME" size="20" cssclass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'"/>
        <span class="font1">*</span><s:property escape="false" value="%{getText('text.user.register.username')}" />
    </td>
</tr>
<tr>
    <td height="30">&nbsp;</td>
    <td id="Msg">
        <s:fielderror cssStyle="color: #ff0000;">
            <s:param>user.username</s:param>
        </s:fielderror>
    </td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.password')}" />：</td>
    <td>
        <s:password name="user.password" id="USERPWD" size="20" cssClass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'" />
        <span class="font1">*</span>
    </td>
</tr>
<tr>
    <td height="30"><s:property escape="false" value="%{getText('label.confirm.password')}" />：</td>
    <td>
        <s:password name="password1" id="USERPWD1" size="20" cssclass="inputbox"
                    onfocus="this.className='inputbox_select'"
                    onblur="this.className='inputbox'" />
        <span class="font1">*</span>
    </td>
</tr>
<tr>
    <td colspan="2" height="15">&nbsp;</td>
</tr>
<tr>
    <td colspan="2" height="15">
        <textarea name="textarea" id="textarea" cols="70" rows="6">
            <s:property escape="false" value="%{getText('text.user.register.termOfService')}" />
        </textarea>
    </td>
</tr>
<tr>
    <td colspan="2" style="color: green;" height="15">
        <input name="SERVICE" id="SERVICE" type="checkbox"><s:property escape="false" value="%{getText('text.user.register.read')}" />
    </td>
</tr>
<tr>
    <td colspan="2" height="40">
        <input name="button" id="button"
               value="提交注册申请" class="button" type="submit">
        <s:property escape="false" value="%{getText('text.user.register.remark')}" />
    </td>
</tr>

</s:form>
</table>

</div>
</div>

<div id="bottom">
    <div><s:property escape="false" value="%{getText('text.user.register.copyright')}" /></div>
</div>

</body>
</html>