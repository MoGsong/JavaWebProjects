package com.gxnu.service.imp;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.UnitDAO;
import com.gxnu.entity.Unit;
import com.gxnu.service.IUnitService;
/**
 * 科室信息业务层
 * @author ymp0519
 *
 */

	public class UnitService implements IUnitService{
/**
 * 添加科室信息
 * @param unit
 */
		@Override
		public void add(Unit unit) {

			UnitDAO unitDAO = new UnitDAO();
			try {
				unitDAO.add(unit);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
/**
 * 通过id删除科室
 * @param id
 */
		@Override
		public void remove(int id) {

			UnitDAO unitDAO = new UnitDAO();
			Unit unit = new Unit();
			unit.setId(id);
			try {
				unitDAO.delete(unit);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
/**
 * 修改科室信息
 * @param unit
 */
		@Override
		public void update(Unit unit) {
			UnitDAO unitDAO = new UnitDAO();

			try {
				unitDAO.merge(unit);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
/**
 * 通过id查找科室信息
 * @param id
 * @return
 */
		@Override
		public Unit find(int id) {

			UnitDAO unitDAO = new UnitDAO();
			Unit unit = new Unit();
			unit.setId(id);
			try {
				unit = unitDAO.findById(id);
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
				System.out.println("找不到");
			}
			return unit;
		}
/**
 * 寻找所有科室信息
 * @return
 */
		@Override
		public List<Unit> findAll() {

			UnitDAO unitDAO = new UnitDAO();
	
			
			List<Unit> units = new ArrayList<Unit>();
			
			try {
				units = unitDAO.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return units;
		}


/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<Unit> find(int currentPage, int pageSize) {
	
		UnitDAO unitDAO = new UnitDAO();
		
		
		List<Unit> units = new ArrayList<Unit>();
		
		try {
			units = unitDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return units;
	}

}
