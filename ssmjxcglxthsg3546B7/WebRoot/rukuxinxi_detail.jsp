<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>入库信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  入库信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${rukuxinxi.bianhao}</td>     <td width='11%'>类别：</td><td width='39%'>${rukuxinxi.leibie}</td></tr><tr>     <td width='11%'>名称：</td><td width='39%'>${rukuxinxi.mingcheng}</td>     <td width='11%'>库存：</td><td width='39%'>${rukuxinxi.kucun}</td></tr><tr>     <td width='11%'>价格：</td><td width='39%'>${rukuxinxi.jiage}</td>     <td width='11%'>入库价格：</td><td width='39%'>${rukuxinxi.rukujiage}</td></tr><tr>     <td width='11%'>入库数量：</td><td width='39%'>${rukuxinxi.rukushuliang}</td>     <td width='11%'>备注：</td><td width='39%'>${rukuxinxi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

