package com.gavin.sharding.sphere.jdbc.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gavin.poc.sharding.sphere.jdbc.ShardingSphereJdbcDemoApplication;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.OperationTimeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereJdbcDemoApplication.class)
class ShardingSphereJdbcDemoApplicationTests {

	@Autowired
    private OperationTimeService operationTimeService;
	
	private Date string2Date(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(dateString);
		return date;
	}

	/**
     * Simulation of data insert: table operation_time
     */
    @Test
    public void testInsertForOp(){
        for (int i = 13; i <= 15; i++) {
        	try {
        		OperationTime operationTime = new OperationTime();
        		operationTime.setCount(i);
        		operationTime.setThingId(i);
        		operationTime.setUnitId(String.valueOf(i));
//        		operationTime.setUnitIdCount(i *10);
        		operationTime.setCreatedAt(new Date());
        		operationTime.setPower(0);
        		operationTimeService.insert(operationTime);
        		
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        }
    }
    
    
    /**
     * Simulation of read-write split
     */
    @Test
    public void testSelectByThingId(){
    	try {
    		List<OperationTime>  result = operationTimeService.selectByThingId(1);
    		for (OperationTime item : result) {
    			System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Simulation of read-write split
     */
    @Test
    public void testComplexSelect(){
    	try {
    		List<Map<Object,Object>>  result = operationTimeService.selectByParams(2l,string2Date("2024-01-08"),string2Date("2024-02-08"),2);
    		for (Map<Object, Object>  value :result) {
    			for (Object key: value.keySet()) {
    				System.out.println(key+","+value.get(key));
				}
    			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
