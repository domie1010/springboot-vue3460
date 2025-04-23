<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="images/assets/css/layui.css">
    <link rel="stylesheet" href="images/assets/css/admin.css">
    <title>管理后台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold">&nbsp;&nbsp;进销存管理系统</i></a>
                </li>
				
            </ul>
			
            <ul class="layui-nav layui-layout-right">
               
				<li class="layui-nav-item">
                    <a href="javascript:;">当前用户:<%=request.getSession().getAttribute("username")%> [<%=request.getSession().getAttribute("cx")%>]</a>
                    <dl class="layui-nav-child">
                        <dd><a onClick="javascript:alert('你自己在这写几句台词吧');" style="cursor:pointer">帮助中心</a></dd>
                        <dd><a href="logout.jsp">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    <img src="images/assets/images/logo.png" alt=""/>
                    <h1>进销存管理系统</h1>
                </div>
				
               <%
	
	if (request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员"))
	{
		%>
		<%@ include file="left.jsp"%>
		<%
	}
	if(request.getSession().getAttribute("cx").equals("仓库管理")  )
	{
		%>
		<%@ include file="left3.jsp"%>
		<%
	}
	
		if(request.getSession().getAttribute("cx").equals("采购员")  )
	{
		%>
		<%@ include file="left2.jsp"%>
		<%
	}
	
			if(request.getSession().getAttribute("cx").equals("销售员")  )
	{
		%>
		<%@ include file="left4.jsp"%>
		<%
	}
	
	%>
            </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>

        <div class="mobile-mask"></div>
    </div>
    <script src="images/assets/layui.js"></script>
    <script src="images/index.js" data-main="home"></script>
</body>
</html>