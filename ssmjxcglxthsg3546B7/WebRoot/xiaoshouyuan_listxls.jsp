<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoshouyuanhsgb" scope="page" class="com.bean.XiaoshouyuanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoshouyuan.xls");
%>
<html>
  <head>
    <title>销售员</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoshouyuan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>密码</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td align='center'>年龄</td>    <td align='center'>工种</td>    <td align='center'>入职时间</td>    <td align='center'>备注</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiaoshouyuanhsgb.getAllXiaoshouyuan(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.nianling}</td>    <td>${u.gongzhong}</td>    <td>${u.ruzhishijian}</td>    <td>${u.beizhu}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

