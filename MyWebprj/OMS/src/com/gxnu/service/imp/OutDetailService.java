package com.gxnu.service.imp;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.OutDetailDAO;
import com.gxnu.entity.OutDetail;
import com.gxnu.service.IOutDetailService;
/**
 * 出库明细信息业务层
 * @author ymp0519
 *
 */

	public class OutDetailService implements IOutDetailService{
/**
 * 添加出库明细信息
 * @param outDetail
 */
		@Override
		public void add(OutDetail outDetail) {

			OutDetailDAO outDetailDAO = new OutDetailDAO();
			try {
				outDetailDAO.add(outDetail);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
/**
 * 通过id删除出库明细
 * @param id
 */
		@Override
		public void remove(int id) {

			OutDetailDAO outDetailDAO = new OutDetailDAO();
			try {
				outDetailDAO.delete(id);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
/**
 * 修改出库明细信息
 * @param outDetail
 */
		@Override
		public void update(OutDetail outDetail) {
			OutDetailDAO outDetailDAO = new OutDetailDAO();

			try {
				outDetailDAO.merge(outDetail);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
/**
 * 通过id查找出库明细信息
 * @param id
 * @return
 */
		@Override
		public OutDetail find(int id) {

			OutDetailDAO outDetailDAO = new OutDetailDAO();
			OutDetail outDetail = new OutDetail();
			outDetail.setId(id);
			try {
				outDetail = outDetailDAO.findById(id);
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
				System.out.println("找不到");
			}
			return outDetail;
		}
/**
 * 寻找所有出库明细信息
 * @return
 */
		@Override
		public List<OutDetail> findAll() {

			OutDetailDAO outDetailDAO = new OutDetailDAO();
	
			
			List<OutDetail> outDetails = new ArrayList<OutDetail>();
			
			try {
				outDetails = outDetailDAO.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return outDetails;
		}


/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<OutDetail> find(int currentPage, int pageSize) {
	
		OutDetailDAO outDetailDAO = new OutDetailDAO();
		
		
		List<OutDetail> outDetails = new ArrayList<OutDetail>();
		
		try {
			outDetails = outDetailDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return outDetails;
	}

}
