package com.example.springbootschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling //如果没有ScheduleConfig ，这里需要加注解
public class SpringbootScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootScheduleApplication.class, args);
	}
}
