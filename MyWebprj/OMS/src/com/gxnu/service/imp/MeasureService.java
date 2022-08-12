package com.gxnu.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.MeasureDAO;
import com.gxnu.entity.Measure;
import com.gxnu.service.IMeasureService;

public class MeasureService implements IMeasureService {

	@Override
	public void add(Measure measure) {
		MeasureDAO md = new MeasureDAO();
		try {
			md.add(measure);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		MeasureDAO md = new MeasureDAO();
		try {
			md.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Measure measure) {
		MeasureDAO md = new MeasureDAO();
		try {
			md.merge(measure);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Measure find(int id) {
		MeasureDAO md = new MeasureDAO();
		Measure measure = new Measure();
		try {
			measure = md.findById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return measure;
	}

	@Override
	public List<Measure> find() {
		// TODO Auto-generated method stub
		List<Measure> measures = new ArrayList<Measure>();
		MeasureDAO md = new MeasureDAO();
		try {
			measures = md.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return measures;
	}

}
