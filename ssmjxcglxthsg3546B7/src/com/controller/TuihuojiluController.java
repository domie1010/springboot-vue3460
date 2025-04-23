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

import com.entity.Tuihuojilu;
import com.server.TuihuojiluServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TuihuojiluController {
	@Resource
	private TuihuojiluServer tuihuojiluService;


   
	@RequestMapping("addTuihuojilu.do")
	public String addTuihuojilu(HttpServletRequest request,Tuihuojilu tuihuojilu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tuihuojilu.setAddtime(time.toString().substring(0, 19));
		tuihuojiluService.add(tuihuojilu);
		String sql="";
		sql="update chanpinxinxi set kucun=kucun+"+tuihuojilu.getGoumaishuliang()+" where bianhao='"+tuihuojilu.getBianhao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);
		
		
		sql="update xiaoshouxinxi set zhuangtai='已退货' where bianhao='"+tuihuojilu.getBianhao()+"'";
		System.out.print(sql);
		dbo.hsgexecute(sql);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tuihuojiluList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tuihuojiluList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTuihuojilu.do")
	public String doUpdateTuihuojilu(int id,ModelMap map,Tuihuojilu tuihuojilu){
		tuihuojilu=tuihuojiluService.getById(id);
		map.put("tuihuojilu", tuihuojilu);
		return "tuihuojilu_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("tuihuojiluDetail.do")
	public String tuihuojiluDetail(int id,ModelMap map,Tuihuojilu tuihuojilu){
		tuihuojilu=tuihuojiluService.getById(id);
		map.put("tuihuojilu", tuihuojilu);
		return "tuihuojilu_detail";
	}
//	前台详细
	@RequestMapping("thjlDetail.do")
	public String thjlDetail(int id,ModelMap map,Tuihuojilu tuihuojilu){
		tuihuojilu=tuihuojiluService.getById(id);
		map.put("tuihuojilu", tuihuojilu);
		return "tuihuojiludetail";
	}
//	
	@RequestMapping("updateTuihuojilu.do")
	public String updateTuihuojilu(int id,ModelMap map,Tuihuojilu tuihuojilu,HttpServletRequest request,HttpSession session){
		tuihuojiluService.update(tuihuojilu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tuihuojiluList.do";
	}

//	分页查询
	@RequestMapping("tuihuojiluList.do")
	public String tuihuojiluList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuihuojilu tuihuojilu, String dingdanhao, String bianhao, String leibie, String mingcheng, String jiage, String goumaishuliang, String zongjine, String maijia, String shouhuodizhi, String dianhua, String beizhu){
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
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(maijia==null||maijia.equals("")){pmap.put("maijia", null);}else{pmap.put("maijia", maijia);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=tuihuojiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuihuojilu> list=tuihuojiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuihuojilu_list";
	}
	
	
	
	@RequestMapping("thjlList.do")
	public String thjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuihuojilu tuihuojilu, String dingdanhao, String bianhao, String leibie, String mingcheng, String jiage, String goumaishuliang, String zongjine, String maijia, String shouhuodizhi, String dianhua, String beizhu){
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
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(maijia==null||maijia.equals("")){pmap.put("maijia", null);}else{pmap.put("maijia", maijia);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=tuihuojiluService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuihuojilu> list=tuihuojiluService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuihuojilulist";
	}
	
	@RequestMapping("deleteTuihuojilu.do")
	public String deleteTuihuojilu(int id,HttpServletRequest request){
		tuihuojiluService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tuihuojiluList.do";
	}
	
	
}
