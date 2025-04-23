package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ChanpinxinxiMapper;
import com.entity.Chanpinxinxi;
import com.server.ChanpinxinxiServer;
@Service
public class ChanpinxinxiServerImpi implements ChanpinxinxiServer {
   @Resource
   private ChanpinxinxiMapper gdao;
	@Override
	public int add(Chanpinxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Chanpinxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Chanpinxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Chanpinxinxi> getsychanpinxinxi1(Map<String, Object> map) {
		return gdao.getsychanpinxinxi1(map);
	}
	public List<Chanpinxinxi> getsychanpinxinxi2(Map<String, Object> map) {
		return gdao.getsychanpinxinxi2(map);
	}
	public List<Chanpinxinxi> getsychanpinxinxi3(Map<String, Object> map) {
		return gdao.getsychanpinxinxi3(map);
	}
	
	@Override
	public Chanpinxinxi quchongChanpinxinxi(Map<String, Object> account) {
		return gdao.quchongChanpinxinxi(account);
	}

	@Override
	public List<Chanpinxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Chanpinxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Chanpinxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

