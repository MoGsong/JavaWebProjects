package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gxnu.dao.RecordDAO;
import com.gxnu.entity.Record;
import com.gxnu.service.IRecordService;

/**
 * 病例表操作对应的业务类
 * @author 
 *业务层需合理调用持久层，完成具体的业务功能
 *处理异常
 */
public class RecordService implements IRecordService {

	@Override
	public void add(Record record) {
		//创建持久层类对象
		RecordDAO recordDAO = new RecordDAO();
		try {
			recordDAO.add(record);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(int id) {
		//删除持久层类对象
		RecordDAO recordDAO = new RecordDAO();
		Record record = new Record();
		record.setId(id);
		try {
			recordDAO.delete(record);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
	}

	@Override
	public void update(Record record) {
		//修改持久层类对象
		RecordDAO recordDAO = new RecordDAO();
		try {
			recordDAO.merge(record);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
	}

	@Override
	public List<Record> find() {
		//查询所有持久层类对象
		RecordDAO recordDAO = new RecordDAO();
		List<Record> records =new ArrayList<Record>();
		//Record[] records =new Record[1];
		try {
			records = recordDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}

	@Override
	public Record find(int id) {
		//查询单个持久层类对象
		RecordDAO recordDAO = new RecordDAO();
		Record record = new Record();
		try {
			record = recordDAO.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			//处理异常，打印异常轨迹
			e.printStackTrace();
		}
		return record;
	}

	@Override
	public List<Record> find(int currentPage, int PageSize) {
		RecordDAO dao=new RecordDAO();		
		List<Record> records=new ArrayList<Record>();
		try {
			records=dao.findAll(currentPage,PageSize);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
	}


}
