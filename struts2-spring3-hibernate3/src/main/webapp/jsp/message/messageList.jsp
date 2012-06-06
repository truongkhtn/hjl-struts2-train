<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style type="text/css">
    .mygrid td {
        text-align: center;
    }

</style>

<script type="text/javascript">
    function deleteUser(id) {
        if (confirm('确定删除此用户吗？')) {
            window.location.href = "/user/deleteEnabled.action?id=" + id;
        }
    }
</script>

<div class="right_main">
    <%--标题部分--%>
    <table class="pageHead">
        <tr>
            <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
            <th align="left" class="title_area">当前位置：消息列表</th>
            <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
        </tr>
    </table>
    <table class="mygrid">
        <tr class="myheader">
            <th width="30px"></th>
            <th width="90px">日期</th>
            <th width="150px">主题</th>
            <th width="40px">分类</th>
            <th width="120px">群组</th>
            <th>内容</th>
            <th  width="60px">操作</th>
        </tr>

        <s:iterator value="messageList" id="message" status="st">
            <s:if test="#st.Even">
                <tr class="tr-even">
            </s:if>
            <s:else>
                <tr class="tr-odd">
            </s:else>
            <td>
                <s:property value='#st.index + 1'/>
            </td>
            <td>
                <s:date name="#message.date" format="yyyy-MM-dd"/>
            </td>
            <td>
                <s:property value="#message.title"/>
            </td>
            <td>
                <s:property value="#message.messageCategory.name"/>
            </td>
            <td>
                <s:property value="#message.groups"/>
            </td>
            <td>
                <s:property value="#message.content"/>
            </td>
            <td class="td-operation">
                <a href="/message/view.action?id=<s:property value="#message.id"/>">查看</a>
                    <%--<a href="/user/initUpdate.action?id=<s:property value="#user.id"/>">修改</a>--%>
            </td>
            </tr>
        </s:iterator>

    </table>
</div>