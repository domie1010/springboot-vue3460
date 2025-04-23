package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Rukuxinxi;

public interface RukuxinxiServer {

  public int add(Rukuxinxi po);

  public int update(Rukuxinxi po);
  
  
  
  public int delete(int id);

  public List<Rukuxinxi> getAll(Map<String,Object> map);
  public List<Rukuxinxi> getsyrukuxinxi1(Map<String,Object> map);
  public List<Rukuxinxi> getsyrukuxinxi2(Map<String,Object> map);
  public List<Rukuxinxi> getsyrukuxinxi3(Map<String,Object> map);
  public Rukuxinxi quchongRukuxinxi(Map<String, Object> acount);

  public Rukuxinxi getById( int id);

  public List<Rukuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Rukuxinxi> select(Map<String, Object> map);
}
//	所有List
