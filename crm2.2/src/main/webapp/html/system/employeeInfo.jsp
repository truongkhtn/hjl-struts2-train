<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>查看员工信息</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<style type="text/css">
	.mytable{
		width: 60%;
	}
	.mytable td{
		width: 200px;
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
				<a class="top_ico0" href="../../index.html">首页</a>
				<a class="top_ico1" href="#">修改密码</a>
				<a class="top_ico2" href="#">个人信息</a> 
				<a class="top_ico3" href="../../login.html">退出</a>
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
				<li class="menuItem"><a href="../customer/conflict.html">客户冲突</a></li>
				<li class="menuItem"><a href="../customer/add.html">添加客户</a></li>
				<li class="menuItem"><a href="../customer/serve.html">服务中签约客户</a></li>
				<li class="menuItem"><a href="../customer/noserve.html">未签约客户</a></li>
				<li class="menuItem"><a href="../customer/see.html">公海客户</a></li>
				<li class="menuItem"><a href="../customer/visit.html">拜访查询</a></li>
			</ul>
			<h2 id="menu2" class="menuTitle">合同管理</h2>
			<ul id="menu2_ul">
				<li class="menuItem"><a href="../contract/templateList.html">合同模版</a></li>
				<li class="menuItem"><a href="../contract/contractCreate.html">新增合同</a></li>
				<li class="menuItem"><a href="../contract/contractValid.html">有效合同查询</a></li>
				<li class="menuItem"><a href="../contract/contractInvalid.html">无效合同查询</a></li>
				<li class="menuItem"><a href="../contract/paymentReceivable.html">应收款查询</a></li>
				<li class="menuItem"><a href="../contract/paymentReceived.html">到款查询</a></li>
			</ul>
			<h2 id="menu3" class="menuTitle">报表管理</h2>
			<ul id="menu3_ul">
				<li class="menuItem"><a href="../report/visit.html">拜访量报表</a></li>
			</ul>
			<h2 id="menu4" class="menuTitle">系统设置</h2>
			<ul id="menu4_ul">
				<li class="menuItem"><a href="employee.html">员工设置</a></li>
				<li class="menuItem"><a href="else.html">其他设置</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="pageHead">
				<table>
			        <tr>
			            <th width="8"><img src="../..//images/c_l.gif" height="31" width="8"/></th>
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 查看员工信息</th>
			            <th width="9"><img src="../..//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
				<table class="mytable">
					<tr>
						<th>工号</th>
						<td>EMP_003</td>
					</tr>
					<tr>
						<th>姓名</th>
						<td>张三</td>
					</tr>
					<tr>
						<th>登陆账号</th>
						<td>user03</td>
					</tr>
					<tr>
						<th>账号状态</th>
						<td>启用</td>
					</tr>
					<tr>
						<th>所属部门</th>
						<td>营销部</td>
					</tr>
					<tr>
						<th>客户上限</th>
						<td>50</td>
					</tr>
					<tr>
						<th>性别</th>
						<td>男</td>
					</tr>
					<tr>
						<th>生日</th>
						<td>1985-5-5</td>
					</tr>
					<tr>
						<th>角色</th>
						<td>业务员,业务主管</td>
					</tr>
					<tr>
						<th>手机</th>
						<td>13966667777</td>
					</tr>
					<tr>
						<th>备注</th>
						<td>员工备注内容</td>
					</tr>
				</table>
				<div class="buttonBar">
					<input type="button" class="mybutton" value="返回" onclick="javascript:history.back();">
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