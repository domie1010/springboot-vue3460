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

import com.entity.Rukuxinxi;
import com.server.RukuxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class RukuxinxiController {
	@Resource
	private RukuxinxiServer rukuxinxiService;


   
	@RequestMapping("addRukuxinxi.do")
	public String addRukuxinxi(HttpServletRequest request,Rukuxinxi rukuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		rukuxinxi.setAddtime(time.toString().substring(0, 19));
		rukuxinxiService.add(rukuxinxi);
		String sql="";
		sql="update chanpinxinxi set kucun=kucun+"+rukuxinxi.getRukushuliang()+" where bianhao='"+rukuxinxi.getBianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "rukuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:rukuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateRukuxinxi.do")
	public String doUpdateRukuxinxi(int id,ModelMap map,Rukuxinxi rukuxinxi){
		rukuxinxi=rukuxinxiService.getById(id);
		map.put("rukuxinxi", rukuxinxi);
		return "rukuxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("rukuxinxiDetail.do")
	public String rukuxinxiDetail(int id,ModelMap map,Rukuxinxi rukuxinxi){
		rukuxinxi=rukuxinxiService.getById(id);
		map.put("rukuxinxi", rukuxinxi);
		return "rukuxinxi_detail";
	}
//	前台详细
	@RequestMapping("rkxxDetail.do")
	public String rkxxDetail(int id,ModelMap map,Rukuxinxi rukuxinxi){
		rukuxinxi=rukuxinxiService.getById(id);
		map.put("rukuxinxi", rukuxinxi);
		return "rukuxinxidetail";
	}
//	
	@RequestMapping("updateRukuxinxi.do")
	public String updateRukuxinxi(int id,ModelMap map,Rukuxinxi rukuxinxi,HttpServletRequest request,HttpSession session){
		rukuxinxiService.update(rukuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:rukuxinxiList.do";
	}

//	分页查询
	@RequestMapping("rukuxinxiList.do")
	public String rukuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuxinxi rukuxinxi, String bianhao, String leibie, String mingcheng, String kucun, String jiage, String rukujiage, String rukushuliang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(rukujiage==null||rukujiage.equals("")){pmap.put("rukujiage", null);}else{pmap.put("rukujiage", rukujiage);}
		if(rukushuliang==null||rukushuliang.equals("")){pmap.put("rukushuliang", null);}else{pmap.put("rukushuliang", rukushuliang);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuxinxi> list=rukuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuxinxi_list";
	}
	
	
	
	@RequestMapping("rkxxList.do")
	public String rkxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuxinxi rukuxinxi, String bianhao, String leibie, String mingcheng, String kucun, String jiage, String rukujiage, String rukushuliang, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(rukujiage==null||rukujiage.equals("")){pmap.put("rukujiage", null);}else{pmap.put("rukujiage", rukujiage);}
		if(rukushuliang==null||rukushuliang.equals("")){pmap.put("rukushuliang", null);}else{pmap.put("rukushuliang", rukushuliang);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuxinxi> list=rukuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuxinxilist";
	}
	
	@RequestMapping("deleteRukuxinxi.do")
	public String deleteRukuxinxi(int id,HttpServletRequest request){
		rukuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:rukuxinxiList.do";
	}
	
	
}
