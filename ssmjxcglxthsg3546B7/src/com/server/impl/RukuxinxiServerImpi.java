package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.RukuxinxiMapper;
import com.entity.Rukuxinxi;
import com.server.RukuxinxiServer;
@Service
public class RukuxinxiServerImpi implements RukuxinxiServer {
   @Resource
   private RukuxinxiMapper gdao;
	@Override
	public int add(Rukuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Rukuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Rukuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Rukuxinxi> getsyrukuxinxi1(Map<String, Object> map) {
		return gdao.getsyrukuxinxi1(map);
	}
	public List<Rukuxinxi> getsyrukuxinxi2(Map<String, Object> map) {
		return gdao.getsyrukuxinxi2(map);
	}
	public List<Rukuxinxi> getsyrukuxinxi3(Map<String, Object> map) {
		return gdao.getsyrukuxinxi3(map);
	}
	
	@Override
	public Rukuxinxi quchongRukuxinxi(Map<String, Object> account) {
		return gdao.quchongRukuxinxi(account);
	}

	@Override
	public List<Rukuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Rukuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Rukuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

