package com.gxnu.service.imp;

import java.sql.SQLException;

import com.gxnu.dao.DrawDAO;
import com.gxnu.service.IDrawService;

public class DrawService implements IDrawService {

	@Override
	public int find(String time, int unitid) throws ClassNotFoundException, SQLException {
		DrawDAO drawDAO = new DrawDAO ();
		int sum = drawDAO.find(time,unitid);
		return sum;
	}
        
}
