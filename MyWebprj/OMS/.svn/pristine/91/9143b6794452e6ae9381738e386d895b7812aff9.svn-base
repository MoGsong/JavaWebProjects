package com.gxnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxnu.entity.Operator;
import com.gxnu.entity.Role;
import com.gxnu.entity.Operator;
/**
 * 鎿嶄綔鍛樿〃鐨凜URD鎿嶄綔
 * @author johny
 * 鎸佷箙灞傜被
 */
public class OperatorDAO extends C3P0BaseDAO {
	/**
	 * 娣诲姞鎿嶄綔鍛�
	 * @param operator 琛ㄧず寰呮坊鍔犵殑鎿嶄綔鍛樹俊鎭紝褰㈠锛歿id=1,name=璁垮}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void add(Operator operator) throws ClassNotFoundException, SQLException {
		//1銆佸姞杞介┍鍔� 2銆佽繛鎺bacpro鏁版嵁搴�
		Connection conn = super.getConnection();
		//3銆佸熀浜庢暟鎹簱杩炴帴瀵硅薄 java.sql.Connection,鍒涘缓鏁版嵁搴撴搷浣滃璞ava.sql.PreparedStatement锛岄』缁戝畾涓�涓猄QL璇彞
		//姝ゅ鐨勶紵琛ㄧず鈥滃崰浣嶇鈥濓紝涓嬫爣浠�1寮�濮嬮�掑锛岄』鍦ㄥ悗缁缃叾鍊�
		PreparedStatement pstmt = 
				conn.prepareStatement("insert into operator(username,password,tel,email,pic,role) values(?,?,?,?,?,?)");
		//璁剧疆鐐逛綅绗︾殑鍊�,娉ㄦ剰鏁版嵁绫诲瀷鐨勯�夋嫨
		pstmt.setString(1,operator.getUsername());
		pstmt.setString(2,operator.getPassword());
		pstmt.setString(3,operator.getTel());
		pstmt.setString(4,operator.getEmail());
		pstmt.setString(5,operator.getPic());
		pstmt.setInt(6,operator.getRole().getId());  //瀵艰埅閾� 锛屽彲浠ヨ幏鍙栧叧鑱斿璞′腑鐨勮缁嗕俊鎭�
		//鎵цSQL璇彞,缁撴灉浼氬悓姝ュ埌mysql琛ㄤ腑
		pstmt.executeUpdate();
		//鍏抽棴鏁版嵁搴撹繛鎺�
		super.closeConnection(conn);
	}
	/**
	 * 淇敼鎿嶄綔鍛�
	 * @param operator 琛ㄧず淇敼鍚庣殑鎿嶄綔鍛樹俊鎭紝褰㈠锛歿id=3,name=瓒呯}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Operator operator) throws ClassNotFoundException, SQLException {
		//1銆佸姞杞介┍鍔� 2銆佽繛鎺bacpro鏁版嵁搴�
		Connection conn = super.getConnection();
		//3銆佸熀浜庢暟鎹簱杩炴帴瀵硅薄 java.sql.Connection,鍒涘缓鏁版嵁搴撴搷浣滃璞ava.sql.PreparedStatement锛岄』缁戝畾涓�涓猄QL璇彞
		//姝ゅ鐨勶紵琛ㄧず鈥滃崰浣嶇鈥濓紝涓嬫爣浠�1寮�濮嬮�掑锛岄』鍦ㄥ悗缁缃叾鍊�
		PreparedStatement pstmt = 
				conn.prepareStatement("update operator set password=?,tel=?,email=?,pic=?,role=? where id=?");
		//璁剧疆鐐逛綅绗︾殑鍊�,娉ㄦ剰鏁版嵁绫诲瀷鐨勯�夋嫨
		pstmt.setString(1,operator.getPassword());
		pstmt.setString(2,operator.getTel());
		pstmt.setString(3,operator.getEmail());
		pstmt.setString(4,operator.getPic());
		pstmt.setInt(5,operator.getRole().getId());//瀵艰埅閾�  锛屽彲浠ヨ幏鍙栧叧鑱斿璞′腑鐨勮缁嗕俊鎭�
		pstmt.setInt(6, operator.getId());
		//鎵цSQL璇彞,缁撴灉浼氬悓姝ュ埌mysql琛ㄤ腑
		pstmt.executeUpdate();
		//鍏抽棴鏁版嵁搴撹繛鎺�
		super.closeConnection(conn);
	}
	
	/**
	 * 鍒犻櫎鎿嶄綔鍛�
	 * @param operator 琛ㄧず鍒犻櫎鐨勬搷浣滃憳淇℃伅锛屽舰濡傦細{id=3,name=null}
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(Operator operator) throws ClassNotFoundException, SQLException {
		//1銆佸姞杞介┍鍔� 2銆佽繛鎺bacpro鏁版嵁搴�
		Connection conn = super.getConnection();
		//3銆佸熀浜庢暟鎹簱杩炴帴瀵硅薄 java.sql.Connection,鍒涘缓鏁版嵁搴撴搷浣滃璞ava.sql.PreparedStatement锛岄』缁戝畾涓�涓猄QL璇彞
		//姝ゅ鐨勶紵琛ㄧず鈥滃崰浣嶇鈥濓紝涓嬫爣浠�1寮�濮嬮�掑锛岄』鍦ㄥ悗缁缃叾鍊�
		PreparedStatement pstmt = 
				conn.prepareStatement("delete from operator where id=?");
		//璁剧疆鐐逛綅绗︾殑鍊�,娉ㄦ剰鏁版嵁绫诲瀷鐨勯�夋嫨
		pstmt.setInt(1, operator.getId());
		//鎵цSQL璇彞,缁撴灉浼氬悓姝ュ埌mysql琛ㄤ腑
		pstmt.executeUpdate();
		//鍏抽棴鏁版嵁搴撹繛鎺�
		super.closeConnection(conn);
	}
	//鏌ヨ鎿嶄綔鍛�
	
	/**
	 * 鏌ヨ瑙掕壊锛屾煡鎵�鏈�
	 * @return 鎶婄粨鏋滈泦涓殑鎵�鏈夎褰曪紝鍖呰鎴恛perator瀵硅薄锛屽啀瀛樻斁鍒版暟缁勪腑
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Operator> findAll() throws ClassNotFoundException, SQLException {
		//瀹氫箟鏁扮粍
		List<Operator> operators = new ArrayList<Operator>(); //榛樿姣忎釜鍏冪礌鍧囦负null
		int i = 0;
		//1銆佸姞杞介┍鍔� 2銆佽繛鎺bacpro鏁版嵁搴�
		Connection conn = super.getConnection();
		//3銆佸熀浜庢暟鎹簱杩炴帴瀵硅薄 java.sql.Connection,鍒涘缓鏁版嵁搴撴搷浣滃璞ava.sql.PreparedStatement锛岄』缁戝畾涓�涓猄QL璇彞
		//姝ゅ鐨勶紵琛ㄧず鈥滃崰浣嶇鈥濓紝涓嬫爣浠�1寮�濮嬮�掑锛岄』鍦ㄥ悗缁缃叾鍊�
		PreparedStatement pstmt = conn.prepareStatement("select * from operator");
		//4銆佸熀浜庢暟鎹搷浣滃璞ava.sql.PreparedStatement锛屽垱寤烘暟鎹簱缁撴灉闆嗗璞ava.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//閫氳繃寰幆閬嶅巻缁撴灉闆�
		while(rs.next()) {
			//姣忓惊鐜竴娆★紝鑾峰彇鎸囬拡瀹氫綅鐨勬煇鏉¤褰曚笂鐨勬暟鎹�

			//Role role = new RoleDAO().findByPrimaryKey(rs.getInt("role"));
			operators.add(new Operator(rs.getInt("id"), rs.getString("username"), rs.getString("password"),rs.getString("tel"),rs.getString("email"), 
					rs.getString("pic"),new RoleDAO().findByPrimaryKey(rs.getInt("role"))));
		}
		//杩斿洖鏁扮粍
		super.closeConnection(conn);
		return operators;
	}
	
	/**
	 * 鏌ヨ瑙掕壊锛屾煡鍗曚釜
	 * @return 鎶婄粨鏋滈泦涓殑鎵�鏈夎褰曪紝鍖呰鎴恛perator瀵硅薄锛屽啀瀛樻斁鍒版暟缁勪腑
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Operator findByPrimaryKey(int id) throws ClassNotFoundException, SQLException {
		Operator operator = new Operator();
		//1銆佸姞杞介┍鍔� 2銆佽繛鎺bacpro鏁版嵁搴�
		Connection conn = super.getConnection();
		//3銆佸熀浜庢暟鎹簱杩炴帴瀵硅薄 java.sql.Connection,鍒涘缓鏁版嵁搴撴搷浣滃璞ava.sql.PreparedStatement锛岄』缁戝畾涓�涓猄QL璇彞
		//姝ゅ鐨勶紵琛ㄧず鈥滃崰浣嶇鈥濓紝涓嬫爣浠�1寮�濮嬮�掑锛岄』鍦ㄥ悗缁缃叾鍊�
		PreparedStatement pstmt = conn.prepareStatement("select * from operator where id=?");
		pstmt.setInt(1,id);
		//4銆佸熀浜庢暟鎹搷浣滃璞ava.sql.PreparedStatement锛屽垱寤烘暟鎹簱缁撴灉闆嗗璞ava.sql.ResultSet
		ResultSet rs = pstmt.executeQuery();
		
		//鍥犱负缁撴灉闆嗕腑鍙湁涓�鏉¤褰曪紝鏃犻渶寰幆閬嶅巻缁撴灉闆嗭紝鍙渶瑕佽鎸囬拡绉诲姩涓�娆″嵆鍙�
		if(rs.next()) {
			//姣忓惊鐜竴娆★紝鑾峰彇鎸囬拡瀹氫綅鐨勬煇鏉¤褰曚笂鐨勬暟鎹�
			int operatorid = rs.getInt("id");  //id涓哄瓧娈靛悕绉� 
			String name = rs.getString("username"); //username涓哄瓧娈靛悕绉�
			String password = rs.getString("password"); //password涓哄瓧娈靛悕绉�
			String tel = rs.getString("tel"); //tel涓哄瓧娈靛悕绉�
			String email = rs.getString("email"); 
			String pic = rs.getString("pic"); //pic涓哄瓧娈靛悕绉�
			int roleid = rs.getInt("role"); //role涓哄瓧娈靛悕绉�,鎿嶄綔鍛樿〃涓殑澶栭敭
			//鏍规嵁澶栭敭涓婄殑瑙掕壊缂栧彿锛屾煡鎵惧畬鏁磋鑹蹭俊鎭紙瑙掕壊瀹炰綋绫诲璞� 锛�
			RoleDAO roleDAO = new RoleDAO();
			Role role = roleDAO.findByPrimaryKey(roleid);
			
			operator = new Operator(operatorid, name,password,tel,email,pic,role); //鎶婃暟鎹寘瑁呮垚Operator瀹炰綋瀵硅薄
		}
		//杩斿洖鏁扮粍
		super.closeConnection(conn);
		return operator;
		
	}
	

}
