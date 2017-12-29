package com.ai.ysm.job.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ai.ysm.job.entity.ScheduleJobEntity;
import com.ai.ysm.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 * 
 * @author asiainfo
 *  
 * @date 2016年12月1日 下午10:29:57
 */
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
	
	List<ScheduleJobEntity> queryList(Map<String, Object> map);
}
