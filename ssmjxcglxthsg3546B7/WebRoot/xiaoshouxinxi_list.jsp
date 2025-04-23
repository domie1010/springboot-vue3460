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
	<TITLE>销售信息查询</TITLE>
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
							<td colspan="17" background="images/table_header.gif">销售信息列表</td>
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
								<form action="xiaoshouxinxiList.do" name="myform" method="post">
									查询   订单号：<input name="dingdanhao" type="text" id="dingdanhao" style='border:solid 1px #000000; color:#666666' size="12" />  编号：<input name="bianhao" type="text" id="bianhao" style='border:solid 1px #000000; color:#666666' size="12" />  类别：<input name="leibie" type="text" id="leibie" style='border:solid 1px #000000; color:#666666' size="12" />  名称：<input name="mingcheng" type="text" id="mingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  价格：<input name="jiage" type="text" id="jiage" style='border:solid 1px #000000; color:#666666' size="12" /> 状态：<select name='zhuangtai' id='zhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="已购买">已购买</option><option value="已退货">已退货</option></select>  购买数量：<input name="goumaishuliang" type="text" id="goumaishuliang" style='border:solid 1px #000000; color:#666666' size="12" />  买家：<input name="maijia" type="text" id="maijia" style='border:solid 1px #000000; color:#666666' size="12" />  电话：<input name="dianhua" type="text" id="dianhua" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>订单号</td>    <td align='center'>编号</td>    <td align='center'>类别</td>    <td align='center'>名称</td>    <td align='center'>价格</td>    <td align='center'>状态</td>    <td align='center'>购买数量</td>    <td align='center'>总金额</td>    <td align='center'>买家</td>    <td align='center'>收货地址</td>    <td align='center'>电话</td>        
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
                             <td>${u.dingdanhao}</td>    <td>${u.bianhao}</td>    <td>${u.leibie}</td>    <td>${u.mingcheng}</td>    <td>${u.jiage}</td>    <td>${u.zhuangtai}</td>    <td>${u.goumaishuliang}</td>    <td>${u.zongjine}</td>    <td>${u.maijia}</td>    <td>${u.shouhuodizhi}</td>    <td>${u.dianhua}</td>        
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateXiaoshouxinxi.do?id=${u.id }">编辑</a>  <a href="deleteXiaoshouxinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="xiaoshouxinxiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from xiaoshouxinxi where 1=1 ";
				if(request.getParameter("dingdanhao")=="" ||request.getParameter("dingdanhao")==null ){}else{String ndingdanhao=new String(request.getParameter("dingdanhao").getBytes("8859_1"));if(ndingdanhao.contains("?")){ndingdanhao=request.getParameter("dingdanhao");}sql=sql+" and dingdanhao like '%"+ndingdanhao+"%'";}if(request.getParameter("bianhao")=="" ||request.getParameter("bianhao")==null ){}else{String nbianhao=new String(request.getParameter("bianhao").getBytes("8859_1"));if(nbianhao.contains("?")){nbianhao=request.getParameter("bianhao");}sql=sql+" and bianhao like '%"+nbianhao+"%'";}if(request.getParameter("leibie")=="" ||request.getParameter("leibie")==null ){}else{String nleibie=new String(request.getParameter("leibie").getBytes("8859_1"));if(nleibie.contains("?")){nleibie=request.getParameter("leibie");}sql=sql+" and leibie like '%"+nleibie+"%'";}if(request.getParameter("mingcheng")=="" ||request.getParameter("mingcheng")==null ){}else{String nmingcheng=new String(request.getParameter("mingcheng").getBytes("8859_1"));if(nmingcheng.contains("?")){nmingcheng=request.getParameter("mingcheng");}sql=sql+" and mingcheng like '%"+nmingcheng+"%'";}if(request.getParameter("jiage")=="" ||request.getParameter("jiage")==null ){}else{String njiage=new String(request.getParameter("jiage").getBytes("8859_1"));if(njiage.contains("?")){njiage=request.getParameter("jiage");}sql=sql+" and jiage like '%"+njiage+"%'";}if(request.getParameter("zhuangtai")=="" ||request.getParameter("zhuangtai")==null ){}else{sql=sql+" and zhuangtai like '%"+request.getParameter("zhuangtai")+"%'";}if(request.getParameter("goumaishuliang")=="" ||request.getParameter("goumaishuliang")==null ){}else{String ngoumaishuliang=new String(request.getParameter("goumaishuliang").getBytes("8859_1"));if(ngoumaishuliang.contains("?")){ngoumaishuliang=request.getParameter("goumaishuliang");}sql=sql+" and goumaishuliang like '%"+ngoumaishuliang+"%'";}if(request.getParameter("maijia")=="" ||request.getParameter("maijia")==null ){}else{String nmaijia=new String(request.getParameter("maijia").getBytes("8859_1"));if(nmaijia.contains("?")){nmaijia=request.getParameter("maijia");}sql=sql+" and maijia like '%"+nmaijia+"%'";}if(request.getParameter("dianhua")=="" ||request.getParameter("dianhua")==null ){}else{String ndianhua=new String(request.getParameter("dianhua").getBytes("8859_1"));if(ndianhua.contains("?")){ndianhua=request.getParameter("dianhua");}sql=sql+" and dianhua like '%"+ndianhua+"%'";}
			sql+=" order by id desc";
double zongjinez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						zongjinez=zongjinez+Float.valueOf(RS_result.getString("zongjine")).floatValue();
						
						
			 }
			%>
		共计总金额:<%=zongjinez%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xiaoshouxinxiList.do?page=1" >首页</a>
             <a href="xiaoshouxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xiaoshouxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="xiaoshouxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
