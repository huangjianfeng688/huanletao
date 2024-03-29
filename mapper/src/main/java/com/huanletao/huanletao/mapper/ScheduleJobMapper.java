package com.huanletao.huanletao.mapper;

import com.huanletao.huanletao.entity.ScheduleJob;

import java.util.List;

public interface ScheduleJobMapper {
	int deleteByPrimaryKey(Long jobId);

	int insert(ScheduleJob record);

	int insertSelective(ScheduleJob record);

	ScheduleJob selectByPrimaryKey(Long jobId);

	int updateByPrimaryKeySelective(ScheduleJob record);

	int updateByPrimaryKey(ScheduleJob record);

	List<ScheduleJob> getAll();
}