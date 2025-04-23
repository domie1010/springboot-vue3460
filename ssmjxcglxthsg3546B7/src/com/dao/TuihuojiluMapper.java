package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tuihuojilu;

public interface TuihuojiluMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tuihuojilu record);

    int insertSelective(Tuihuojilu record);

    Tuihuojilu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuihuojilu record);
	
    int updateByPrimaryKey(Tuihuojilu record);
	public Tuihuojilu quchongTuihuojilu(Map<String, Object> dingdanhao);
	public List<Tuihuojilu> getAll(Map<String, Object> map);
	public List<Tuihuojilu> getsytuihuojilu1(Map<String, Object> map);
	public List<Tuihuojilu> getsytuihuojilu3(Map<String, Object> map);
	public List<Tuihuojilu> getsytuihuojilu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tuihuojilu> getByPage(Map<String, Object> map);
	public List<Tuihuojilu> select(Map<String, Object> map);
//	所有List
}

