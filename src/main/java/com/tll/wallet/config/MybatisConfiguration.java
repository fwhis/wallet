package com.tll.wallet.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Mybatis的配置类
 *
 * @author java@fwh
 * @version 0.0.1
 */
@Slf4j
@Configuration
@MapperScan("com.tll.wallet.mapper")
public class MybatisConfiguration {

    public MybatisConfiguration() {
        log.debug("创建配置类对象：MybatisConfiguration");
    }




}
