package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XiaoshouyuanMapper;
import com.entity.Xiaoshouyuan;
import com.server.XiaoshouyuanServer;
@Service
public class XiaoshouyuanServerImpi implements XiaoshouyuanServer {
   @Resource
   private XiaoshouyuanMapper gdao;
	@Override
	public int add(Xiaoshouyuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiaoshouyuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiaoshouyuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiaoshouyuan> getsyxiaoshouyuan1(Map<String, Object> map) {
		return gdao.getsyxiaoshouyuan1(map);
	}
	public List<Xiaoshouyuan> getsyxiaoshouyuan2(Map<String, Object> map) {
		return gdao.getsyxiaoshouyuan2(map);
	}
	public List<Xiaoshouyuan> getsyxiaoshouyuan3(Map<String, Object> map) {
		return gdao.getsyxiaoshouyuan3(map);
	}
	
	@Override
	public Xiaoshouyuan quchongXiaoshouyuan(Map<String, Object> account) {
		return gdao.quchongXiaoshouyuan(account);
	}

	@Override
	public List<Xiaoshouyuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiaoshouyuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiaoshouyuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

