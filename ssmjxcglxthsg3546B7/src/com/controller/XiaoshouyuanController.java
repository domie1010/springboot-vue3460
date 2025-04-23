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

import com.entity.Xiaoshouyuan;
import com.server.XiaoshouyuanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiaoshouyuanController {
	@Resource
	private XiaoshouyuanServer xiaoshouyuanService;


   
	@RequestMapping("addXiaoshouyuan.do")
	public String addXiaoshouyuan(HttpServletRequest request,Xiaoshouyuan xiaoshouyuan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiaoshouyuan.setAddtime(time.toString().substring(0, 19));
		xiaoshouyuanService.add(xiaoshouyuan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiaoshouyuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiaoshouyuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiaoshouyuan.do")
	public String doUpdateXiaoshouyuan(int id,ModelMap map,Xiaoshouyuan xiaoshouyuan){
		xiaoshouyuan=xiaoshouyuanService.getById(id);
		map.put("xiaoshouyuan", xiaoshouyuan);
		return "xiaoshouyuan_updt";
	}
	
	@RequestMapping("doUpdateXiaoshouyuan2.do")
	public String doUpdateXiaoshouyuan2(ModelMap map,Xiaoshouyuan xiaoshouyuan,HttpServletRequest request){
		xiaoshouyuan=xiaoshouyuanService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("xiaoshouyuan", xiaoshouyuan);
		return "xiaoshouyuan_updt2";
	}
	
@RequestMapping("updateXiaoshouyuan2.do")
	public String updateXiaoshouyuan2(int id,ModelMap map,Xiaoshouyuan xiaoshouyuan){
		xiaoshouyuanService.update(xiaoshouyuan);
		return "redirect:doUpdateXiaoshouyuan2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("xiaoshouyuanDetail.do")
	public String xiaoshouyuanDetail(int id,ModelMap map,Xiaoshouyuan xiaoshouyuan){
		xiaoshouyuan=xiaoshouyuanService.getById(id);
		map.put("xiaoshouyuan", xiaoshouyuan);
		return "xiaoshouyuan_detail";
	}
//	前台详细
	@RequestMapping("xsyDetail.do")
	public String xsyDetail(int id,ModelMap map,Xiaoshouyuan xiaoshouyuan){
		xiaoshouyuan=xiaoshouyuanService.getById(id);
		map.put("xiaoshouyuan", xiaoshouyuan);
		return "xiaoshouyuandetail";
	}
//	
	@RequestMapping("updateXiaoshouyuan.do")
	public String updateXiaoshouyuan(int id,ModelMap map,Xiaoshouyuan xiaoshouyuan,HttpServletRequest request,HttpSession session){
		xiaoshouyuanService.update(xiaoshouyuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiaoshouyuanList.do";
	}

//	分页查询
	@RequestMapping("xiaoshouyuanList.do")
	public String xiaoshouyuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouyuan xiaoshouyuan, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(gongzhong==null||gongzhong.equals("")){pmap.put("gongzhong", null);}else{pmap.put("gongzhong", gongzhong);}		if(ruzhishijian==null||ruzhishijian.equals("")){pmap.put("ruzhishijian", null);}else{pmap.put("ruzhishijian", ruzhishijian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=xiaoshouyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouyuan> list=xiaoshouyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouyuan_list";
	}
	
	
	
	@RequestMapping("xsyList.do")
	public String xsyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiaoshouyuan xiaoshouyuan, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(gongzhong==null||gongzhong.equals("")){pmap.put("gongzhong", null);}else{pmap.put("gongzhong", gongzhong);}		if(ruzhishijian==null||ruzhishijian.equals("")){pmap.put("ruzhishijian", null);}else{pmap.put("ruzhishijian", ruzhishijian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=xiaoshouyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiaoshouyuan> list=xiaoshouyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiaoshouyuanlist";
	}
	
	@RequestMapping("deleteXiaoshouyuan.do")
	public String deleteXiaoshouyuan(int id,HttpServletRequest request){
		xiaoshouyuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiaoshouyuanList.do";
	}
	
	
}
