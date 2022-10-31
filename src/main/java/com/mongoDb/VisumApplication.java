package com.mongoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mongoDb.repository")
//@ComponentScan(basePackages = {"com.mongoDb.entity"})
public class VisumApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisumApplication.class, args);
    }

}