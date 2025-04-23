package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaigouyuanMapper;
import com.entity.Caigouyuan;
import com.server.CaigouyuanServer;
@Service
public class CaigouyuanServerImpi implements CaigouyuanServer {
   @Resource
   private CaigouyuanMapper gdao;
	@Override
	public int add(Caigouyuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caigouyuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caigouyuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caigouyuan> getsycaigouyuan1(Map<String, Object> map) {
		return gdao.getsycaigouyuan1(map);
	}
	public List<Caigouyuan> getsycaigouyuan2(Map<String, Object> map) {
		return gdao.getsycaigouyuan2(map);
	}
	public List<Caigouyuan> getsycaigouyuan3(Map<String, Object> map) {
		return gdao.getsycaigouyuan3(map);
	}
	
	@Override
	public Caigouyuan quchongCaigouyuan(Map<String, Object> account) {
		return gdao.quchongCaigouyuan(account);
	}

	@Override
	public List<Caigouyuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caigouyuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caigouyuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

