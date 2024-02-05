package com.gavin.poc.sharding.sphere.jdbc.demo.domain.vo;

import java.util.Date;

import lombok.ToString;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author OperationTime
 */
@ToString
public class OperationTimeView{

    private Long id;

    private int count;

    private int power;
    
    private int expansionValve;

    private Date createdAt;

    private long thingId;
    
    private String unitId;
    
    private String unit_id_count;
    
}
