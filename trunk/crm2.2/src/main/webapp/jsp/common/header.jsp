<%@ page contentType="text/html; charset=UTF-8" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="top">
    <div class="top_left">
        <span class="f1">欢迎您：<s:property value="loginUserAuthorities"/></span>
    </div>
    <div class="top_right">
        <s:a namespace="/" action="index" cssClass="top_ico0">首页</s:a>
        <%--<a class="top_ico1" href="#">修改密码</a>--%>
        <%--<a class="top_ico2" href="#">个人信息</a>--%>
        <s:a namespace="/" action="logout" cssClass="top_ico3">退出</s:a>
    </div>
</div>
<div class="top2">
    <p class="pro_id">客户关系管理系统 v2.0</p>
</div>