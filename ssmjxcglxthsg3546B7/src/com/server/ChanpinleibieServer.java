package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Chanpinleibie;

public interface ChanpinleibieServer {

  public int add(Chanpinleibie po);

  public int update(Chanpinleibie po);
  
  
  
  public int delete(int id);

  public List<Chanpinleibie> getAll(Map<String,Object> map);
  public List<Chanpinleibie> getsychanpinleibie1(Map<String,Object> map);
  public List<Chanpinleibie> getsychanpinleibie2(Map<String,Object> map);
  public List<Chanpinleibie> getsychanpinleibie3(Map<String,Object> map);
  public Chanpinleibie quchongChanpinleibie(Map<String, Object> acount);

  public Chanpinleibie getById( int id);

  public List<Chanpinleibie> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Chanpinleibie> select(Map<String, Object> map);
}
//	所有List
