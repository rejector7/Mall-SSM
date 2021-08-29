package cn.jtruan.mallssm.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Async
public class ScheduleTaskMultiThread {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskMultiThread.class);

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduledTask01(){
        logger.info("线程名称：{}", Thread.currentThread().getName());
    }

    @Scheduled(fixedRate = 5000)
    public void scheduledTask02(){
        logger.info("线程名称：{}", Thread.currentThread().getName());
    }
}
