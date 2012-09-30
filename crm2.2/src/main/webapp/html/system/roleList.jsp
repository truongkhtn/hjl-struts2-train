<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>角色列表</title>
<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
<link rel="stylesheet" type="text/css" href="../../css/public.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<style type="text/css">
	.mytable{
		margin-top: 20px;
	}
	.mytable td{
		text-align: center;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#btnClose").click(function(){
			window.close();
		});
		$("#btnConfirm").click(function(){
			var parentInput = dialogArguments;
			//TODO...根据checkbox选项读取值
			parentInput.getElementById("roleInput").value = "业务员,业务主管";
			//TODO...设置隐藏域 owner ids
			window.close();
		});
		
	});
</script>
</head>
<body>	
<div class="pageBody">
	<table class="mytable">
		<tr>
			<th style="width: 30px"></th>
			<th style="width: 70px">角色</th>
			<th style="width: 180px">描述</th>
		</tr>
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>管理员</td>
			<td>系统所有功能</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>业务员</td>
			<td>【客户管理】</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>业务经理</td>
			<td>【客户管理】、【报表管理】</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>财务</td>
			<td>【合同管理】</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>行政</td>
			<td>【系统设置】</td>
		</tr>
	</table>	
	<div class="buttonBar">
		<input id="btnConfirm" class="mybutton" type="button" value="确定"/>
		<input id="btnClose" class="mybutton" type="button" value="关闭"/>
	</div>				
</div>
</body>
</html>