<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>操作成功</title>
<link rel="stylesheet" type="text/css" href="${path}/css/index.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/public.css"/>
<script type="text/javascript" src="${path}/js/jquery-1.7.2.js"></script>
<style type="text/css">
	.pageBody{
		width: 100%;
		height: 80%;
	}
	.resultTable{
		width: 90%;
		text-align: center;
		margin: 30px auto;		
	}
</style>
</head>
<body>
	<!-- 公共头部 -->
	<div class="header">
		<div class="top">
			<div class="top_left">
				<span class="f1">欢迎您：管理员</span>
			</div>
			<div class="top_right">
				<a class="top_ico0" href="${path}/index.jsp">首页</a>
				<a class="top_ico1" href="#">修改密码</a>
				<a class="top_ico2" href="#">个人信息</a> 
				<a class="top_ico3" href="${path}/login.jsp">退出</a>
			</div>
		</div>
		<div class="top2">
			<p class="pro_id">客户关系管理系统 v2.0</p>
		</div>
	</div>
	<!-- 中部DIV -->
	<div class="main">
		<div class="sidebar">
			<h2 id="menu1" class="menuTitle">客户管理</h2>
		  	<ul id="menu1_ul">
				<li class="menuItem"><a href="../customer/conflict.jsp">客户冲突</a></li>
				<li class="menuItem"><a href="../customer/add.jsp">添加客户</a></li>
				<li class="menuItem"><a href="../customer/serve.jsp">服务中签约客户</a></li>
				<li class="menuItem"><a href="../customer/noserve.jsp">未签约客户</a></li>
				<li class="menuItem"><a href="../customer/see.jsp">公海客户</a></li>
				<li class="menuItem"><a href="../customer/visit.jsp">拜访查询</a></li>
			</ul>
			<h2 id="menu2" class="menuTitle">合同管理</h2>
			<ul id="menu2_ul">
				<li class="menuItem"><a href="templateList.jsp">合同模版</a></li>
				<li class="menuItem"><a href="contractCreate.jsp">新增合同</a></li>
				<li class="menuItem"><a href="contractValid.jsp">有效合同查询</a></li>
				<li class="menuItem"><a href="contractInvalid.jsp">无效合同查询</a></li>
				<li class="menuItem"><a href="paymentReceivable.jsp">应收款查询</a></li>
				<li class="menuItem"><a href="paymentReceived.jsp">到款查询</a></li>
			</ul>
			<h2 id="menu3" class="menuTitle">报表管理</h2>
			<ul id="menu3_ul">
				<li class="menuItem"><a href="../report/visit.jsp">拜访量报表</a></li>
			</ul>
			<h2 id="menu4" class="menuTitle">系统设置</h2>
			<ul id="menu4_ul">
				<li class="menuItem"><a href="../system/employee.jsp">员工设置</a></li>
				<li class="menuItem"><a href="../system/else.jsp">其他设置</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="pageHead">
				<table>
			        <tr>
			            <th width="8"><img src="${path}//images/c_l.gif" height="31" width="8"/></th>
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 新增合同 &gt; 保存成功</th>
			            <th width="9"><img src="${path}//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
			  <table class="resultTable">
			    <tr>
			      <td>
			         <img src="${path}/images/success.jpg" width="200" height="150">
			      </td>
			    </tr>
			    <tr>
			      <td>
			      	<p>
			      		操作成功！
			      		<br>
			      		<b>订单编号:ORD-201209001</b>
		      		</p>
			      </td>
			    </tr>
			  </table>
			  <div class="buttonBar">
			    <input class="mybutton" type="button" value="返回"
			      onclick="javascript:history.back();"/>
			  </div>
			</div>
		</div>
	</div>
	<!-- 公共底部 -->
	<div class="footer">
		<div class="seperator"></div>
		<p>
			<a href="#">隐私策略</a>|
			<a href="#">服务条款</a> 
			XX公司版权所有 2012-2015
		</p>
	</div>
</body>
</html>