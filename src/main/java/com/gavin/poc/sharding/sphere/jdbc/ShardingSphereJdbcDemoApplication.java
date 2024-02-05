package com.gavin.poc.sharding.sphere.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Gavin
 */
@ComponentScan(basePackages = "com.gavin.poc.sharding.sphere.jdbc")
@EntityScan(basePackages = "com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity")
@EnableJpaRepositories({"com.gavin.poc.sharding.sphere.jdbc.demo.repository"})
@SpringBootApplication
public class ShardingSphereJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcDemoApplication.class, args);
    }

}
