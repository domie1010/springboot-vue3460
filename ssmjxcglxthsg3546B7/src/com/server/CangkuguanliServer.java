package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Cangkuguanli;

public interface CangkuguanliServer {

  public int add(Cangkuguanli po);

  public int update(Cangkuguanli po);
  
  
  
  public int delete(int id);

  public List<Cangkuguanli> getAll(Map<String,Object> map);
  public List<Cangkuguanli> getsycangkuguanli1(Map<String,Object> map);
  public List<Cangkuguanli> getsycangkuguanli2(Map<String,Object> map);
  public List<Cangkuguanli> getsycangkuguanli3(Map<String,Object> map);
  public Cangkuguanli quchongCangkuguanli(Map<String, Object> acount);

  public Cangkuguanli getById( int id);

  public List<Cangkuguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Cangkuguanli> select(Map<String, Object> map);
}
//	所有List
