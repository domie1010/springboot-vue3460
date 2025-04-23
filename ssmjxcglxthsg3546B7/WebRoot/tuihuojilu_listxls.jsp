<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="tuihuojiluhsgb" scope="page" class="com.bean.TuihuojiluBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=tuihuojilu.xls");
%>
<html>
  <head>
    <title>退货记录</title>
  </head>

  <body >
 <%
			String sql="select * from tuihuojilu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>订单号</td>    <td align='center'>编号</td>    <td align='center'>类别</td>    <td align='center'>名称</td>    <td align='center'>价格</td>    <td align='center'>购买数量</td>    <td align='center'>总金额</td>    <td align='center'>买家</td>    <td align='center'>收货地址</td>    <td align='center'>电话</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=tuihuojiluhsgb.getAllTuihuojilu(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.dingdanhao}</td>    <td>${u.bianhao}</td>    <td>${u.leibie}</td>    <td>${u.mingcheng}</td>    <td>${u.jiage}</td>    <td>${u.goumaishuliang}</td>    <td>${u.zongjine}</td>    <td>${u.maijia}</td>    <td>${u.shouhuodizhi}</td>    <td>${u.dianhua}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

