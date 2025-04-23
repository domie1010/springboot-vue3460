package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Chanpinxinxi;

public interface ChanpinxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chanpinxinxi record);

    int insertSelective(Chanpinxinxi record);

    Chanpinxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chanpinxinxi record);
	
    int updateByPrimaryKey(Chanpinxinxi record);
	public Chanpinxinxi quchongChanpinxinxi(Map<String, Object> bianhao);
	public List<Chanpinxinxi> getAll(Map<String, Object> map);
	public List<Chanpinxinxi> getsychanpinxinxi1(Map<String, Object> map);
	public List<Chanpinxinxi> getsychanpinxinxi3(Map<String, Object> map);
	public List<Chanpinxinxi> getsychanpinxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Chanpinxinxi> getByPage(Map<String, Object> map);
	public List<Chanpinxinxi> select(Map<String, Object> map);
//	所有List
}

