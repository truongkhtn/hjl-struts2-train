<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>系统登录 - 客户关系管理系统</title>
<link rel="stylesheet" type="text/css" href="${path}/css/login.css">
</head>
<body>
<div class="main">
		<table class="midTable">
			<tr>
				<td>
					<div>
						<h1>客户关系管理系统 v2.0</h1>
						<img src="${path}/images/login2.jpg" >
						<form method="post" action="${path}/login.action">
							<span>用戶名:</span>							
							<s:textfield name="user.username" value="jack"/>
							&nbsp;&nbsp;
							<span>密码:</span>
							<s:textfield name="user.password" value="123"/>
							<input type="image" src="${path}/images/submit.jpg">							
						</form>
					</div>
				</td>
			</tr>
		</table>
</div>
</body>
</html>