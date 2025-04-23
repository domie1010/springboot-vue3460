package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Xiaoshouxinxi;
import com.server.XiaoshouxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiaoshouxinxiController {
	@Resource
	private XiaoshouxinxiServer xiaoshouxinxiService;


   
	@RequestMapping("addXiaoshouxinxi.do")
	public String addXiaoshouxinxi(HttpServletRequest request,Xiaoshouxinxi xiaoshouxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiaoshouxinxi.setAddtime(time.toString().substring(0, 19));
		xiaoshouxinxiService.add(xiaoshouxinxi);
		String sql="";
		sql="update chanpinxinxi set kucun=kucun-"+xiaoshouxinxi.getGoumaishuliang()+" where bianhao='"+xiaoshouxinxi.getBianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiaoshouxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiaoshouxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiaoshouxinxi.do")
	public String doUpdateXiaoshouxinxi(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi){
		xiaoshouxinxi=xiaoshouxinxiService.getById(id);
		map.put("xiaoshouxinxi", xiaoshouxinxi);
		return "xiaoshouxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xiaoshouxinxiDetail.do")
	public String xiaoshouxinxiDetail(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi){
		xiaoshouxinxi=xiaoshouxinxiService.getById(id);
		map.put("xiaoshouxinxi", xiaoshouxinxi);
		return "xiaoshouxinxi_detail";
	}
//	前台详细
	@RequestMapping("xsxxDetail.do")
	public String xsxxDetail(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi){
		xiaoshouxinxi=xiaoshouxinxiService.getById(id);
		map.put("xiaoshouxinxi", xiaoshouxinxi);
		return "xiaoshouxinxidetail";
	}
//	
	@RequestMapping("updateXiaoshouxinxi.do")
	public String updateXiaoshouxinxi(int id,ModelMap map,Xiaoshouxinxi xiaoshouxinxi,HttpServletRequest request,HttpSession session){
		xiaoshouxinxiService.update(xiaoshouxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiaoshouxinxiList.do";
	}

//	分页查询
	@RequestMapping("xiaoshouxinxiList.do")
	public String xiaoshouxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouxinxi xiaoshouxinxi, String dingdanhao, String bianhao, String leibie, String mingcheng, String jiage, String zhuangtai, String goumaishuliang1,String goumaishuliang2, String zongjine, String maijia, String shouhuodizhi, String dianhua, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(maijia==null||maijia.equals("")){pmap.put("maijia", null);}else{pmap.put("maijia", maijia);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xiaoshouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouxinxi> list=xiaoshouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouxinxi_list";
	}
	
	
	@RequestMapping("xiaoshouxinxiList2.do")
	public String xiaoshouxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouxinxi xiaoshouxinxi, String dingdanhao, String bianhao, String leibie, String mingcheng, String jiage, String zhuangtai, String goumaishuliang1,String goumaishuliang2, String zongjine, String maijia, String shouhuodizhi, String dianhua, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(maijia==null||maijia.equals("")){pmap.put("maijia", null);}else{pmap.put("maijia", maijia);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xiaoshouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouxinxi> list=xiaoshouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouxinxi_list2";
	}
	
	
	@RequestMapping("xsxxList.do")
	public String xsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouxinxi xiaoshouxinxi, String dingdanhao, String bianhao, String leibie, String mingcheng, String jiage, String zhuangtai, String goumaishuliang1,String goumaishuliang2, String zongjine, String maijia, String shouhuodizhi, String dianhua, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(maijia==null||maijia.equals("")){pmap.put("maijia", null);}else{pmap.put("maijia", maijia);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=xiaoshouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouxinxi> list=xiaoshouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouxinxilist";
	}
	
	@RequestMapping("deleteXiaoshouxinxi.do")
	public String deleteXiaoshouxinxi(int id,HttpServletRequest request){
		xiaoshouxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiaoshouxinxiList.do";
	}
	
	
}
