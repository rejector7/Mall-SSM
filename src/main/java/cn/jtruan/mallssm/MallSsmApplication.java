package cn.jtruan.mallssm;

import cn.jtruan.mallssm.component.ScheduleTaskMultiThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MallSsmApplication {

    private static final Logger logger = LoggerFactory.getLogger(MallSsmApplication.class);
    public static void main(String[] args) {
        logger.info("主线程名称：{}", Thread.currentThread().getName());
        SpringApplication.run(MallSsmApplication.class, args);
    }

}
