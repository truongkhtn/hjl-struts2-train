<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>客户冲突</title>
<link rel="stylesheet" type="text/css" href="${path}/css/index.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/public.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/customer.css"/>
<script type="text/javascript" src="${path}/js/jquery-1.7.2.js"></script>
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
				<li class="menuItem"><a href="conflict.jsp">客户冲突</a></li>
				<li class="menuItem"><a href="add.jsp">添加客户</a></li>
				<li class="menuItem"><a href="serve.jsp">服务中签约客户</a></li>
				<li class="menuItem"><a href="noserve.jsp">未签约客户</a></li>
				<li class="menuItem"><a href="see.jsp">公海客户</a></li>
				<li class="menuItem"><a href="visit.jsp">拜访查询</a></li>
			</ul>
			<h2 id="menu2" class="menuTitle">合同管理</h2>
			<ul id="menu2_ul">
				<li class="menuItem"><a href="../contract/templateList.jsp">合同模版</a></li>
				<li class="menuItem"><a href="../contract/contractCreate.jsp">新增合同</a></li>
				<li class="menuItem"><a href="../contract/contractValid.jsp">有效合同查询</a></li>
				<li class="menuItem"><a href="../contract/contractInvalid.jsp">无效合同查询</a></li>
				<li class="menuItem"><a href="../contract/paymentReceivable.jsp">应收款查询</a></li>
				<li class="menuItem"><a href="../contract/paymentReceived.jsp">到款查询</a></li>
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
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 客户冲突</th>
			            <th width="9"><img src="${path}//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<div class="pageBody">
			   <form action="${path}/customer/find.action" method="post">
				<table class="mytable">
					<tr>
						<th>客户名称</th>
						<td>
							<s:textfield name="customer.name"/>
						</td>
						<th>客户地址</th>
						<td>
							<s:textfield name="customer.address"/>
						</td>
					</tr>
					<tr>
						<th>固定电话</th>
						<td>
							<s:textfield name="customer.contractor.phone"/>
						</td>
						<th>手机</th>
						<td>
							<s:textfield name="customer.contractor.mobilePhone" />
						</td>
					</tr>
					<tr>
						<th>主联系人</th>
						<td>
							<s:textfield name="customer.contractor.name"/>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<div class="buttonBar">
								<input id="btnSearch" type="submit" class="mybutton" value="查询">
								<input id="btnReset" type="button" class="mybutton" value="重置">
							</div>
						</td>
					</tr>
				</table>
			</form>
				<table class="mytable resultTable">
					<tr>
						<th style="width:30px">序号</th>
						<th style="width:70px">创建时间</th>
						<th>客户名称</th>
						<th style="width:70px">主联系人</th>
						<th>客户地址</th>
						<th style="width:70px">客户专员</th>
						<th style="width:70px">操作</th>
					</tr>
					<s:iterator value="customerList" var="customer" status="stat">
					<tr>
						<td><s:property value="#stat.getCount()"/></td>
						<td><s:property value="#customer.createDate"/> </td>
						<td><a href="info.jsp"><s:property value="#customer.name"/> </a></td>
						<td><s:property value="#customer.contractor.name"/></td>
						<td><s:property value="#customer.contractor.address"/></td>
						<td><s:property value="#customer.user.realName"/></td>
						<td>
							<a href="history.jsp">拜访记录</a>
							<a href="contactList.jsp">联系人</a>
						</td>
					</tr>
					</s:iterator>					
				</table>
				<div class="pager-container">
					<ul class="pager">
					    <li class="pageInfo">共<s:property value="page.pageCount"/>页，当前为第<s:property value="page.currentPage"/>页</li>
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