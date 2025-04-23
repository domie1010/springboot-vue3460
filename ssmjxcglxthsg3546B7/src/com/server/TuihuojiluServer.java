package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tuihuojilu;

public interface TuihuojiluServer {

  public int add(Tuihuojilu po);

  public int update(Tuihuojilu po);
  
  
  
  public int delete(int id);

  public List<Tuihuojilu> getAll(Map<String,Object> map);
  public List<Tuihuojilu> getsytuihuojilu1(Map<String,Object> map);
  public List<Tuihuojilu> getsytuihuojilu2(Map<String,Object> map);
  public List<Tuihuojilu> getsytuihuojilu3(Map<String,Object> map);
  public Tuihuojilu quchongTuihuojilu(Map<String, Object> acount);

  public Tuihuojilu getById( int id);

  public List<Tuihuojilu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tuihuojilu> select(Map<String, Object> map);
}
//	所有List
