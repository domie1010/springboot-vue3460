package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TuihuojiluMapper;
import com.entity.Tuihuojilu;
import com.server.TuihuojiluServer;
@Service
public class TuihuojiluServerImpi implements TuihuojiluServer {
   @Resource
   private TuihuojiluMapper gdao;
	@Override
	public int add(Tuihuojilu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tuihuojilu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tuihuojilu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tuihuojilu> getsytuihuojilu1(Map<String, Object> map) {
		return gdao.getsytuihuojilu1(map);
	}
	public List<Tuihuojilu> getsytuihuojilu2(Map<String, Object> map) {
		return gdao.getsytuihuojilu2(map);
	}
	public List<Tuihuojilu> getsytuihuojilu3(Map<String, Object> map) {
		return gdao.getsytuihuojilu3(map);
	}
	
	@Override
	public Tuihuojilu quchongTuihuojilu(Map<String, Object> account) {
		return gdao.quchongTuihuojilu(account);
	}

	@Override
	public List<Tuihuojilu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tuihuojilu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tuihuojilu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

