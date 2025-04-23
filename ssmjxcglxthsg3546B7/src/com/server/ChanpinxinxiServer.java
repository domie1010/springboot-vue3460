package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Chanpinxinxi;

public interface ChanpinxinxiServer {

  public int add(Chanpinxinxi po);

  public int update(Chanpinxinxi po);
  
  
  
  public int delete(int id);

  public List<Chanpinxinxi> getAll(Map<String,Object> map);
  public List<Chanpinxinxi> getsychanpinxinxi1(Map<String,Object> map);
  public List<Chanpinxinxi> getsychanpinxinxi2(Map<String,Object> map);
  public List<Chanpinxinxi> getsychanpinxinxi3(Map<String,Object> map);
  public Chanpinxinxi quchongChanpinxinxi(Map<String, Object> acount);

  public Chanpinxinxi getById( int id);

  public List<Chanpinxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Chanpinxinxi> select(Map<String, Object> map);
}
//	所有List
