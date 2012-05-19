<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="top">
    <div class="top_left">
        <div class="user_ico">
            <span class="fl tooltip">欢迎您： ${loginUser.companyName}</span>
        </div>
    </div>
    <div class="top_right">
        <a class="top_ico6" href="/j_spring_security_logout">退出</a>
        <a class="top_ico5" href="javascript:location.reload();">刷新</a>
        <a class="top_ico4" href="/user/initChangePass.action">修改密码</a>
        <%--<a class="top_ico1" href="/index.action">首页</a>--%>
    </div>
</div>
<div class="nav">
    <div class="nav logo fl"><img src="/images/logo.gif" alt="旅游产品预定平台" width="216" height="60"></div>
</div>