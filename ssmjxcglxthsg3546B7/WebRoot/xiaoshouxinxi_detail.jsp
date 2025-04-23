<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>销售信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  销售信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单号：</td><td width='39%'>${xiaoshouxinxi.dingdanhao}</td>     <td width='11%'>编号：</td><td width='39%'>${xiaoshouxinxi.bianhao}</td></tr><tr>     <td width='11%'>类别：</td><td width='39%'>${xiaoshouxinxi.leibie}</td>     <td width='11%'>名称：</td><td width='39%'>${xiaoshouxinxi.mingcheng}</td></tr><tr>     <td width='11%'>价格：</td><td width='39%'>${xiaoshouxinxi.jiage}</td>     <td width='11%'>状态：</td><td width='39%'>${xiaoshouxinxi.zhuangtai}</td></tr><tr>     <td width='11%'>购买数量：</td><td width='39%'>${xiaoshouxinxi.goumaishuliang}</td>     <td width='11%'>总金额：</td><td width='39%'>${xiaoshouxinxi.zongjine}</td></tr><tr>     <td width='11%'>买家：</td><td width='39%'>${xiaoshouxinxi.maijia}</td>     <td width='11%'>收货地址：</td><td width='39%'>${xiaoshouxinxi.shouhuodizhi}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${xiaoshouxinxi.dianhua}</td>     <td width='11%'>备注：</td><td width='39%'>${xiaoshouxinxi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

