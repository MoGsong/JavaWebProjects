package com.gxnu.service;

import java.util.List;

import com.gxnu.entity.Role;

/**
 * 瑙掕壊涓氬姟鎺ュ彛
 * @author 鑳栧瓙涓嶉湶灏忛厭绐�
 *涓氬姟灞傞�氬父璋冪敤鎸佷箙灞傛柟娉曪紝瀹屾垚鍏蜂綋鐨勪笟鍔″姛鑳�
 */
public interface IRoleService {
	//娣诲姞瑙掕壊
	public void add(Role role);
	//鍒犻櫎瑙掕壊
	public void remove(int id);
	//淇敼瑙掕壊
	public void update(Role role);
	//鏌ヨ瑙掕壊锛屽崟涓�
	public Role find(int id);
	//鏌ヨ瑙掕壊锛屾墍鏈�
	public List<Role> find();
}
