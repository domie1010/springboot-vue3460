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
		<TITLE>添加退货记录</TITLE>
	    

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
	document.location.href="tuihuojilu_add.jsp?id=<%=id%>";
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
			<form action="addTuihuojilu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加退货记录</td>
						</tr>
						<tr ><td width="200">订单号：</td><td><input name='dingdanhao' type='text' id='dingdanhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.dingdanhao.value='<%=connDbBean.readzd("xiaoshouxinxi","dingdanhao","id",request.getParameter("id"))%>';document.form1.dingdanhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.bianhao.value='<%=connDbBean.readzd("xiaoshouxinxi","bianhao","id",request.getParameter("id"))%>';document.form1.bianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.leibie.value='<%=connDbBean.readzd("xiaoshouxinxi","leibie","id",request.getParameter("id"))%>';document.form1.leibie.setAttribute("readOnly",'true');</script>		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.mingcheng.value='<%=connDbBean.readzd("xiaoshouxinxi","mingcheng","id",request.getParameter("id"))%>';document.form1.mingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiage.value='<%=connDbBean.readzd("xiaoshouxinxi","jiage","id",request.getParameter("id"))%>';document.form1.jiage.setAttribute("readOnly",'true');</script>		<tr ><td width="200">购买数量：</td><td><input name='goumaishuliang' type='text' id='goumaishuliang' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.goumaishuliang.value='<%=connDbBean.readzd("xiaoshouxinxi","goumaishuliang","id",request.getParameter("id"))%>';document.form1.goumaishuliang.setAttribute("readOnly",'true');</script>		<tr ><td width="200">总金额：</td><td><input name='zongjine' type='text' id='zongjine' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zongjine.value='<%=connDbBean.readzd("xiaoshouxinxi","zongjine","id",request.getParameter("id"))%>';document.form1.zongjine.setAttribute("readOnly",'true');</script>		<tr ><td width="200">买家：</td><td><input name='maijia' type='text' id='maijia' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.maijia.value='<%=connDbBean.readzd("xiaoshouxinxi","maijia","id",request.getParameter("id"))%>';document.form1.maijia.setAttribute("readOnly",'true');</script>		<tr ><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shouhuodizhi.value='<%=connDbBean.readzd("xiaoshouxinxi","shouhuodizhi","id",request.getParameter("id"))%>';document.form1.shouhuodizhi.setAttribute("readOnly",'true');</script>		<tr 0><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.dianhua.value='<%=connDbBean.readzd("xiaoshouxinxi","dianhua","id",request.getParameter("id"))%>';document.form1.dianhua.setAttribute("readOnly",'true');</script>		<tr 1><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






