package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CangkuguanliMapper;
import com.entity.Cangkuguanli;
import com.server.CangkuguanliServer;
@Service
public class CangkuguanliServerImpi implements CangkuguanliServer {
   @Resource
   private CangkuguanliMapper gdao;
	@Override
	public int add(Cangkuguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Cangkuguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Cangkuguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Cangkuguanli> getsycangkuguanli1(Map<String, Object> map) {
		return gdao.getsycangkuguanli1(map);
	}
	public List<Cangkuguanli> getsycangkuguanli2(Map<String, Object> map) {
		return gdao.getsycangkuguanli2(map);
	}
	public List<Cangkuguanli> getsycangkuguanli3(Map<String, Object> map) {
		return gdao.getsycangkuguanli3(map);
	}
	
	@Override
	public Cangkuguanli quchongCangkuguanli(Map<String, Object> account) {
		return gdao.quchongCangkuguanli(account);
	}

	@Override
	public List<Cangkuguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Cangkuguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Cangkuguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

