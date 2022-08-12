package com.gxnu.service.imp;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.ScheduleDAO;
import com.gxnu.entity.Schedule;
import com.gxnu.service.IScheduleService;
/**
 * 排班信息业务层
 * @author ymp0519
 *
 */

	public class ScheduleService implements IScheduleService{
/**
 * 添加排班信息
 * @param schedule
 */
		@Override
		public void add(Schedule schedule) {

			ScheduleDAO scheduleDAO = new ScheduleDAO();
			try {
				scheduleDAO.add(schedule);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
/**
 * 通过id删除排班
 * @param id
 */
		@Override
		public void remove(int id) {

			ScheduleDAO scheduleDAO = new ScheduleDAO();
			Schedule schedule = new Schedule();
			schedule.setId(id);
			try {
				scheduleDAO.delete(schedule);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
/**
 * 修改排班信息
 * @param schedule
 */
		@Override
		public void update(Schedule schedule) {
			ScheduleDAO scheduleDAO = new ScheduleDAO();

			try {
				scheduleDAO.merge(schedule);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
/**
 * 通过id查找排班信息
 * @param id
 * @return
 */
		@Override
		public Schedule find(int id) {

			ScheduleDAO scheduleDAO = new ScheduleDAO();
			Schedule schedule = new Schedule();
			schedule.setId(id);
			try {
				schedule = scheduleDAO.findById(id);
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
				System.out.println("找不到");
			}
			return schedule;
		}
/**
 * 寻找所有排班信息
 * @return
 */
		@Override
		public List<Schedule> findAll() {

			ScheduleDAO scheduleDAO = new ScheduleDAO();
	
			
			List<Schedule> schedules = new ArrayList<Schedule>();
			
			try {
				schedules = scheduleDAO.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return schedules;
		}


/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<Schedule> find(int currentPage, int pageSize) {
	
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		
		try {
			schedules = scheduleDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return schedules;
	}
	
	/**
	 * 寻找某科室内的值班时间段和周天相同的排班
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */

		@Override
		public List<Schedule> find(int week, String period,int unitId) {
		
			ScheduleDAO scheduleDAO = new ScheduleDAO();
			
			
			List<Schedule> schedules = new ArrayList<Schedule>();
			
			try {
				schedules = scheduleDAO.findByWeekByPeriodByUnitId(week, period,unitId);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return schedules;
		}

/**
 * 通过unitId查找对应的排班信息
 */
	@Override
	public List<Schedule> findByDoctorId(int doctorid) {
		
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		
		try {
			schedules = scheduleDAO.findByDoctorId(doctorid);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return schedules;
	}


/**
 * 寻找某医生的值班时间段和周天相同的排班
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<Schedule> findByWeekByPeriodByDoctorId(int week, String period, int doctorId) {
	
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		
		try {
			schedules = scheduleDAO.findByWeekByPeriodByDoctorId(week, period,doctorId);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return schedules;
	}

}
