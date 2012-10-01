<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true"/>
    </title>
    <link rel="stylesheet" type="text/css" href="${path}/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/index.css"/>
    <script type="text/javascript" src="${path}/js/jquery-1.7.2.js"></script>
</head>
<body>
<!--头部-->
<div class="header">
    <tiles:insertAttribute name="header"/>
</div>

<!--主体-->
<table class="main" border="0" style="width:100%; background-color:#FFFFFF">
    <tr>
        <td width="140" style="vertical-align: top;">
            <div class="main_left">
                <tiles:insertAttribute name="menu"/>
            </div>
        </td>
        <td>
            <div class="main_right">
                <tiles:insertAttribute name="body"/>
            </div>
        </td>
    </tr>
</table>

<!--尾部-->
<div class="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>