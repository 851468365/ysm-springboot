package com.ai.ysm.oss.interfaces;

import java.util.List;
import java.util.Map;

import com.ai.ysm.oss.entity.SysOssEntity;

/**
 * 文件上传
 * 
 * @author asiainfo
 *  
 * @date 2017-03-25 12:13:26
 */
public interface SysOssService {
	
	SysOssEntity queryObject(Long id);
	
	List<SysOssEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOssEntity sysOss);
	
	void update(SysOssEntity sysOss);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
