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

<div class="sidebar">
    <s:if test="loginUserRoleRemark.contains('客户管理')">
        <h2 id="menu1" class="menuTitle">客户管理</h2>
        <ul id="menu1_ul">
            <li class="menuItem"><a href="html/customer/conflict.jsp">客户冲突</a></li>
            <li class="menuItem"><a href="html/customer/add.jsp">添加客户</a></li>
            <li class="menuItem"><a href="html/customer/serve.jsp">服务中签约客户</a></li>
            <li class="menuItem"><a href="html/customer/noserve.jsp">未签约客户</a></li>
            <li class="menuItem"><a href="html/customer/see.jsp">公海客户</a></li>
            <li class="menuItem"><a href="html/customer/visit.jsp">拜访查询</a></li>
        </ul>
    </s:if>
    <s:if test="loginUserRoleRemark.contains('合同管理')">
        <h2 id="menu2" class="menuTitle">合同管理</h2>
        <ul id="menu2_ul">
            <li class="menuItem"><a href="html/contract/templateList.jsp">合同模版</a></li>
            <li class="menuItem"><a href="html/contract/contractCreate.jsp">新增合同</a></li>
            <li class="menuItem"><a href="html/contract/contractValid.jsp">有效合同查询</a></li>
            <li class="menuItem"><a href="html/contract/contractInvalid.jsp">无效合同查询</a></li>
            <li class="menuItem"><a href="html/contract/paymentReceivable.jsp">应收款查询</a></li>
            <li class="menuItem"><a href="html/contract/paymentReceived.jsp">到款查询</a></li>
        </ul>
    </s:if>
    <s:if test="loginUserRoleRemark.contains('报表管理')">
        <h2 id="menu3" class="menuTitle">报表管理</h2>
        <ul id="menu3_ul">
            <li class="menuItem"><a href="html/report/visit.jsp">拜访量报表</a></li>
        </ul>
    </s:if>
    <s:if test="loginUserRoleRemark.contains('系统设置')">
        <h2 id="menu4" class="menuTitle">系统设置</h2>
        <ul id="menu4_ul">
            <li class="menuItem"><a href="html/system/employee.jsp">员工设置</a></li>
            <li class="menuItem"><a href="html/system/else.jsp">其他设置</a></li>
        </ul>
    </s:if>
</div>