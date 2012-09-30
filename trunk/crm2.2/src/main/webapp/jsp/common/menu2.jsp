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

<s:if test="loginUser.area == 'ADMIN'">
    <h2 id="menu1" class="title">线路管理</h2>
    <ul id="menu1ul" style="display:block;">
        <li><a href="/route/list.action" title="制定所有线路，供线路发布使用">线路列表</a></li>
        <li><a href="/routePrice/list.action" title="制定所有线路，供线路发布使用">线路报价</a></li>
        <li><a href="/companyInfo/view.action" title="联系我们">联系我们</a></li>
    </ul>

    <h2 id="menu2" class="title">订单管理</h2>
    <ul id="menu2ul" style="display:block;">
        <li><a href="/order/list.action">订单查询</a></li>
    </ul>

    <h2 id="menu3" class="title">用户管理</h2>
    <ul id="menu3ul" style="display:block;">
        <li><a href="/user/disabledUserList.action">待开通用户</a></li>
        <li><a href="/user/enabledUserList.action">已开通用户</a></li>
    </ul>
</s:if>
<s:elseif test="loginUser.area == 'test'">
</s:elseif>
<s:else>
    <h2 id="menu1" class="title">线路管理</h2>
    <ul id="menu1ul" style="display:block;">
        <li><a href="#">线路报价</a></li>
        <li><a href="#">联系我们</a></li>
    </ul>

    <h2 id="menu2" class="title">订单管理</h2>
    <ul id="menu2ul" style="display:block;">
        <li><a href="#">订单查询</a></li>
    </ul>

</s:else>