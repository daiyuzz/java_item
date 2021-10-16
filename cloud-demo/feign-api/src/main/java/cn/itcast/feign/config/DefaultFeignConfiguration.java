package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Created by dyx on 2021/10/16
 */
public class DefaultFeignConfiguration {
    // 需要启动类上加全局注解才可以生效
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

}
