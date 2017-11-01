<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<%
				String code = request.getParameter("code");
				String status = request.getParameter("state");
				if (code != null && status != null) {
					request.getRequestDispatcher("qq/login").forward(request, response);
				}
%>
<title>系统登录 - 超市订单管理系统</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css" />
</head>
<body class="login_bg">
	<section class="loginBox">
		<header class="loginHeader">
			<h1>超市订单管理系统</h1>
		</header>
		<section class="loginCont">
			<form class="loginForm"
				action="${pageContext.request.contextPath }/user/login.jhtml"
				name="actionForm" id="actionForm" method="post">
				<div class="info">${error }</div>
				<div class="inputbox">
					<label for="user">用户名：</label> <input type="text"
						class="input-text" id="userCode" name="userCode"
						placeholder="请输入用户名" required />
				</div>
				<div class="inputbox">
					<label for="mima">密码：</label> <input type="password"
						id="userPassword" name="userPassword" placeholder="请输入密码" required />
				</div>
				<div class="subBtn">

					<input type="submit" value="登录" /> <input type="reset" value="重置" />
				</div>
			</form>
			<a href="/qq/do_login.jhtml"><img
				src="../../../resources/images/QQ.png" width="80" height="80" /></a>
		</section>
	</section>
</body>
</html>
