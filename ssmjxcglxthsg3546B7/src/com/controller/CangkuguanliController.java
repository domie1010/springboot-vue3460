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

import com.entity.Cangkuguanli;
import com.server.CangkuguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CangkuguanliController {
	@Resource
	private CangkuguanliServer cangkuguanliService;


   
	@RequestMapping("addCangkuguanli.do")
	public String addCangkuguanli(HttpServletRequest request,Cangkuguanli cangkuguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		cangkuguanli.setAddtime(time.toString().substring(0, 19));
		cangkuguanliService.add(cangkuguanli);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "cangkuguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:cangkuguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCangkuguanli.do")
	public String doUpdateCangkuguanli(int id,ModelMap map,Cangkuguanli cangkuguanli){
		cangkuguanli=cangkuguanliService.getById(id);
		map.put("cangkuguanli", cangkuguanli);
		return "cangkuguanli_updt";
	}
	
	@RequestMapping("doUpdateCangkuguanli2.do")
	public String doUpdateCangkuguanli2(ModelMap map,Cangkuguanli cangkuguanli,HttpServletRequest request){
		cangkuguanli=cangkuguanliService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("cangkuguanli", cangkuguanli);
		return "cangkuguanli_updt2";
	}
	
@RequestMapping("updateCangkuguanli2.do")
	public String updateCangkuguanli2(int id,ModelMap map,Cangkuguanli cangkuguanli,HttpServletRequest request,HttpSession session){
		cangkuguanliService.update(cangkuguanli);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
	}
	
	
	
//	后台详细
	@RequestMapping("cangkuguanliDetail.do")
	public String cangkuguanliDetail(int id,ModelMap map,Cangkuguanli cangkuguanli){
		cangkuguanli=cangkuguanliService.getById(id);
		map.put("cangkuguanli", cangkuguanli);
		return "cangkuguanli_detail";
	}
//	前台详细
	@RequestMapping("ckglDetail.do")
	public String ckglDetail(int id,ModelMap map,Cangkuguanli cangkuguanli){
		cangkuguanli=cangkuguanliService.getById(id);
		map.put("cangkuguanli", cangkuguanli);
		return "cangkuguanlidetail";
	}
//	
	@RequestMapping("updateCangkuguanli.do")
	public String updateCangkuguanli(int id,ModelMap map,Cangkuguanli cangkuguanli,HttpServletRequest request,HttpSession session){
		cangkuguanliService.update(cangkuguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:cangkuguanliList.do";
	}

//	分页查询
	@RequestMapping("cangkuguanliList.do")
	public String cangkuguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cangkuguanli cangkuguanli, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(gongzhong==null||gongzhong.equals("")){pmap.put("gongzhong", null);}else{pmap.put("gongzhong", gongzhong);}
		if(ruzhishijian==null||ruzhishijian.equals("")){pmap.put("ruzhishijian", null);}else{pmap.put("ruzhishijian", ruzhishijian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=cangkuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cangkuguanli> list=cangkuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cangkuguanli_list";
	}
	
	
	
	@RequestMapping("ckglList.do")
	public String ckglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cangkuguanli cangkuguanli, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling==null||nianling.equals("")){pmap.put("nianling", null);}else{pmap.put("nianling", nianling);}
		if(gongzhong==null||gongzhong.equals("")){pmap.put("gongzhong", null);}else{pmap.put("gongzhong", gongzhong);}
		if(ruzhishijian==null||ruzhishijian.equals("")){pmap.put("ruzhishijian", null);}else{pmap.put("ruzhishijian", ruzhishijian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=cangkuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cangkuguanli> list=cangkuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cangkuguanlilist";
	}
	
	@RequestMapping("deleteCangkuguanli.do")
	public String deleteCangkuguanli(int id,HttpServletRequest request){
		cangkuguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:cangkuguanliList.do";
	}
	
	
}
