<%@ page isELIgnored="true" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="true" %>

<script type="text/javascript">
    $().ready(function() {
        $(".title").click(function() {
            var nodeName = this.id + 'ul';
            var node = $('#' + nodeName);
        });
    });
</script>

<s:if test="loginUser.admin == true">
    <h2 id="menu1" class="title">消息管理</h2>
    <ul id="menu1ul" style="display:block;">
        <li><a href="/message/initCreate.action">发布新消息</a></li>
        <li><a href="/message/messageList.action">消息列表</a></li>
    </ul>

    <h2 id="menu2" class="title">用户管理</h2>
    <ul id="menu2ul" style="display:block;">
        <li><a href="/user/initCreate.action">创建新用户</a></li>
        <li><a href="/user/userList.action">用户列表</a></li>
    </ul>
</s:if>
<s:else>
    <h2 id="menu2" class="title">用户管理 222</h2>
    <ul id="menu2ul" style="display:block;">
        <li><a href="#">修改密码</a></li>
    </ul>

</s:else>