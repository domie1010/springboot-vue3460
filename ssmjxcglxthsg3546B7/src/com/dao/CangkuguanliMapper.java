package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Cangkuguanli;

public interface CangkuguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cangkuguanli record);

    int insertSelective(Cangkuguanli record);

    Cangkuguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cangkuguanli record);
	
    int updateByPrimaryKey(Cangkuguanli record);
	public Cangkuguanli quchongCangkuguanli(Map<String, Object> bianhao);
	public List<Cangkuguanli> getAll(Map<String, Object> map);
	public List<Cangkuguanli> getsycangkuguanli1(Map<String, Object> map);
	public List<Cangkuguanli> getsycangkuguanli3(Map<String, Object> map);
	public List<Cangkuguanli> getsycangkuguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Cangkuguanli> getByPage(Map<String, Object> map);
	public List<Cangkuguanli> select(Map<String, Object> map);
//	所有List
}

