<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoshouxinxihsgb" scope="page" class="com.bean.XiaoshouxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoshouxinxi.xls");
%>
<html>
  <head>
    <title>������Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoshouxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>������</td>    <td align='center'>���</td>    <td align='center'>���</td>    <td align='center'>����</td>    <td align='center'>�۸�</td>    <td align='center'>״̬</td>    <td align='center'>��������</td>    <td align='center'>�ܽ��</td>    <td align='center'>���</td>    <td align='center'>�ջ���ַ</td>    <td align='center'>�绰</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=xiaoshouxinxihsgb.getAllXiaoshouxinxi(14);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.dingdanhao}</td>    <td>${u.bianhao}</td>    <td>${u.leibie}</td>    <td>${u.mingcheng}</td>    <td>${u.jiage}</td>    <td>${u.zhuangtai}</td>    <td>${u.goumaishuliang}</td>    <td>${u.zongjine}</td>    <td>${u.maijia}</td>    <td>${u.shouhuodizhi}</td>    <td>${u.dianhua}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

