package com.gxnu.service.imp;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.InDetailDAO;
import com.gxnu.entity.InDetail;
import com.gxnu.service.IInDetailService;
/**
 * 入库明细信息业务层
 * @author ymp0519
 *
 */

	public class InDetailService implements IInDetailService{
/**
 * 添加入库明细信息
 * @param inDetail
 */
		@Override
		public void add(InDetail inDetail) {

			InDetailDAO inDetailDAO = new InDetailDAO();
			try {
				inDetailDAO.add(inDetail);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
/**
 * 通过id删除入库明细
 * @param id
 */
		@Override
		public void remove(int id) {

			InDetailDAO inDetailDAO = new InDetailDAO();
			InDetail inDetail = new InDetail();
			inDetail.setId(id);
			try {
				inDetailDAO.delete(inDetail);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
/**
 * 修改入库明细信息
 * @param inDetail
 */
		@Override
		public void update(InDetail inDetail) {
			InDetailDAO inDetailDAO = new InDetailDAO();

			try {
				inDetailDAO.merge(inDetail);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
/**
 * 通过id查找入库明细信息
 * @param id
 * @return
 */
		@Override
		public InDetail find(int id) {

			InDetailDAO inDetailDAO = new InDetailDAO();
			InDetail inDetail = new InDetail();
			inDetail.setId(id);
			try {
				inDetail = inDetailDAO.findById(id);
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
				System.out.println("找不到");
			}
			return inDetail;
		}
/**
 * 寻找所有入库明细信息
 * @return
 */
		@Override
		public List<InDetail> findAll() {

			InDetailDAO inDetailDAO = new InDetailDAO();
	
			
			List<InDetail> inDetails = new ArrayList<InDetail>();
			
			try {
				inDetails = inDetailDAO.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return inDetails;
		}


/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<InDetail> find(int currentPage, int pageSize) {
	
		InDetailDAO inDetailDAO = new InDetailDAO();
		
		
		List<InDetail> inDetails = new ArrayList<InDetail>();
		
		try {
			inDetails = inDetailDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return inDetails;
	}

}
