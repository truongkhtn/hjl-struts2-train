<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>拜访记录</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<style type="text/css">
	.mytable td{
		text-align: center;
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
				<li class="menuItem"><a href="conflict.html">客户冲突</a></li>
				<li class="menuItem"><a href="add.html">添加客户</a></li>
				<li class="menuItem"><a href="serve.html">服务中签约客户</a></li>
				<li class="menuItem"><a href="noserve.html">未签约客户</a></li>
				<li class="menuItem"><a href="see.html">公海客户</a></li>
				<li class="menuItem"><a href="visit.html">拜访查询</a></li>
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
				<li class="menuItem"><a href="../system/employee.html">员工设置</a></li>
				<li class="menuItem"><a href="../system/else.html">其他设置</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="pageHead">
				<table>
			        <tr>
			            <th width="8"><img src="../..//images/c_l.gif" height="31" width="8"/></th>
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 拜访记录</th>
			            <th width="9"><img src="../..//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
				<table class="mytable">
					<tr>
						<th>序号</th>
						<th>拜访日期</th>
						<th>客户名称</th>
						<th>成熟度</th>
						<th>客户专员</th>
						<th>拜访方式</th>
						<th>客户联系人</th>
					</tr>
					<tr>
						<td>1</td>
						<td>2012-1-1</td>
						<td>xxx有限公司</td>
						<td>★</td>
						<td>业务员A</td>
						<td>上门拜访</td>
						<td>张三</td>
					</tr>
					<tr>
						<td>2</td>
						<td>2012-2-1</td>
						<td>xxx有限公司</td>
						<td>★</td>
						<td>业务员A</td>
						<td>上门拜访</td>
						<td>张三</td>
					</tr>
					<tr>
						<td>3</td>
						<td>2012-3-1</td>
						<td>xxx有限公司</td>
						<td>★</td>
						<td>业务员A</td>
						<td>上门拜访</td>
						<td>张三</td>
					</tr>
					<tr>
						<td>4</td>
						<td>2012-4-1</td>
						<td>xxx有限公司</td>
						<td>★</td>
						<td>业务员A</td>
						<td>上门拜访</td>
						<td>张三</td>
					</tr>
					<tr>
						<td>5</td>
						<td>2012-5-1</td>
						<td>xxx有限公司</td>
						<td>★</td>
						<td>业务员A</td>
						<td>上门拜访</td>
						<td>张三</td>
					</tr>
					<tr>
						<td>6</td>
						<td>2012-6-1</td>
						<td>xxx有限公司</td>
						<td>★</td>
						<td>业务员A</td>
						<td>上门拜访</td>
						<td>张三</td>
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