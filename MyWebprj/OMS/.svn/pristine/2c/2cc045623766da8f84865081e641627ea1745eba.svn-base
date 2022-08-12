package com.gxnu.service.imp;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.dao.InStoreDAO;
import com.gxnu.entity.InStore;
import com.gxnu.service.IInStoreService;
/**
 * 入库信息业务层
 * @author ymp0519
 *
 */

	public class InStoreService implements IInStoreService{
/**
 * 添加入库信息
 * @param inStore
 */
		@Override
		public void add(InStore inStore) {

			InStoreDAO inStoreDAO = new InStoreDAO();
			try {
				inStoreDAO.add(inStore);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
/**
 * 通过id删除入库
 * @param id
 */
		@Override
		public void remove(int id) {

			InStoreDAO inStoreDAO = new InStoreDAO();
			InStore inStore = new InStore();
			inStore.setId(id);
			try {
				inStoreDAO.delete(inStore);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
/**
 * 修改入库信息
 * @param inStore
 */
		@Override
		public void update(InStore inStore) {
			InStoreDAO inStoreDAO = new InStoreDAO();

			try {
				inStoreDAO.merge(inStore);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
/**
 * 通过id查找入库信息
 * @param id
 * @return
 */
		@Override
		public InStore find(int id) {

			InStoreDAO inStoreDAO = new InStoreDAO();
			InStore inStore = new InStore();
			inStore.setId(id);
			try {
				inStore = inStoreDAO.findById(id);
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
				System.out.println("找不到");
			}
			return inStore;
		}
/**
 * 寻找所有入库信息
 * @return
 */
		@Override
		public List<InStore> findAll() {

			InStoreDAO inStoreDAO = new InStoreDAO();
	
			
			List<InStore> inStores = new ArrayList<InStore>();
			
			try {
				inStores = inStoreDAO.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return inStores;
		}


/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 */

	@Override
	public List<InStore> find(int currentPage, int pageSize) {
	
		InStoreDAO inStoreDAO = new InStoreDAO();
		
		
		List<InStore> inStores = new ArrayList<InStore>();
		
		try {
			inStores = inStoreDAO.findAll(currentPage, pageSize);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return inStores;
	}

}
