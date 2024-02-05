package com.gavin.poc.sharding.sphere.jdbc.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author Gavin
 */
public interface OperationTimeService{

    void insert(OperationTime vo);
    
    public List<OperationTime> selectByThingId(long thingId);
    
    List<Map<Object,Object>> selectByParams(long thingId, Date startDate, Date endDate, int power);
}
