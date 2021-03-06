package com.ai.ysm.job.interfaces;


import java.util.List;
import java.util.Map;

import com.ai.ysm.job.entity.ScheduleJobLogEntity;

/**
 * 定时任务日志
 * 
 * @author asiainfo
 *  
 * @date 2016年12月1日 下午10:34:48
 */
public interface ScheduleJobLogService {

	/**
	 * 根据ID，查询定时任务日志
	 */
	ScheduleJobLogEntity queryObject(Long jobId);
	
	/**
	 * 查询定时任务日志列表
	 */
	List<ScheduleJobLogEntity> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存定时任务日志
	 */
	void save(ScheduleJobLogEntity log);
	
}
