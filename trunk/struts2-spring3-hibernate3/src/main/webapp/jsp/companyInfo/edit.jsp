<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        $("#btnAddCompanyAccount").click(function() {
            var index = $("#companyAccountInfo tr::last-child").index();
            var num = Number(index) - Number(1);
            $("<tr class='companyAccountClass'></tr>").appendTo($("#companyAccountInfo"));
            $lastTr = $("#companyAccountInfo tr::last-child");
            $('<td class="center">' + index + '</td>').appendTo($lastTr);
            $('<td><s:textfield name="companyAccountList[' + num + '].blankName" size="10"/></td>').appendTo($lastTr);
            $('<td><s:textfield name="companyAccountList[' + num + '].userName" size="10"/></td>').appendTo($lastTr);
            $('<td><s:textfield name="companyAccountList[' + num + '].account" size="30"/></td>').appendTo($lastTr);
            $('<td><s:textfield name="companyAccountList[' + num + '].openAccountName" size="10"/></td>').appendTo($lastTr);
            $('<td><input type="button" value="删除" style="width:65px" class="myButton" onclick="delete_companyAccount(this);"></td>').appendTo($lastTr);
        });

        $("#editForm").submit(function() {
            if ($("#RECORD_ID").val() == "") {
                $("#editForm").attr('action', '/companyInfo/create.action');
            } else {
                $("#editForm").attr('action', '/companyInfo/update.action');
            }
            return true;
        });
    });

    //删除公司账户 tr
    function delete_companyAccount(obj) {
        $tr = $(obj).parent().parent();

        if (confirm("确认要删除吗？")) {
            $tr.remove();
            refresh_journey();
        }
    }

    //刷新tr排序
    function refresh_journey() {
        var num = 0;
        $("#companyAccountInfo .companyAccountClass").each(function() {
            $(this).children('td').eq(0).text(num+1);
            $(this).children('td').eq(1).children().attr("name", 'companyAccountList[' + num + '].blankName');
            $(this).children('td').eq(2).children().attr("name", 'companyAccountList[' + num + '].userName');
            $(this).children('td').eq(3).children().attr("name", 'companyAccountList[' + num + '].account');
            $(this).children('td').eq(4).children().attr("name", 'companyAccountList[' + num + '].openAccountName');
            num ++;
        });
    }

    //判断tr中数据是否合法
    function isValid(tr) {
        if (tr.find('.companyAccount-blankName').val() == "") {
            return false;
        }
        return true;
    }
</script>

<s:form id="editForm" action="create" namespace="/companyInfo" method="post">
    <s:hidden id="RECORD_ID" name="companyInfo.id"/>
    <s:hidden name="companyInfo.version"/>
    <%--标题部分--%>
    <table class="pageHead">
        <tr>
            <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
            <th align="left" class="title_area">当前位置：编辑联系方式</th>
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
                <s:textfield name="companyInfo.principal" id="PRINCIPAL" size="50"/>
            </td>
            <td width="10%" class="pro_color2">台州计调:</td>
            <td width="40%">
                <s:textfield name="companyInfo.allocateUser" id="ALLOCATE_USER" size="50"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="pro_color2">联系电话:</td>
            <td width="40%">
                <s:textfield name="companyInfo.contactTel" id="CONTACT_TEL" size="50"/>
            </td>
            <td width="10%" class="pro_color2">传真:</td>
            <td width="40%">
                <s:textfield name="companyInfo.fax" id="FAX" size="50"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="pro_color2">QQ:</td>
            <td width="40%">
                <s:textfield name="companyInfo.qq" id="QQ" size="50"/>
            </td>
            <td width="10%" class="pro_color2">E-Mail:</td>
            <td width="40%">
                <s:textfield name="companyInfo.eMail" id="EMAIL" size="50"/>
            </td>
        </tr>
    </table>

    <table id="companyAccountInfo" width="90%" cellspacing="0" cellpadding="0" border="0" class="pro_table">
        <tr>
            <td class="pro_color1 f13" colspan="5"><b>账户信息</b></td>
            <td class="pro_color1 f13">
                <input id="btnAddCompanyAccount" class="myButton" style="width:65px" type="button" value="+ 添加账户">
            </td>
        </tr>
        <tr>
            <td width="30px" class="pro_color3">序号</td>
            <td width="100px" class="pro_color3">银行名称</td>
            <td width="100px" class="pro_color3">户名</td>
            <td class="pro_color3">账号</td>
            <td width="150px" class="pro_color3">开户行</td>
            <td width="80px" class="pro_color3">操作</td>
        </tr>
        <%--循环输出 companyAccountList--%>
        <s:iterator value="companyAccountList" id="companyAccount" status="st">
            <tr class="companyAccountClass">
                <td class="center"><s:property value='#st.index + 1'/></td>
                <td><s:textfield name="companyAccountList[%{#st.index}].blankName" size="10" cssClass="companyAccount-blankName"/></td>
                <td><s:textfield name="companyAccountList[%{#st.index}].userName" size="10" cssClass="companyAccount-userName"/></td>
                <td><s:textfield name="companyAccountList[%{#st.index}].account" size="30" cssClass="companyAccount-account"/></td>
                <td><s:textfield name="companyAccountList[%{#st.index}].openAccountName" size="10" cssClass="companyAccount-openAccountName"/></td>
                <td><input class="myButton" type="button" style="width:65px" onclick="delete_companyAccount(this);" value="删除"></td>
            </tr>
        </s:iterator>
    </table>

    <table width="90%" cellspacing="0" cellpadding="0" border="0" class="page_button">
        <tr>
            <td align="center" colspan="4">
                <input class="myButton" type="submit" style="width:65px" value="确认">
                <input class="myButton" type="button" style="width:65px" onclick="history.go(-1)" value="返回">
            </td>
        </tr>
    </table>
</s:form>