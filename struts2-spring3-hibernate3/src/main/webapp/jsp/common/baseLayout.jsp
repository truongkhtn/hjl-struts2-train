<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache"/>
    <title>
        <tiles:insertAttribute name="title" ignore="true"/>
    </title>
    <link href="/styles/main.css" rel="stylesheet" type="text/css">
    <link href="/styles/public.css" rel="stylesheet" type="text/css">
    <link href="/styles/jquery-ui.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../js/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript" src="../../js/jquery.ui.core.js"></script>
    <script type="text/javascript" src="../../js/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="../../js/jquery.ui.position.js"></script>
    <script type="text/javascript" src="../../js/jquery.ui.dialog.js"></script>
    <script type="text/javascript" src="../../js/jquery.effects.core.js"></script>
    <script type="text/javascript" src="../../js/jquery-public.js"></script>
</head>
<body style="background-color:#CDCDCD">
<center>
    <!--头部-->
    <div class="header" align="center" style="width:80%; background-color:#FFFFFF">
        <tiles:insertAttribute name="header"/>
    </div>

    <!--主体-->
    <div style="width: 80%;">
        <table class="main" border="0" align="center" style="background-color:#FFFFFF">
            <tr>
                <td width="140">
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
    </div>

    <!--尾部-->
    <div class="footer" align="center" style="width:80%">
        <tiles:insertAttribute name="footer"/>
    </div>
</center>
</body>
</html>