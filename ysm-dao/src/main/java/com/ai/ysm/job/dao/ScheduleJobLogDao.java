package com.ai.ysm.job.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ai.ysm.job.entity.ScheduleJobLogEntity;
import com.ai.ysm.sys.dao.BaseDao;

/**
 * 定时任务日志
 * 
 * @author asiainfo
 *  
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
