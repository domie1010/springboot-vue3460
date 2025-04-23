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
		<TITLE>修改销售员</TITLE>
	    
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
	document.location.href="xiaoshouyuan_add.jsp?id=<%=id%>";
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
			<form action="updateXiaoshouyuan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改销售员<input type="hidden" name="id" value="${xiaoshouyuan.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><select name='bianhao' id='bianhao' style='height:20px; border:solid 1px #000000; color:#666666' onChange='gows();'><%=connDbBean.hsggetoption2("yuangongxinxi","bianhao")%></select>&nbsp;*<label id='clabelbianhao' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' style='border:solid 1px #000000; color:#666666' >&nbsp;*<label id='clabelmima' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">年龄：</td><td><input name='nianling' type='text' id='nianling' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">工种：</td><td><input name='gongzhong' type='text' id='gongzhong' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">入职时间：</td><td><input name='ruzhishijian' type='text' id='ruzhishijian' style='border:solid 1px #000000; color:#666666' ></td></tr>		<tr ><td width="200">备注：</td><td><input name='beizhu' type='text' id='beizhu' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${xiaoshouyuan.bianhao}';</script>	<script language="javascript">document.form1.mima.value='${xiaoshouyuan.mima}';</script>	<script language="javascript">document.form1.xingming.value='${xiaoshouyuan.xingming}';</script>	<script language="javascript">document.form1.xingbie.value='${xiaoshouyuan.xingbie}';</script>	<script language="javascript">document.form1.nianling.value='${xiaoshouyuan.nianling}';</script>	<script language="javascript">document.form1.gongzhong.value='${xiaoshouyuan.gongzhong}';</script>	<script language="javascript">document.form1.ruzhishijian.value='${xiaoshouyuan.ruzhishijian}';</script>	<script language="javascript">document.form1.beizhu.value='${xiaoshouyuan.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var bianhaoobj = document.getElementById("bianhao"); if(bianhaoobj.value==""){document.getElementById("clabelbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入编号</font>";return false;}else{document.getElementById("clabelbianhao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
