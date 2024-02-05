package com.gavin.poc.sharding.sphere.jdbc.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;

@Repository
public interface OperationTimeRepository extends JpaRepository<OperationTime, Long> {
	@Query(value ="SELECT count(unitId) AS unit_id_count, \r\n"
			+ "			thingId as thingId, \r\n"
			+ "			unitId  as unitId\r\n"
			+ "			from OperationTime \r\n"
			+ "			WHERE thingId = :thingId \r\n"
			+ "			AND createdAt >= :startDate AND createdAt <= :endDate \r\n"
			+ "			AND power = :power \r\n"
			+ "			GROUP BY thingId , unitId")
	public List<Map<Object,Object>> selectByParams(@Param("thingId") long thingId, @Param("startDate") Date startDate,@Param("endDate") Date endDate, @Param("power") int power);
}