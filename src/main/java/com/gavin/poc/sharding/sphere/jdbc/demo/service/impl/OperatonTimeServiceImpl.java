package com.gavin.poc.sharding.sphere.jdbc.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;
import com.gavin.poc.sharding.sphere.jdbc.demo.repository.OperationTimeRepository;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.OperationTimeService;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author Gavin
 */
@Service
public class OperatonTimeServiceImpl implements OperationTimeService {
  
	@Autowired
	private OperationTimeRepository operationTimeRepository;

	@Override
	public void insert(OperationTime vo) {
		operationTimeRepository.save(vo);
	}

	@Override
	public  List<Map<Object,Object>> selectByParams(long thingId, Date startDate, Date endDate, int power) {
		List<Map<Object,Object>> result = operationTimeRepository.selectByParams(thingId,startDate,endDate,power);
		return result;
	}

	@Override
	public List<OperationTime> selectByThingId(long thingId) {
		OperationTime op = OperationTime.builder().setThingId(thingId);
		ExampleMatcher matcher = ExampleMatcher.matching() 
                .withMatcher("thingid", GenericPropertyMatchers.exact()) 
                .withIgnorePaths("focus"); 
        
        //创建实例
        Example<OperationTime> ex = Example.of(op, matcher); 
		
        List<OperationTime> selectByThingId = operationTimeRepository.findAll(ex);
		return selectByThingId;
	}
    
    
}
