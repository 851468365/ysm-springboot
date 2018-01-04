package com.ai.ysm.generator.interfaces;

import com.ai.ysm.generator.entity.ChannelUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author asiainfo
 *  
 * @date 2018-01-03 15:37:17
 */
public interface ChannelUserService {
	
	ChannelUserEntity queryObject(Long id);
	
	List<ChannelUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChannelUserEntity channelUser);
	
	void update(ChannelUserEntity channelUser);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
