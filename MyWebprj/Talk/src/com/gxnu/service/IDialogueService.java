package com.gxnu.service;

import java.util.List;
import com.gxnu.entity.Dialogue;

public interface IDialogueService {
	public void add(Dialogue dialogue);
	//删除对话
	public void remove(int id);
	//查询对话，单个
	public Dialogue find(int id);
	//查询对话，所有
	public List<Dialogue> find();

	public List<Dialogue> findAll(String name, int id);
}
