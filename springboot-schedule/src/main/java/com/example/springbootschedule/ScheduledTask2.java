package com.example.springbootschedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Title: ScheduledTask2
 * Description: ScheduledTask2
 * Date:  2018/3/16
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */
@Component
public class ScheduledTask2 {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask2.class);

    //可以通过配置文件配置cron参数
    //@Scheduled(cron="20 0/1 * * * ?")
    @Scheduled(cron = "${cron.expression2}")
    public void executeFileDownLoadTask() {

        Thread current = Thread.currentThread();
        logger.info("定时任务2 当前线程id:" + current.getId() + ",name:" + current.getName() + "当前时间：" + new Date());

    }
}
