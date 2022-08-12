package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Operator;



public interface IOperatorService {
	
	public void add(Operator operator);
	
	public void remove(int id);
	
	public void update(Operator operator);
	
	public Operator find(int id);
	
	public List<Operator> find();
	
	public Operator find(String username, String password);
	
	public Operator findrole(String username, String email);
	
}
