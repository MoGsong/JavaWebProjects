package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.DialogueDAO;
import com.gxnu.entity.Dialogue;
import com.gxnu.service.IDialogueService;

public class DialogueService implements IDialogueService{

	@Override
	public void add(Dialogue diadialogueue) {
		//创建角色持久层对象 
		DialogueDAO dialogueDAO = new DialogueDAO();
		try {
			dialogueDAO.add(diadialogueue);
		} catch (ClassNotFoundException | SQLException e) {
			//创建角色持久层对象 
			e.printStackTrace();
		}
	}

	/**
	 * 查询删除对象
	 */
	@Override
	public void remove(int id) {
		//创建角色持久层对象 
		DialogueDAO dialogueDAO = new DialogueDAO();
		Dialogue diadialogueue = new Dialogue(); //{id=0}
		diadialogueue.setId(id);
		try {
			dialogueDAO.delete(diadialogueue);
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
	}


	/**
	 * 查询单个对象
	 */
	@Override
	public Dialogue find(int id) {
		//创建角色持久层对象 
		DialogueDAO dialogueDAO = new DialogueDAO();
		Dialogue diadialogueue = new Dialogue(); 
		try {
			diadialogueue = dialogueDAO.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return diadialogueue;
	}

	/**
	 * 查询所有对象
	 */
	@Override
	public List<Dialogue> find() {
		//创建角色持久层对象 
		DialogueDAO dialogueDAO = new DialogueDAO();
		List<Dialogue> dialogues = new ArrayList<Dialogue>();
		try {
			dialogues=dialogueDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return dialogues;
	}
	
	@Override
	public List<Dialogue>  findAll(String name, int id) {
		//创建角色持久层对象 
		DialogueDAO dialogueDAO = new DialogueDAO();
		List<Dialogue> dialogues = new ArrayList<Dialogue>();
		try {
			dialogues=dialogueDAO.findAll(name,id);	} 
		catch (ClassNotFoundException | SQLException e) {
			// 把异常轨迹进行打印显示
			e.printStackTrace();
		}
		return dialogues;
	}


}
