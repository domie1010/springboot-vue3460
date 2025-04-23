package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Chanpinleibie;

public interface ChanpinleibieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chanpinleibie record);

    int insertSelective(Chanpinleibie record);

    Chanpinleibie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chanpinleibie record);
	
    int updateByPrimaryKey(Chanpinleibie record);
	public Chanpinleibie quchongChanpinleibie(Map<String, Object> leibie);
	public List<Chanpinleibie> getAll(Map<String, Object> map);
	public List<Chanpinleibie> getsychanpinleibie1(Map<String, Object> map);
	public List<Chanpinleibie> getsychanpinleibie3(Map<String, Object> map);
	public List<Chanpinleibie> getsychanpinleibie2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Chanpinleibie> getByPage(Map<String, Object> map);
	public List<Chanpinleibie> select(Map<String, Object> map);
//	所有List
}

