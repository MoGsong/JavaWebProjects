package com.gxnu.service;

import java.sql.SQLException;

public interface IDrawService {
	public int find(String time, int unitid ) throws ClassNotFoundException, SQLException;
}
