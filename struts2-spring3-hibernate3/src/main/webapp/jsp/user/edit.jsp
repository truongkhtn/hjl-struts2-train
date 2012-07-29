<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        if ($("#USER_ID").val() != "") {
            //$("#USERNAME").attr("readonly", true);//将input元素设置为readonly
            $("#USERNAME").attr("disabled",true)//将input元素设置为disabled
        }

        $("#FORM_SUBMIT_BTN").click(function() {
            if ($("#USERNAME").val() == "") {
                alert("请填写用户名");
                return false;
            }
            if ($("#PASSWORD").val() == "") {
                alert("请填写密码");
                return false;
            }
            if ($("#REALNAME").val() == "") {
                alert("请填写真实姓名");
                return false;
            }
            if ($("#USER_ID").val() != "") {
                $("#userEditForm").attr("action", "/user/update.action");
            }
            $("#userEditForm").submit();
        });
    });
</script>

<div class="right_main">
    <%--标题部分--%>
    <table class="pageHead">
        <tr>
            <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
            <th align="left" class="title_area">当前位置：创建/编辑用户</th>
            <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
        </tr>
    </table>

    <s:form id="userEditForm" action="create" namespace="/user" method="post">
        <s:fielderror cssStyle="color: #ff0000;"/>
        <table class="myTable01" widtd="100%" cellspacing="0" cellpadding="3">
            <s:hidden name="user.id" id="USER_ID"/>
            <s:hidden name="user.version"/>
            <tr>
                <th>用户名:</th>
                <td>
                    <s:textfield name="user.username" id="USERNAME"/>
                    <span class="required">*</span>
                </td>
            </tr>
            <tr>
                <th>密码:</th>
                <td>
                    <s:textfield name="user.password" id="PASSWORD"/>
                    <span class="required">*</span>
                </td>
            </tr>
            <tr>
                <th>真实姓名:</th>
                <td>
                    <s:textfield name="user.realname" id="REALNAME"/>
                    <span class="required">*</span>
                </td>
            </tr>
            <tr>
                <th>组别:</th>
                <td>
                    <s:select name="id" list="groupList" listKey="id" listValue="name" value="GroupIdDisplay"/>
                </td>
            </tr>
            <tr>
                <th>是否管理员:</th>
                <td>
                    <s:radio name="user.Admin" list="#{false:'否', true:'是'}" value="user.Admin"/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <p class="myButtonRow" >
                        <input id="FORM_SUBMIT_BTN" class="myButton" type="button" value="确认">
                        <input class="myButton" type="button" onclick="history.go(-1)" value="返回">
                    </p>
                </td>
            </tr>
        </table>
    </s:form>
</div>
