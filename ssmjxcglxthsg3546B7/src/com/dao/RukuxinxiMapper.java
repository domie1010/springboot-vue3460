package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Rukuxinxi;

public interface RukuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rukuxinxi record);

    int insertSelective(Rukuxinxi record);

    Rukuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rukuxinxi record);
	
    int updateByPrimaryKey(Rukuxinxi record);
	public Rukuxinxi quchongRukuxinxi(Map<String, Object> bianhao);
	public List<Rukuxinxi> getAll(Map<String, Object> map);
	public List<Rukuxinxi> getsyrukuxinxi1(Map<String, Object> map);
	public List<Rukuxinxi> getsyrukuxinxi3(Map<String, Object> map);
	public List<Rukuxinxi> getsyrukuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Rukuxinxi> getByPage(Map<String, Object> map);
	public List<Rukuxinxi> select(Map<String, Object> map);
//	所有List
}

