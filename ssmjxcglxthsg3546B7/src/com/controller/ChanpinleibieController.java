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

import com.entity.Chanpinleibie;
import com.server.ChanpinleibieServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ChanpinleibieController {
	@Resource
	private ChanpinleibieServer chanpinleibieService;


   
	@RequestMapping("addChanpinleibie.do")
	public String addChanpinleibie(HttpServletRequest request,Chanpinleibie chanpinleibie,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		chanpinleibie.setAddtime(time.toString().substring(0, 19));
		chanpinleibieService.add(chanpinleibie);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "chanpinleibieList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:chanpinleibieList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateChanpinleibie.do")
	public String doUpdateChanpinleibie(int id,ModelMap map,Chanpinleibie chanpinleibie){
		chanpinleibie=chanpinleibieService.getById(id);
		map.put("chanpinleibie", chanpinleibie);
		return "chanpinleibie_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("chanpinleibieDetail.do")
	public String chanpinleibieDetail(int id,ModelMap map,Chanpinleibie chanpinleibie){
		chanpinleibie=chanpinleibieService.getById(id);
		map.put("chanpinleibie", chanpinleibie);
		return "chanpinleibie_detail";
	}
//	前台详细
	@RequestMapping("cplbDetail.do")
	public String cplbDetail(int id,ModelMap map,Chanpinleibie chanpinleibie){
		chanpinleibie=chanpinleibieService.getById(id);
		map.put("chanpinleibie", chanpinleibie);
		return "chanpinleibiedetail";
	}
//	
	@RequestMapping("updateChanpinleibie.do")
	public String updateChanpinleibie(int id,ModelMap map,Chanpinleibie chanpinleibie,HttpServletRequest request,HttpSession session){
		chanpinleibieService.update(chanpinleibie);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:chanpinleibieList.do";
	}

//	分页查询
	@RequestMapping("chanpinleibieList.do")
	public String chanpinleibieList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chanpinleibie chanpinleibie, String leibie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		
		int total=chanpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chanpinleibie> list=chanpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chanpinleibie_list";
	}
	
	
	
	@RequestMapping("cplbList.do")
	public String cplbList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chanpinleibie chanpinleibie, String leibie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		
		int total=chanpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chanpinleibie> list=chanpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chanpinleibielist";
	}
	
	@RequestMapping("deleteChanpinleibie.do")
	public String deleteChanpinleibie(int id,HttpServletRequest request){
		chanpinleibieService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:chanpinleibieList.do";
	}
	
	
}
