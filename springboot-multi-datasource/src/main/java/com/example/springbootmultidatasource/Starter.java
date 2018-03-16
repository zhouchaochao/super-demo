package com.example.springbootmultidatasource;

import com.example.springbootmultidatasource.mapper.datasource1.UserMapper;
import com.example.springbootmultidatasource.mapper.datasource2.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Title: Starter
 * Description: Starter
 * Date:  2018/3/16
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */
@Component
public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;


    @PostConstruct
    public void start() {

        try {

            int i = 1;
            while (i++ < 1000) {
                logger.info("执行次数：" + i);


                int insertCount1 = userMapper.insert("name" + i, "" + System.currentTimeMillis(), "1");
                int insertCount2 = companyMapper.insert("name" + i, "1");
                logger.info("insertCount1:" + insertCount1 + " insertCount2:" + insertCount2);

                if (i % 10 == 0) {
                    int deleteCount1 = userMapper.deleteAll();
                    int deleteCount2 = companyMapper.deleteAll();
                    logger.info("deleteCount1:" + deleteCount1 + " deleteCount2:" + deleteCount2);
                }

                Thread.sleep(5000);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
