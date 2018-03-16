package com.example.springbootschedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Title: ScheduleConfig
 * Description: ScheduleConfig
 * Date:  2018/3/16
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleConfig.class);

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        //线程池大小
        scheduler.setPoolSize(10);
        //线程名字前缀
        scheduler.setThreadNamePrefix("spring-task-thread");
        return scheduler;
    }

}
