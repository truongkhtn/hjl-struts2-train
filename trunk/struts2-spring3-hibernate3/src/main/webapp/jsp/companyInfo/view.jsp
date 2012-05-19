<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    function editCompanInfo() {
        window.location.href = "/companyInfo/initCreateOrUpdate.action";
    }
</script>

<%--标题部分--%>
<table class="pageHead">
    <tr>
        <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
        <th align="left" class="title_area">当前位置：联系我们</th>
        <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
    </tr>
</table>

<%--产品信息--%>
<table width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="4"><b>联系方式</b></td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">台州负责人:</td>
        <td width="40%">
            <s:property escape="false" value="companyInfo.principal.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">台州计调:</td>
        <td width="40%">
            <s:property escape="false" value="companyInfo.allocateUser.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">联系电话:</td>
        <td width="40%">
            <s:property escape="false" value="companyInfo.contactTel.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">传真:</td>
        <td width="40%">
            <s:property escape="false" value="companyInfo.fax.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="pro_color2">QQ:</td>
        <td width="40%">
            <s:property escape="false" value="companyInfo.qq.replaceAll('\n','<br>').trim()"/>
        </td>
        <td width="10%" class="pro_color2">E-Mail:</td>
        <td width="40%">
            <s:property escape="false" value="companyInfo.eMail.replaceAll('\n','<br>').trim()"/>
        </td>
    </tr>
</table>

<table id="companyAccountInfo" width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
    <tr>
        <td class="pro_color1 f13" colspan="5"><b>账户信息</b></td>
    </tr>
    <tr>
        <td width="30px" class="pro_color3">序号</td>
        <td width="100px" class="pro_color3">银行名称</td>
        <td width="100px" class="pro_color3">户名</td>
        <td class="pro_color3">账号</td>
        <td width="150px" class="pro_color3">开户行</td>
    </tr>
    <s:if test="companyAccountList.size > 0">
        <%--循环输出 companyAccountList--%>
        <s:iterator value="companyAccountList" id="companyAccount" status="st">
            <tr class="companyAccountClass">
                <td class="center">
                    <s:property value='#st.index + 1'/>
                </td>
                <td>
                    <s:property escape="false" value="#companyAccount.blankName.replaceAll('\n','<br>').trim()"/>
                </td>
                <td>
                    <s:property escape="false" value="#companyAccount.userName.replaceAll('\n','<br>').trim()"/>
                </td>
                <td>
                    <s:property escape="false" value="#companyAccount.account.replaceAll('\n','<br>').trim()"/>
                </td>
                <td>
                    <s:property escape="false" value="#companyAccount.openAccountName.replaceAll('\n','<br>').trim()"/>
                </td>
            </tr>
        </s:iterator>
    </s:if>
</table>

<table width="90%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td align="center" colspan="4">
            <input type="button" class="myButton" style="width:65px" onclick="editCompanInfo()" value="编辑">
        </td>
    </tr>
</table>
