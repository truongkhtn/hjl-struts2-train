<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $().ready(function() {
        //表单提交js验证
        $("#messageEditForm").submit(function() {
            if ($("#MSG_TITLE").val() == "") {
                alert("请填写主题！");
                return false;
            }

            var noGroup = true;
            $("input[name='ids']").each(function() {
                if ($(this).attr("checked")) {
                    noGroup = false;
                }
            });
            if (noGroup) {
                alert("请选择群组！");
                return false;
            }

            if ($("#MSG_CONTENT").val() == "") {
                alert("请填写内容！");
                return false;
            }
            return true;
        });

        //全体分组默认选中
        $("#GROUP_ALL").attr("checked", "checked");

        //日期控件
        $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
        $.datepicker.setDefaults({
            showOn: "button",
            buttonImage: "../../images/calendar.png",
            buttonImageOnly: true
        });
        $("#MSG_DATE_EDITABLE").datepicker();

        //定义弹出框
        $("#infoDialog").dialog({
            autoOpen: false,
            show: "highlight",
            hide: "none",
            height:100,
            width:150
        });
    });
</script>

<div class="right_main">
    <s:form id="messageEditForm" action="create" namespace="/message" method="post">
        <table class="myTable01" widtd="100%" cellspacing="0" cellpadding="3">
            <tr>
                <th>主题:</th>
                <td>
                    <s:textfield name="message.title" size="60" id="MSG_TITLE"/>
                    <span class="required">*</span>
                </td>
            </tr>
            <tr>
                <th>群组:</th>
                <td>
                    <s:checkbox id="GROUP_ALL" name="ids" value="all"/>全体
                    <br>
                    <s:checkboxlist name="ids" value="74a45316-39db-43bc-8fe2-758fe3cc51d9" list="groupList"
                                    listKey="id" listValue="name"/>
                </td>
            </tr>
            <tr>
                <th>日期:</th>
                <td>
                        <%--<s:textfield name="message.date" id="MSG_DATE_EDITABLE" size="12"/>--%>
                        <%--<span class="required">*</span>--%>

                    <s:textfield name="message.date" id="MSG_DATE_READ_ONLY" size="12" readonly="true">
                        <s:param name="value"><s:date name="createDate" format="yyyy-MM-dd"/></s:param>
                    </s:textfield>
                </td>
            </tr>
            <tr>
                <th>分类:</th>
                <td>
                    <s:select name="messageCategoryId" list="messageCategoryList" listKey="id" listValue="name"/>
                </td>
            </tr>
            <tr>
                <th>内容:</th>
                <td>
                    <s:textarea cols="60" rows="6" name="message.content" id="MSG_CONTENT"/>
                    <span class="required">*</span>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input class="myButton" type="submit" value="提交">
                    <input class="myButton" type="button" onclick="history.go(-1)" value="返回">
                </td>
            </tr>
        </table>
    </s:form>
</div>