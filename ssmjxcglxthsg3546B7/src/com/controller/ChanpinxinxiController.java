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

import com.entity.Chanpinxinxi;
import com.server.ChanpinxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ChanpinxinxiController {
	@Resource
	private ChanpinxinxiServer chanpinxinxiService;


   
	@RequestMapping("addChanpinxinxi.do")
	public String addChanpinxinxi(HttpServletRequest request,Chanpinxinxi chanpinxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		chanpinxinxi.setAddtime(time.toString().substring(0, 19));
		chanpinxinxiService.add(chanpinxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "chanpinxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:chanpinxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateChanpinxinxi.do")
	public String doUpdateChanpinxinxi(int id,ModelMap map,Chanpinxinxi chanpinxinxi){
		chanpinxinxi=chanpinxinxiService.getById(id);
		map.put("chanpinxinxi", chanpinxinxi);
		return "chanpinxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("chanpinxinxiDetail.do")
	public String chanpinxinxiDetail(int id,ModelMap map,Chanpinxinxi chanpinxinxi){
		chanpinxinxi=chanpinxinxiService.getById(id);
		map.put("chanpinxinxi", chanpinxinxi);
		return "chanpinxinxi_detail";
	}
//	前台详细
	@RequestMapping("cpxxDetail.do")
	public String cpxxDetail(int id,ModelMap map,Chanpinxinxi chanpinxinxi){
		chanpinxinxi=chanpinxinxiService.getById(id);
		map.put("chanpinxinxi", chanpinxinxi);
		return "chanpinxinxidetail";
	}
//	
	@RequestMapping("updateChanpinxinxi.do")
	public String updateChanpinxinxi(int id,ModelMap map,Chanpinxinxi chanpinxinxi,HttpServletRequest request,HttpSession session){
		chanpinxinxiService.update(chanpinxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:chanpinxinxiList.do";
	}

//	分页查询
	@RequestMapping("chanpinxinxiList.do")
	public String chanpinxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chanpinxinxi chanpinxinxi, String bianhao, String leibie, String mingcheng, String tupian, String kucun, String jiage, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=chanpinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chanpinxinxi> list=chanpinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chanpinxinxi_list";
	}
	
	
	
		@RequestMapping("chanpinxinxiList2.do")
	public String chanpinxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chanpinxinxi chanpinxinxi, String bianhao, String leibie, String mingcheng, String tupian, String kucun, String jiage, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=chanpinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chanpinxinxi> list=chanpinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chanpinxinxi_list2";
	}
	
	
			@RequestMapping("chanpinxinxiList3.do")
	public String chanpinxinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chanpinxinxi chanpinxinxi, String bianhao, String leibie, String mingcheng, String tupian, String kucun, String jiage, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=chanpinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chanpinxinxi> list=chanpinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chanpinxinxi_list3";
	}
	
	
	@RequestMapping("cpxxList.do")
	public String cpxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chanpinxinxi chanpinxinxi, String bianhao, String leibie, String mingcheng, String tupian, String kucun, String jiage, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=chanpinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chanpinxinxi> list=chanpinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chanpinxinxilist";
	}
	
	@RequestMapping("deleteChanpinxinxi.do")
	public String deleteChanpinxinxi(int id,HttpServletRequest request){
		chanpinxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:chanpinxinxiList.do";
	}
	
	@RequestMapping("quchongChanpinxinxi.do")
	public void quchongChanpinxinxi(Chanpinxinxi chanpinxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", chanpinxinxi.getBianhao());
		   System.out.println("bianhao==="+chanpinxinxi.getBianhao());
		   System.out.println("bianhao222==="+chanpinxinxiService.quchongChanpinxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(chanpinxinxiService.quchongChanpinxinxi(map)!=null){
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
