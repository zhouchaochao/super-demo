package com.example.springbootschedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Title: ScheduledTask1
 * Description: ScheduledTask1
 * Date:  2018/3/16
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */
@Component
public class ScheduledTask1 {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask1.class);

    //可以通过配置文件配置cron参数
    //@Scheduled(cron="${cron.expression1}")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void executeFileDownLoadTask() {

        // 间隔2分钟,执行任务
        Thread current = Thread.currentThread();
        //System.out.println("定时任务1:"+current.getId());
        System.out.println("定时任务1 当前线程id:" + current.getId() + ",name:" + current.getName() + "当前时间：" + new Date());

    }

}
