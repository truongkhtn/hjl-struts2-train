<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>其他设置</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<style type="text/css">
	.pageBody{
		
	}
	.else1{
		height:120px;
		width: 100%;
	}
	.else2{
		height:250px;
		width: 100%;
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
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 其他设置</th>
			            <th width="9"><img src="../..//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
				<div class="else1">
					<table class="mytable" border="0">
						<caption>客户公海设置</caption>
						<tr>
							<th>自动归还公海</th>
							<td >
								启用<input type="radio" name="autoToSee" checked="checked">
								禁用<input type="radio" name="autoToSee">
							</td>
						</tr>
						<tr>
							<th>
								持有最大天数
							</th>
							<td>
								<input type="text" value="30">
							</td>
						</tr>
					</table>
					<div class="buttonBar">
						<input id="btnSave" type="button" class="mybutton" value="保存">
					</div>
				</div>
				<div class="else2">
					<table class="mytable" border="0">
						<caption>有效拜访设置</caption>
						<tr>
							<th>拜访方式</th>
							<th>是否有效拜访</th>
						</tr>
						<tr>
							<td>上门拜访</td>
							<td>
								有效<input type="radio" name="type1" checked="checked">
								无效<input type="radio" name="type1">
							</td>
						</tr>
						<tr>
							<td>电话拜访</td>
							<td>
								有效<input type="radio" name="type2" checked="checked">
								无效<input type="radio" name="type2">
							</td>
						</tr>
						<tr>
							<td>邮件</td>
							<td>
								有效<input type="radio" name="type3">
								无效<input type="radio" name="type3" checked="checked">
							</td>
						</tr>
						<tr>
							<td>传真</td>
							<td>
								有效<input type="radio" name="type4">
								无效<input type="radio" name="type4" checked="checked">
							</td>
						</tr>
						<tr>
							<td>短信</td>
							<td>
								有效<input type="radio" name="type5">
								无效<input type="radio" name="type5" checked="checked">
							</td>
						</tr>
						<tr>
							<td>客户上门</td>
							<td>
								有效<input type="radio" name="type6" checked="checked">
								无效<input type="radio" name="type6">
							</td>
						</tr>
					</table>
					<div class="buttonBar">
						<input id="btnSave" type="button" class="mybutton" value="保存">
					</div>
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