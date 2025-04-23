<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>退货记录查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">退货记录列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="tuihuojiluList.do" name="myform" method="post">
									查询   订单号：<input name="dingdanhao" type="text" id="dingdanhao" style='border:solid 1px #000000; color:#666666' size="12" />  编号：<input name="bianhao" type="text" id="bianhao" style='border:solid 1px #000000; color:#666666' size="12" />  类别：<input name="leibie" type="text" id="leibie" style='border:solid 1px #000000; color:#666666' size="12" />  名称：<input name="mingcheng" type="text" id="mingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  价格：<input name="jiage" type="text" id="jiage" style='border:solid 1px #000000; color:#666666' size="12" />  购买数量：<input name="goumaishuliang" type="text" id="goumaishuliang" style='border:solid 1px #000000; color:#666666' size="12" />  总金额：<input name="zongjine" type="text" id="zongjine" style='border:solid 1px #000000; color:#666666' size="12" />  买家：<input name="maijia" type="text" id="maijia" style='border:solid 1px #000000; color:#666666' size="12" />  收货地址：<input name="shouhuodizhi" type="text" id="shouhuodizhi" style='border:solid 1px #000000; color:#666666' size="12" />  电话：<input name="dianhua" type="text" id="dianhua" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>订单号</td>    <td align='center'>编号</td>    <td align='center'>类别</td>    <td align='center'>名称</td>    <td align='center'>价格</td>    <td align='center'>购买数量</td>    <td align='center'>总金额</td>    <td align='center'>买家</td>    <td align='center'>收货地址</td>    <td align='center'>电话</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.dingdanhao}</td>    <td>${u.bianhao}</td>    <td>${u.leibie}</td>    <td>${u.mingcheng}</td>    <td>${u.jiage}</td>    <td>${u.goumaishuliang}</td>    <td>${u.zongjine}</td>    <td>${u.maijia}</td>    <td>${u.shouhuodizhi}</td>    <td>${u.dianhua}</td>        
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateTuihuojilu.do?id=${u.id }">编辑</a>  <a href="deleteTuihuojilu.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="tuihuojiluDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="tuihuojiluList.do?page=1" >首页</a>
             <a href="tuihuojiluList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="tuihuojiluList.do?page=${page.page+1 }">下一页</a>
			<a href="tuihuojiluList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
