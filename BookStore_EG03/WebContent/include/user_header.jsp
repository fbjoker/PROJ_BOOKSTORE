<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 用户未登录时应该显示的状态栏 -->
    <!-- user_header页面会被引入的其他页面中使用   相对路径也需要参考页面中的base标签 -->
<div>
	<a href="pages/user/login.jsp">登录</a> | 
	<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
	<a href="pages/cart/cart.jsp">购物车</a>
	<a href="pages/manager/manager.jsp">后台管理</a>
	<a href="index.jsp">返回</a>
</div>
	<!-- 用户已登录应该显示的状态栏   两个状态栏互斥-->
<!-- <div>
	<span>欢迎<span class="um_span">孙悟空</span>光临尚硅谷书城</span>
	<a href="cart.html">购物车</a>
	<a href="../order/order.html">我的订单</a>
	<a href="../../index.html">注销</a>&nbsp;&nbsp;
	<a href="../../index.html">返回</a>
</div> -->