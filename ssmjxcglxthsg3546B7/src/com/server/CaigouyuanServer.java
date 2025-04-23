package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caigouyuan;

public interface CaigouyuanServer {

  public int add(Caigouyuan po);

  public int update(Caigouyuan po);
  
  
  
  public int delete(int id);

  public List<Caigouyuan> getAll(Map<String,Object> map);
  public List<Caigouyuan> getsycaigouyuan1(Map<String,Object> map);
  public List<Caigouyuan> getsycaigouyuan2(Map<String,Object> map);
  public List<Caigouyuan> getsycaigouyuan3(Map<String,Object> map);
  public Caigouyuan quchongCaigouyuan(Map<String, Object> acount);

  public Caigouyuan getById( int id);

  public List<Caigouyuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caigouyuan> select(Map<String, Object> map);
}
//	所有List
