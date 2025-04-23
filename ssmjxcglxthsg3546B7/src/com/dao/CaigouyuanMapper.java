package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caigouyuan;

public interface CaigouyuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caigouyuan record);

    int insertSelective(Caigouyuan record);

    Caigouyuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caigouyuan record);
	
    int updateByPrimaryKey(Caigouyuan record);
	public Caigouyuan quchongCaigouyuan(Map<String, Object> bianhao);
	public List<Caigouyuan> getAll(Map<String, Object> map);
	public List<Caigouyuan> getsycaigouyuan1(Map<String, Object> map);
	public List<Caigouyuan> getsycaigouyuan3(Map<String, Object> map);
	public List<Caigouyuan> getsycaigouyuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caigouyuan> getByPage(Map<String, Object> map);
	public List<Caigouyuan> select(Map<String, Object> map);
//	所有List
}

