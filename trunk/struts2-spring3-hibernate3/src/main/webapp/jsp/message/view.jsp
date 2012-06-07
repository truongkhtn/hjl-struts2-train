<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="right_main">
    <%--标题部分--%>
    <table class="pageHead">
        <tr>
            <th width="8"><img src="/images/c_l.gif" height="31" width="8"/></th>
            <th align="left" class="title_area">当前位置：查看消息</th>
            <th width="9"><img src="/images/c_r.gif" height="31" width="9"></th>
        </tr>
    </table>

    <table class="myTable01" widtd="100%" cellspacing="0" cellpadding="3">
        <tr>
            <th>主题:</th>
            <td><s:property escape="false" value="message.title"/></td>
        </tr>
        <tr>
            <th>群组:</th>
            <td><s:property escape="false" value="message.groups"/></td>
        </tr>
        <tr>
            <th>日期:</th>
            <td><s:date name="message.date" format="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <th>分类:</th>
            <td><s:property escape="false" value="message.messageCategory.name"/></td>
        </tr>
        <tr>
            <th>内容:</th>
            <td><s:property escape="false" value="message.content"/></td>
        </tr>
    </table>

    <br>

    <table class="mygrid">
        <tr class="myheader">
            <th width="10%">编号</th>
            <th width="30%">消息主题</th>
            <th width="30%">接收人姓名</th>
            <th width="30%">状态</th>
        </tr>

        <s:iterator value="message.messageLogs" id="messageLog" status="st">
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
                <s:property value="#messageLog.message.title"/>
            </td>
            <td>
                <s:property value="#messageLog.user.realname"/>
            </td>
            <td>
                <s:if test="#messageLog.UnRead">
                    未读
                </s:if>
                <s:else>
                    已读
                </s:else>
                <%--<s:property value="#messageLog.readStatus"/>--%>
            </td>
            </tr>
        </s:iterator>
        <tr>
            <td align="center" colspan="4">
                <input class="myButton" type="button" onclick="history.go(-1)" value="返回">
            </td>
        </tr>
    </table>
</div>