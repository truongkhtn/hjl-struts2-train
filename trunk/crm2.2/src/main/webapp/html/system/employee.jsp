<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>员工设置</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<link rel="stylesheet" type="text/css" href="../../css/customer.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../../js/jquery.jstree.js"></script>
<script type="text/javascript">
	$(function () {
		$(".treeDiv")
			.jstree({ "plugins" : ["themes","html_data","ui"] })
			// 1) if using the UI plugin bind to select_node
			.bind("select_node.jstree", function (event, data) { 
				// `data.rslt.obj` is the jquery extended node that was clicked
				alert(data.rslt.obj.attr("id"));
			})
			// 2) if not using the UI plugin - the Anchor tags work as expected
			//    so if the anchor has a HREF attirbute - the page will be changed
			//    you can actually prevent the default, etc (normal jquery usage)
			//.delegate("a", "click", function (event, data) { event.preventDefault(); })
	});
</script>
<style type="text/css">
	.treeGridDiv{
		width: 98%;
		height: 80%;
		float: left;
	}
	.treeDiv{
		width: 150px;
		height: 100%;
		float: left;
	}
	.gridDiv{
		position:absolute;
		margin-left:160px;
		width:600px;
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
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 员工设置</th>
			            <th width="9"><img src="../..//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
				<table class="mytable">
					<tr>
						<th>员工姓名</th>
						<td>
							<input type="text">
							<input id="btnSearch" type="button" class="mybutton" value="查询">
							<input type="button" class="mybutton pickCustomer" value="新增用户" 
					    		onclick="javascript:location.href='employeeEdit.html'"> 
						</td>
					</tr>
				</table>
				<div class="treeGridDiv">
					<div class="treeDiv">
						<ul>
							<li id="dept_1" class="jstree-open">
								<a href="#">总经理室</a>
								<ul>
									<li id="dept_2">
										<a href="#">财务部</a>
									</li>
									<li id="dept_3">
										<a href="#">行政部</a>
									</li>
									<li id="dept_4" class="jstree-open">
										<a href="#">营销部</a>
										<ul>
											<li id="dept_6"><a href="#">营销一部</a></li>
											<li id="dept_7"><a href="#">营销二部</a></li>
											<li id="dept_8"><a href="#">营销三部</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li id="dept_5">
								<a href="#">后勤部</a>
							</li>
						</ul>
					</div>
					<div class="gridDiv">
						<table class="mytable resultTable">
							<tr>
								<th style="width: 40px">排序</th>
								<th style="width: 60px">姓名</th>
								<th style="width: 60px">登陆账号</th>
								<th style="width: 60px">账号状态</th>
								<th style="width: 60px">所属部门</th>
								<th style="width: 60px">客户上限</th>
								<th style="width: 60px">操作</th>
							</tr>
							<tr>
								<td>1</td>
								<td>
									<a href="employeeInfo.html">业务员A</a>
								</td>
								<td>user01</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>2</td>
								<td>
									<a href="employeeInfo.html">业务员B</a>
								</td>
								<td>user02</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>3</td>
								<td>
									<a href="employeeInfo.html">业务员A</a>
								</td>
								<td>user01</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>4</td>
								<td>
									<a href="employeeInfo.html">业务员B</a>
								</td>
								<td>user02</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>5</td>
								<td>
									<a href="employeeInfo.html">业务员A</a>
								</td>
								<td>user01</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>6</td>
								<td>
									<a href="employeeInfo.html">业务员B</a>
								</td>
								<td>user02</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>7</td>
								<td>
									<a href="employeeInfo.html">业务员A</a>
								</td>
								<td>user01</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>8</td>
								<td>
									<a href="employeeInfo.html">业务员B</a>
								</td>
								<td>user02</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>9</td>
								<td>
									<a href="employeeInfo.html">业务员A</a>
								</td>
								<td>user01</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
							<tr>
								<td>10</td>
								<td>
									<a href="employeeInfo.html">业务员B</a>
								</td>
								<td>user02</td>
								<td>启用</td>
								<td>营销部</td>
								<td>50</td>
								<td>
									<a href="employeeEdit.html">编辑</a>
								</td>
							</tr>
						</table>
						<div class="pager-container">
							<ul class="pager">
							    <li class="pageInfo">共5页，当前为第1页</li>
						        <li class="firstPage"><a href='#'>首页</a></li>
						        <li class="prePage"><a href='#'>上一页</a></li>
						        <li class="nextPage"><a href='#'>下一页</a></li>
						        <li class="lastPage"><a href='#'>末页</a></li>
							</ul>
						</div>
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