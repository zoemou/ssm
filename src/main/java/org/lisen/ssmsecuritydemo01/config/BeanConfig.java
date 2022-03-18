package org.lisen.ssmsecuritydemo01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.session.HttpSessionEventPublisher;


/**
 * @Version 1.0.0
 * @Date 2022-03-10 15:10
 * @Created by lisen
 */
@Configuration
public class BeanConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    Logger logger(){
        return LoggerFactory.getLogger(getClass());
    }
    @Bean
    HttpSessionRequestCache httpSessionRequestCache(){
        return new HttpSessionRequestCache();
    }

    @Bean
    DefaultRedirectStrategy defaultRedirectStrategy(){
        return new DefaultRedirectStrategy();
    }


}
