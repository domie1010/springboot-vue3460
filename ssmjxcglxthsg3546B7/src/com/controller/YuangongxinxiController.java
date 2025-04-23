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

import com.entity.Yuangongxinxi;
import com.server.YuangongxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YuangongxinxiController {
	@Resource
	private YuangongxinxiServer yuangongxinxiService;


   
	@RequestMapping("addYuangongxinxi.do")
	public String addYuangongxinxi(HttpServletRequest request,Yuangongxinxi yuangongxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yuangongxinxi.setAddtime(time.toString().substring(0, 19));
		yuangongxinxiService.add(yuangongxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yuangongxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yuangongxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYuangongxinxi.do")
	public String doUpdateYuangongxinxi(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
		yuangongxinxi=yuangongxinxiService.getById(id);
		map.put("yuangongxinxi", yuangongxinxi);
		return "yuangongxinxi_updt";
	}
	
	@RequestMapping("doUpdateYuangongxinxi2.do")
	public String doUpdateYuangongxinxi2(ModelMap map,Yuangongxinxi yuangongxinxi,HttpServletRequest request){
		yuangongxinxi=yuangongxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yuangongxinxi", yuangongxinxi);
		return "yuangongxinxi_updt2";
	}
	
@RequestMapping("updateYuangongxinxi2.do")
	public String updateYuangongxinxi2(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
		yuangongxinxiService.update(yuangongxinxi);
		return "redirect:doUpdateYuangongxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yuangongxinxiDetail.do")
	public String yuangongxinxiDetail(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
		yuangongxinxi=yuangongxinxiService.getById(id);
		map.put("yuangongxinxi", yuangongxinxi);
		return "yuangongxinxi_detail";
	}
//	前台详细
	@RequestMapping("ygxxDetail.do")
	public String ygxxDetail(int id,ModelMap map,Yuangongxinxi yuangongxinxi){
		yuangongxinxi=yuangongxinxiService.getById(id);
		map.put("yuangongxinxi", yuangongxinxi);
		return "yuangongxinxidetail";
	}
//	
	@RequestMapping("updateYuangongxinxi.do")
	public String updateYuangongxinxi(int id,ModelMap map,Yuangongxinxi yuangongxinxi,HttpServletRequest request,HttpSession session){
		yuangongxinxiService.update(yuangongxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yuangongxinxiList.do";
	}

//	分页查询
	@RequestMapping("yuangongxinxiList.do")
	public String yuangongxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian1,String ruzhishijian2, String beizhu){
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
		if(ruzhishijian1==null||ruzhishijian1.equals("")){pmap.put("ruzhishijian1", null);}else{pmap.put("ruzhishijian1", ruzhishijian1);}
		if(ruzhishijian2==null||ruzhishijian2.equals("")){pmap.put("ruzhishijian2", null);}else{pmap.put("ruzhishijian2", ruzhishijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yuangongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuangongxinxi_list";
	}
	
	

	
	
	@RequestMapping("ygxxList.do")
	public String ygxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuangongxinxi yuangongxinxi, String bianhao, String mima, String xingming, String xingbie, String nianling, String gongzhong, String ruzhishijian1,String ruzhishijian2, String beizhu){
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
		if(ruzhishijian1==null||ruzhishijian1.equals("")){pmap.put("ruzhishijian1", null);}else{pmap.put("ruzhishijian1", ruzhishijian1);}
		if(ruzhishijian2==null||ruzhishijian2.equals("")){pmap.put("ruzhishijian2", null);}else{pmap.put("ruzhishijian2", ruzhishijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yuangongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuangongxinxi> list=yuangongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuangongxinxilist";
	}
	
	@RequestMapping("deleteYuangongxinxi.do")
	public String deleteYuangongxinxi(int id,HttpServletRequest request){
		yuangongxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yuangongxinxiList.do";
	}
	
	@RequestMapping("quchongYuangongxinxi.do")
	public void quchongYuangongxinxi(Yuangongxinxi yuangongxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", yuangongxinxi.getBianhao());
		   System.out.println("bianhao==="+yuangongxinxi.getBianhao());
		   System.out.println("bianhao222==="+yuangongxinxiService.quchongYuangongxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(yuangongxinxiService.quchongYuangongxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
