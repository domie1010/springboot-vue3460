package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xiaoshouyuan;

public interface XiaoshouyuanServer {

  public int add(Xiaoshouyuan po);

  public int update(Xiaoshouyuan po);
  
  
  
  public int delete(int id);

  public List<Xiaoshouyuan> getAll(Map<String,Object> map);
  public List<Xiaoshouyuan> getsyxiaoshouyuan1(Map<String,Object> map);
  public List<Xiaoshouyuan> getsyxiaoshouyuan2(Map<String,Object> map);
  public List<Xiaoshouyuan> getsyxiaoshouyuan3(Map<String,Object> map);
  public Xiaoshouyuan quchongXiaoshouyuan(Map<String, Object> acount);

  public Xiaoshouyuan getById( int id);

  public List<Xiaoshouyuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xiaoshouyuan> select(Map<String, Object> map);
}
//	所有List
