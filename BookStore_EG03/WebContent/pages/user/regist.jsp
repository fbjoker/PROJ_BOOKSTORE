<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<!-- 引入base页面 -->
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<!-- 使用js 利用正则在注册数据提交之前对 注册信息做一个前端验证 -->
<script type="text/javascript">
	$(function(){
		$("#sub_btn").click(function(){
			//获取用户输入的注册参数
			var username = $("input[name='username']").val();
			var password = $("input[name='password']").val();
			var repwd = $("input[name='repwd']").val();
			var email = $("input[name='email']").val();
			//使用正则表达式验证 字符串是否符合要求
			//  /正则表达式/ 创建一个正则对象，正则对象可以通过test(str) 验证传入的字符串是否符合正则表达式的规范 
			//为每个不同的字符串创建对应的一个正则对象
			var nameReg =  /^[a-z0-9_-]{3,16}$/;
			var flag = nameReg.test(username);//如果字符串满足要求返回true
			if(!flag){
				//账号格式不满足要求
				alert("请输入正确的用户名！！");
				return false;//如果账号格式错误，取消提交按钮的默认行为
			}
			//创建验证密码的正则对象
			var pwdReg = /^[a-z0-9_-]{6,18}$/;
			if(!pwdReg.test(password)){
				//密码格式错误
				alert("请输入正确格式的密码！！！");
				return false;
			}
			//重复密码必须和第一次输入的密码一样
			if(password!=repwd){
				alert("两次密码不一致！！！");
				return false;
			}
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!emailReg.test(email)){
				alert("邮箱格式错误！！！");
				return false;
			}
		});
	});
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								
								
								<%
								String username=request.getParameter("username");
								String password=request.getParameter("password");
								String repwd=request.getParameter("repwd");
								String email=request.getParameter("email");
								
								
								%>
								
								<span class="errorMsg"><%=request.getAttribute("errmsg")==null?"":request.getAttribute("errmsg") %></span>
							</div>
							<div class="form">
							<!-- 
								浏览器缓存：
									如果浏览器中发起的get请求地址+参数之前已经访问过，再次使用时浏览器会认为是重复提交的请求，直接使用浏览器缓存，不会向服务器发起请求
								
							 -->
								<form action="UserServlet" method="post">
									<input type="hidden" name="type" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="<%=username==null?"":username %>" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" value="<%=email==null?"":email %>" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>