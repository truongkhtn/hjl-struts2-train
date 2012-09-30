<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>服务中签约客户</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<link rel="stylesheet" type="text/css" href="../../css/customer.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#chooseOwner").click(function(){
			var config="resizable:no;center:yes;dialogWidth:300px;dialogHeight:200px;dialogTop:200px;dialogLeft:150px";
			showModalDialog("ownerList.html" , document ,config);
		});
	});
</script>
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
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 服务中签约客户</th>
			            <th width="9"><img src="../..//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
				<table class="mytable">
					<tr>
						<th>客户名称</th>
						<td>
							<input id="custName" type="text">
						</td>
						<th>客户来源</th>
						<td>
							<select>
								<option>==请选择==</option>
								<option>陌拜</option>
								<option>网络搜索</option>
								<option>黄页</option>
								<option>转介绍</option>
								<option>上门</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>客户地址</th>
						<td>
							<input type="text">
						</td>
						<th>客户等级</th>
						<td>
							<select>
								<option>==请选择==</option>
								<option>★</option>
								<option>★★</option>
								<option>★★★</option>
								<option>★★★★</option>
								<option>★★★★★</option>
							</select>
						</td>
					</tr>
					<tr>
						<th><a id="chooseOwner" href="#">选择客户专员</a></th>
						<td>
							<input id="ownerInput" type="text">
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<div class="buttonBar">
								<input id="btnSearch" type="button" class="mybutton" value="查询">
								<input id="btnReset" type="button" class="mybutton" value="重置">
							</div>
						</td>
					</tr>
				</table>
				<table class="mytable resultTable">
					<tr>
						<th style="width:30px">序号</th>
						<th>客户名称</th>
						<th style="width:60px">主联系人</th>
						<th>客户地址</th>
						<th style="width:60px">客户专员</th>
						<th style="width:70px">操作</th>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>张三</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员A</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>李四</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员B</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>王五</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员C</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>张三</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员A</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>5</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>李四</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员B</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>6</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>王五</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员C</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>7</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>张三</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员A</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>8</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>李四</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员B</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>9</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>王五</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员C</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
						</td>
					</tr>
					<tr>
						<td>10</td>
						<td><a href="info2.html">XXX有限公司</a></td>
						<td>王五</td>
						<td>xx大街xx大道xx号</td>
						<td>业务员C</td>
						<td>
							<a href="history2.html">拜访记录</a>
							<a href="contactList_2.html">联系人</a>
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