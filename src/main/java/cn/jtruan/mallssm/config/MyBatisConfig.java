package cn.jtruan.mallssm.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cn.jtruan.mallssm.mbg.mapper", "cn.jtruan.mallssm.dao"})
public class MyBatisConfig {
}
