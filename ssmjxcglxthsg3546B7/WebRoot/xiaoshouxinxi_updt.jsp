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
		<TITLE>修改销售信息</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="xiaoshouxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateXiaoshouxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改销售信息<input type="hidden" name="id" value="${xiaoshouxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">订单号：</td><td><input name='dingdanhao' type='text' id='dingdanhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">状态：</td><td><select name='zhuangtai' id='zhuangtai'><option value="已购买">已购买</option><option value="已退货">已退货</option></select></td></tr>		<tr ><td width="200">购买数量：</td><td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelgoumaishuliang' />必需数字型</td></tr>		<tr ><td width="200">总金额：</td><td><input name='zongjine' type='text' id='zongjine' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		<tr ><td width="200">买家：</td><td><input name='maijia' type='text' id='maijia' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr 0><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr 1><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr 2><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.dingdanhao.value='${xiaoshouxinxi.dingdanhao}';</script>	<script language="javascript">document.form1.bianhao.value='${xiaoshouxinxi.bianhao}';</script>	<script language="javascript">document.form1.leibie.value='${xiaoshouxinxi.leibie}';</script>	<script language="javascript">document.form1.mingcheng.value='${xiaoshouxinxi.mingcheng}';</script>	<script language="javascript">document.form1.jiage.value='${xiaoshouxinxi.jiage}';</script>	<script language="javascript">document.form1.zhuangtai.value='${xiaoshouxinxi.zhuangtai}';</script>	<script language="javascript">document.form1.goumaishuliang.value='${xiaoshouxinxi.goumaishuliang}';</script>	<script language="javascript">document.form1.zongjine.value='${xiaoshouxinxi.zongjine}';</script>	<script language="javascript">document.form1.maijia.value='${xiaoshouxinxi.maijia}';</script>	<script language="javascript">document.form1.shouhuodizhi.value='${xiaoshouxinxi.shouhuodizhi}';</script>	<script language="javascript">document.form1.dianhua.value='${xiaoshouxinxi.dianhua}';</script>	<script language="javascript">document.form1.beizhu.value='${xiaoshouxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	    var zongjinej=1;if(document.getElementById("jiage").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("jiage").value);}if(document.getElementById("goumaishuliang").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("goumaishuliang").value);}document.getElementById("zongjine").value=zongjinej;	


return true;   
}   
popheight=450;
</script>  
