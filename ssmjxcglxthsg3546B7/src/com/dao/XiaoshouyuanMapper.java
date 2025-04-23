package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xiaoshouyuan;

public interface XiaoshouyuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoshouyuan record);

    int insertSelective(Xiaoshouyuan record);

    Xiaoshouyuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiaoshouyuan record);
	
    int updateByPrimaryKey(Xiaoshouyuan record);
	public Xiaoshouyuan quchongXiaoshouyuan(Map<String, Object> bianhao);
	public List<Xiaoshouyuan> getAll(Map<String, Object> map);
	public List<Xiaoshouyuan> getsyxiaoshouyuan1(Map<String, Object> map);
	public List<Xiaoshouyuan> getsyxiaoshouyuan3(Map<String, Object> map);
	public List<Xiaoshouyuan> getsyxiaoshouyuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiaoshouyuan> getByPage(Map<String, Object> map);
	public List<Xiaoshouyuan> select(Map<String, Object> map);
//	所有List
}

