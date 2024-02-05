package com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author OperationTime
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "operation_time")
@ToString
public class OperationTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int count;

    private int power;
    
    private int expansionValve;

    private Date createdAt;

    private long thingId;
    
    private String unitId;
    
    private String unit_id_count;
    
    public static OperationTime builder() {
    	return new OperationTime();
    }
    
}
