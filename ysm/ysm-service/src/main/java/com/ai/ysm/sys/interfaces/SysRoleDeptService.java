package com.ai.ysm.sys.interfaces;

import java.util.List;


/**
 * 角色与部门对应关系
 * 
 * @author asiainfo
 *  
 * @date 2017年6月21日 23:42:30
 */
public interface SysRoleDeptService {
	
	void saveOrUpdate(Long roleId, List<Long> deptIdList);
	
	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long roleId);
	
}
