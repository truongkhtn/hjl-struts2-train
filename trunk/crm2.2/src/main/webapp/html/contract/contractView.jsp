<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>合同信息</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<link rel="stylesheet" type="text/css" href="../../css/customerAdd.css"/>
<link rel="stylesheet" type="text/css" href="../../css/jquery-ui.css" />
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../../js/jquery-ui.js"></script>
<script type="text/javascript" src="../../js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		//日期控件
        $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
        $.datepicker.setDefaults({
            showOn: "button",
            buttonImage: "../../images/calendar.png",
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
				<li class="menuItem"><a href="templateList.html">合同模版</a></li>
				<li class="menuItem"><a href="contractCreate.html">新增合同</a></li>
				<li class="menuItem"><a href="contractValid.html">有效合同查询</a></li>
				<li class="menuItem"><a href="contractInvalid.html">无效合同查询</a></li>
				<li class="menuItem"><a href="paymentReceivable.html">应收款查询</a></li>
				<li class="menuItem"><a href="paymentReceived.html">到款查询</a></li>
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
			            <th align="left" class="title_area">当前位置：客户管理 &gt; 合同信息</th>
			            <th width="9"><img src="../..//images/c_r.gif" height="31" width="9"></th>
			        </tr>
		    	</table>
			</div>
			<form id="customerSaveForm" method="post" action="contractCreateSuccess.html">
				<div class="pageBody">
					<div class="customerDiv">
						<table class="mytable" border="0">
								<caption>基本信息</caption>
								<tr>
									<th>合同类型</th>
									<td>合同模板1</td>
								</tr>
								<tr>
									<th>公司合同号</th>
									<td>ORD-201209001</td>
									<th>客户订单号</th>
									<td>AXY-201209023</td>
								</tr>
								<tr>
									<th>客户/公司名称</th>
									<td>XXX有限公司</td>
									<th>签约日期</th>
									<td>2012-9-1</td>
								</tr>
								<tr>
									<th>合同金额</th>
									<td>500000</td>
									<th>合约开始日期</th>
									<td>2012-9-2</td>
								</tr>
								<tr>
									<th>签约人</th>
									<td>业务员B</td>
									<th>合约结束日期</th>
									<td>2012-9-3</td>
								</tr>
								<tr>
									<th>备注</th>
									<td colspan="3">备注信息</td>
								</tr>
							</table>											
					</div>
					<div>
						<table class="mytable" border="0">
								<caption>付款计划</caption>
								<tr>
									<th style="width:30px;"></th>
									<th>费用名称</th>
									<th>金额</th>
									<th>计划到款日期</th>
									<th>备注</th>
								</tr>
								<tr>
									<td style="text-align: center;">1</td>
									<td style="text-align: center;">首付款</td>
									<td style="width:50px;text-align: center;">
										250000
									</td>
									<td style="width:120px;text-align: center;">
										2012-9-5
									</td>
									<td></td>
								</tr>
								<tr>
									<td style="text-align: center;">2</td>
									<td style="text-align: center;">余款</td>
									<td style="width:50px;text-align: center;">
										50000
									</td>
									<td style="width:120px;text-align: center;">
										2012-9-6
									</td>
									<td></td>
								</tr>
								<tr>
									<td style="text-align: center;">3</td>
									<td style="text-align: center;">尾款</td>
									<td style="width:50px;text-align: center;">
										150000
									</td>
									<td style="width:120px;text-align: center;">
										2012-9-8
									</td>
									<td></td>
								</tr>
								
						</table>
					</div>
					<div>
						<table class="mytable" border="0">
							<caption>自定义属性</caption>
							<tr>
								<th>套餐类型</th>
								<td>B</td>
								<th>备注留言</th>
								<td>客户需要上门培训</td>
							</tr>
							<tr>
								<th>测试2</th>
								<td>
									产品A<input type="checkbox" value="A" checked="checked" disabled="disabled">
									产品B<input type="checkbox" value="B" checked="checked" disabled="disabled">
									产品C<input type="checkbox" value="C" disabled="disabled">
								</td>
							</tr>
						</table>
					</div>
					<div class="buttonBar">
						<input type="button" class="mybutton" value="返回" onclick="javascript:history.back();">
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