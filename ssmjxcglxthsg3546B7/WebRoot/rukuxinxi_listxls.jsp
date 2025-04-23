<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="rukuxinxihsgb" scope="page" class="com.bean.RukuxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=rukuxinxi.xls");
%>
<html>
  <head>
    <title>入库信息</title>
  </head>

  <body >
 <%
			String sql="select * from rukuxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>类别</td>    <td align='center'>名称</td>    <td align='center'>库存</td>    <td align='center'>价格</td>    <td align='center'>入库价格</td>    <td align='center'>入库数量</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=rukuxinxihsgb.getAllRukuxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.leibie}</td>    <td>${u.mingcheng}</td>    <td>${u.kucun}</td>    <td>${u.jiage}</td>    <td>${u.rukujiage}</td>    <td>${u.rukushuliang}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

