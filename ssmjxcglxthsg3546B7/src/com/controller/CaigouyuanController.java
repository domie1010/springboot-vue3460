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

import com.entity.Caigouyuan;
import com.server.CaigouyuanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaigouyuanController {
	@Resource
	private CaigouyuanServer caigouyuanService;


   
	@RequestMapping("addCaigouyuan.do")
	public String addCaigouyuan(HttpServletRequest request,Caigouyuan caigouyuan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		caigouyuan.setAddtime(time.toString().substring(0, 19));
		caigouyuanService.add(caigouyuan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "caigouyuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:caigouyuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCaigouyuan.do")
	public String doUpdateCaigouyuan(int id,ModelMap map,Caigouyuan caigouyuan){
		caigouyuan=caigouyuanService.getById(id);
		map.put("caigouyuan", caigouyuan);
		return "caigouyuan_updt";
	}
	
	@RequestMapping("doUpdateCaigouyuan2.do")
	public String doUpdateCaigouyuan2(ModelMap map,Caigouyuan caigouyuan,HttpServletRequest request){
		caigouyuan=caigouyuanService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("caigouyuan", caigouyuan);
		return "caigouyuan_updt2";
	}
	
@RequestMapping("updateCaigouyuan2.do")
	public String updateCaigouyuan2(int id,ModelMap map,Caigouyuan caigouyuan){
		caigouyuanService.update(caigouyuan);
		return "redirect:doUpdateCaigouyuan2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("caigouyuanDetail.do")
	public String caigouyuanDetail(int id,ModelMap map,Caigouyuan caigouyuan){
		caigouyuan=caigouyuanService.getById(id);
		map.put("caigouyuan", caigouyuan);
		return "caigouyuan_detail";
	}
//	前台详细
	@RequestMapping("cgyDetail.do")
	public String cgyDetail(int id,ModelMap map,Caigouyuan caigouyuan){
		caigouyuan=caigouyuanService.getById(id);
		map.put("caigouyuan", caigouyuan);
		return "caigouyuandetail";
	}
//	
	@RequestMapping("updateCaigouyuan.do")
	public String updateCaigouyuan(int id,ModelMap map,Caigouyuan caigouyuan,HttpServletRequest request,HttpSession session){
		caigouyuanService.update(caigouyuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:caigouyuanList.do";
	}

//	分页查询
	@RequestMapping("caigouyuanList.do")
	public String caigouyuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigouyuan caigouyuan, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(gongzhong==null||gongzhong.equals("")){pmap.put("gongzhong", null);}else{pmap.put("gongzhong", gongzhong);}		if(ruzhishijian==null||ruzhishijian.equals("")){pmap.put("ruzhishijian", null);}else{pmap.put("ruzhishijian", ruzhishijian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=caigouyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigouyuan> list=caigouyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigouyuan_list";
	}
	
	
	
	@RequestMapping("cgyList.do")
	public String cgyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caigouyuan caigouyuan, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}		if(gongzhong==null||gongzhong.equals("")){pmap.put("gongzhong", null);}else{pmap.put("gongzhong", gongzhong);}		if(ruzhishijian==null||ruzhishijian.equals("")){pmap.put("ruzhishijian", null);}else{pmap.put("ruzhishijian", ruzhishijian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=caigouyuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caigouyuan> list=caigouyuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caigouyuanlist";
	}
	
	@RequestMapping("deleteCaigouyuan.do")
	public String deleteCaigouyuan(int id,HttpServletRequest request){
		caigouyuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:caigouyuanList.do";
	}
	
	
}
