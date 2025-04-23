package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ChanpinleibieMapper;
import com.entity.Chanpinleibie;
import com.server.ChanpinleibieServer;
@Service
public class ChanpinleibieServerImpi implements ChanpinleibieServer {
   @Resource
   private ChanpinleibieMapper gdao;
	@Override
	public int add(Chanpinleibie po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Chanpinleibie po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Chanpinleibie> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Chanpinleibie> getsychanpinleibie1(Map<String, Object> map) {
		return gdao.getsychanpinleibie1(map);
	}
	public List<Chanpinleibie> getsychanpinleibie2(Map<String, Object> map) {
		return gdao.getsychanpinleibie2(map);
	}
	public List<Chanpinleibie> getsychanpinleibie3(Map<String, Object> map) {
		return gdao.getsychanpinleibie3(map);
	}
	
	@Override
	public Chanpinleibie quchongChanpinleibie(Map<String, Object> account) {
		return gdao.quchongChanpinleibie(account);
	}

	@Override
	public List<Chanpinleibie> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Chanpinleibie> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Chanpinleibie getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

