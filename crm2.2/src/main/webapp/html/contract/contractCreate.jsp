<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>新增合同</title>
<link rel="stylesheet" type="text/css" href="${path}/css/index.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/public.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/customerAdd.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.css" />
<script type="text/javascript" src="${path}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${path}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${path}/js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		//日期控件
        $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
        $.datepicker.setDefaults({
            showOn: "button",
            buttonImage: "${path}/images/calendar.png",
            buttonImageOnly: true
        });
        $("#signDate").datepicker();
        $("#startSrvDate").datepicker();
        $("#endSrvDate").datepicker();
        $(".myDatePicker").datepicker();
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
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 新增合同</th>
			            <th width="9"><img src="${path}//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<form id="customerSaveForm" method="post" action="contractCreateSuccess.jsp">
				<div class="pageBody">
					<div class="customerDiv">
						<table class="mytable" border="0">
								<caption>基本信息</caption>
								<tr>
									<th>合同类型</th>
									<td>
										<select>
											<option>==请选择==</option>			
											<option>合同模板1</option>			
											<option>合同模板2</option>			
											<option>合同模板3</option>			
										</select>
										<span class="required">*</span>
									</td>
								</tr>
								<tr>
									<th>公司合同号</th>
									<td >
										<input type="text" size="20">
										<span class="required">*</span>
									</td>
									<th>
										客户订单号
									</th>
									<td>
										<input type="text" size="20">
									</td>
								</tr>
								<tr>
									<th>客户/公司名称</th>
									<td>
										<select>
											<option></option>
											<option>使用 Ajax获得列表</option>
										</select>
										<span class="required">*</span>
									</td>
									<th>
										签约日期
									</th>
									<td>
										<input id="signDate" type="text" size="20">
									</td>
								</tr>
								<tr>
									<th>合同金额</th>
									<td>
										<input type="text" size="20">
										<span class="required">*</span>
									</td>
									<th>
										合约开始日期
									</th>
									<td>
										<input id="startSrvDate" type="text" size="20">
									</td>
								</tr>
								<tr>
									<th>签约人</th>
									<td>
										<select>
											<option>==请选择==</option>
											<option>业务员A</option>
											<option>业务员B</option>
											<option>业务员C</option>
										</select>
										<span class="required">*</span>
									</td>
									<th>
										合约结束日期
									</th>
									<td>
										<input id="endSrvDate" type="text" size="20">
									</td>
								</tr>
								<tr>
									<th>备注</th>
									<td colspan="3">
										<textarea rows="2" cols="48"></textarea>
									</td>
								</tr>
							</table>											
					</div>
					<div>
						<table class="mytable" border="0">
								<caption>
									付款计划
									<img src="${path}/images/add.png" 
										onclick="javascript:alert('此处实现动态添加款项明细')">
								</caption>
								<tr>
									<th style="width:30px;"></th>
									<th>费用名称</th>
									<th>金额</th>
									<th>计划到款日期</th>
									<th>备注</th>
								</tr>
								<tr>
									<td style="text-align: center;">1</td>
									<td>
										<select>
											<option>首付款</option>
											<option>余款</option>
											<option>尾款</option>
										</select>
									</td>
									<td style="width:50px;text-align: center;">
										<input type="text" style="text-align:right;" size="12">
									</td>
									<td style="width:120px;text-align: center;">
										<input class="myDatePicker" type="text" size="12">
									</td>
									<td><input type="text"></td>
								</tr>
								
						</table>
					</div>
					<div>
						<table class="mytable" border="0">
							<caption>自定义属性</caption>
							<tr>
								<th>套餐类型</th>
								<td>
									<select>
										<option>A</option>
										<option>B</option>
										<option>C</option>
									</select>
								</td>
								<th>备注留言</th>
								<td>
									<input type="text">
								</td>
							</tr>
							<tr>
								<th>测试2</th>
								<td>
									产品A<input type="checkbox" value="A">
									产品B<input type="checkbox" value="B">
									产品C<input type="checkbox" value="C">
								</td>
							</tr>
						</table>
					</div>
					<div class="buttonBar">
						<input id="btnReset" type="button" class="mybutton" value="重置">
						<input type="button" class="mybutton" value="返回" onclick="javascript:history.back();">
						<input id="btnSave" type="submit" class="mybutton" value="保存">
					</div>
				</div>
			</form>
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