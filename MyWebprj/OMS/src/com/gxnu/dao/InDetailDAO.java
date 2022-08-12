package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gxnu.entity.InDetail;
import com.gxnu.entity.InStore;
import com.gxnu.entity.Inventory;
import com.gxnu.dao.InventoryDAO;


/**
 * 入库明细信息持久层
 * @author ymp0519
 *
 */


public class InDetailDAO  extends C3P0BaseDAO{

/**
 * 入库明细信息的添加
 * @param InDetail
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public void add(InDetail inDetail) throws ClassNotFoundException, SQLException {
		
		Connection conn = super.getConnection();

		PreparedStatement pstmt = 
				conn.prepareStatement("insert into in_detail (in_store,inventory,price,num,yuliu) values(?,?,?,?,?)");

		pstmt.setInt(1,inDetail.getInStore().getId());
		pstmt.setInt(2,inDetail.getInventory().getId());
		pstmt.setInt(3,inDetail.getPrice());
		pstmt.setInt(4,inDetail.getNum());
		pstmt.setString(5, inDetail.getYuliu());
		
		pstmt.executeUpdate();
	
		super.closeConnection(conn);
	}

/**
 * 入库明细信息的修改
 * @param InDetail
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public void merge(InDetail inDetail) throws ClassNotFoundException, SQLException {
		
		Connection conn = super.getConnection();
		PreparedStatement pstmt = 
				conn.prepareStatement("update in_detail set in_store=?,inventory=?,price=?,num=?,yuliu=? where id=?");
		
		pstmt.setInt(1,inDetail.getInStore().getId());
		pstmt.setInt(2,inDetail.getInventory().getId());
		pstmt.setInt(3,inDetail.getPrice());
		pstmt.setInt(4,inDetail.getNum());
		pstmt.setString(5, inDetail.getYuliu());
		pstmt.setInt(6,inDetail.getId());//id
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
/**
 * 入库明细信息的修改
 * @param InDetail
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public void delete(InDetail inDetail) throws ClassNotFoundException, SQLException {
		
		Connection conn = super.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from in_detail where id=?");
		pstmt.setInt(1, inDetail.getId());
		pstmt.executeUpdate();
		super.closeConnection(conn);
	}
	
	/**
	 * 通过id查找入库明细
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public InDetail findById(int id) throws ClassNotFoundException, SQLException {
		
		Connection conn = super.getConnection();
		

		InDetail InDetail  = new InDetail();
		PreparedStatement pstmt = conn.prepareStatement("select * from in_detail where id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){ 
			int inStore_id = rs.getInt("in_store");  
			int inventory_id = rs.getInt("inventory");
			int price= rs.getInt("price");
			int num =rs.getInt("num");
			String yuliu= rs.getString("yuliu");

			InStoreDAO inStoreDAO = new InStoreDAO();
			InStore inStore=inStoreDAO.findById(inStore_id);
			
			InventoryDAO inventoryDAO = new InventoryDAO();
			Inventory inventory = inventoryDAO.findById(inventory_id);
			
			InDetail= new InDetail(id,inStore,inventory,price,num,yuliu);
			}  
			rs.close(); 
			
		
		super.closeConnection(conn);
		return InDetail;
	}

	/**
	 * 查询所有入库明细信息
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<InDetail> findAll() throws ClassNotFoundException, SQLException {
		
		Connection conn = super.getConnection();
		
		List<InDetail> InDetails = new ArrayList<InDetail>();
		
		int i = 0;
		
		PreparedStatement pstmt = conn.prepareStatement("select * from in_detail");
	
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){  
			int id = rs.getInt("id");
			int inStore_id = rs.getInt("in_store");  
			int inventory_id = rs.getInt("inventory");
			int price= rs.getInt("price");
			int num =rs.getInt("num");
			String yuliu= rs.getString("yuliu");

			InStoreDAO inStoreDAO = new InStoreDAO();
			InStore inStore=inStoreDAO.findById(inStore_id);
			
			InventoryDAO inventoryDAO = new InventoryDAO();
			Inventory inventory = inventoryDAO.findById(inventory_id);


			InDetails.add( new InDetail(id,inStore,inventory,price,num,yuliu));
			
			}  
			rs.close(); 
			
		
		super.closeConnection(conn);
		return InDetails;
	}
	
	
/**
 * 分页
 * @param currentPage
 * @param pageSize
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public List<InDetail> findAll(int currentPage, int pageSize) throws ClassNotFoundException, SQLException {
		
		Connection conn = super.getConnection();
		

		List<InDetail> InDetails = new ArrayList<InDetail>();
		
		int i = 0;
		
		PreparedStatement pstmt = conn.prepareStatement("select * from in_detail limit ?,?");
		pstmt.setInt(1,(currentPage-1)*pageSize);
		pstmt.setInt(2,pageSize);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){  
			int id = rs.getInt("id");
			int inStore_id = rs.getInt("in_store");  
			int inventory_id = rs.getInt("inventory");
			int price= rs.getInt("price");
			int num =rs.getInt("num");
			String yuliu= rs.getString("yuliu");

			InStoreDAO inStoreDAO = new InStoreDAO();
			InStore inStore=inStoreDAO.findById(inStore_id);
			
			InventoryDAO inventoryDAO = new InventoryDAO();
			Inventory inventory = inventoryDAO.findById(inventory_id);
			
			InDetails.add( new InDetail(id,inStore,inventory,price,num,yuliu));
			}  
			rs.close(); 
			
		
		super.closeConnection(conn);
		return InDetails;
	}
	
	
}
