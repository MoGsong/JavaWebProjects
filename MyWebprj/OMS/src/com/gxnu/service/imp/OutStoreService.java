package com.gxnu.service.imp;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.OutStoreDAO;
import com.gxnu.entity.OutStore;
import com.gxnu.service.IOutStoreService;
/**
 * 出库信息业务层
 * @author ymp0519
 *
 */

	public class OutStoreService implements IOutStoreService{
/**
 * 添加出库信息
 * @param outStore
 */
		@Override
		public void add(OutStore outStore) {

			OutStoreDAO outStoreDAO = new OutStoreDAO();
			try {
				outStoreDAO.add(outStore);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
/**
 * 通过id删除出库
 * @param id
 */
		@Override
		public void remove(int id) {

			OutStoreDAO outStoreDAO = new OutStoreDAO();
			try {
				outStoreDAO.delete(id);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
/**
 * 修改出库信息
 * @param outStore
 */
		@Override
		public void update(OutStore outStore) {
			OutStoreDAO outStoreDAO = new OutStoreDAO();

			try {
				outStoreDAO.merge(outStore);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
/**
 * 通过id查找出库信息
 * @param id
 * @return
 */
		@Override
		public OutStore find(int id) {

			OutStoreDAO outStoreDAO = new OutStoreDAO();
			OutStore outStore = new OutStore();
			outStore.setId(id);
			try {
				outStore = outStoreDAO.findById(id);
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
				System.out.println("找不到");
			}
			return outStore;
		}
/**
 * 寻找所有出库信息
 * @return
 */
		@Override
		public List<OutStore> findAll() {

			OutStoreDAO outStoreDAO = new OutStoreDAO();
	
			
			List<OutStore> outStores = new ArrayList<OutStore>();
			
			try {
				outStores = outStoreDAO.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return outStores;
		}


/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<OutStore> find(int currentPage, int pageSize) {
	
		OutStoreDAO outStoreDAO = new OutStoreDAO();
		
		
		List<OutStore> outStores = new ArrayList<OutStore>();
		
		try {
			outStores = outStoreDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return outStores;
	}

}
