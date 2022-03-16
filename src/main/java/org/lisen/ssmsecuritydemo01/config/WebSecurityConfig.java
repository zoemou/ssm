package org.lisen.ssmsecuritydemo01.config;

import org.lisen.ssmsecuritydemo01.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @Version 1.0.0
 * @Date 2022-03-10 15:11
 * @Created by lisen
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
//    @Autowired
//    MyAuthenticationProvider myAuthenticationProvider;
    @Autowired
    MyAuthenticationAccessDeniedHandler myAuthenticationAccessDeniedHandler;
    @Autowired
    MyLogoutHandler myLogoutHandler;
    @Autowired
    MyAuthenticationEnteyPiontHandler myAuthenticationEnteyPiontHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }
    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/index","/login","/logout","/register","/login_page").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()

                .and()
                .formLogin()                                    // 登录认证
//                .loginPage("/login_page")                       // 自定义前端登录页面
                .loginProcessingUrl("/login")              // 处理登录请求的映射地址
                .successHandler(myAuthenticationSuccessHandler)   // 认证成功处理
                .failureHandler(myAuthenticationFailureHandler)   // 认证失败处理
                .usernameParameter("username")                  // 登录
                .passwordParameter("password")
                .permitAll()

                // TODO 待实现自定义RememberMe功能
//                .and()
//                .rememberMe()                               // 开启自动登录功能
//                .rememberMeParameter("remember-me")         // 前端表单name属性值
//                .tokenRepository(persistentTokenRepository) // 向数据库添加需要的验证信息
//                .tokenValiditySeconds(864000)               // cookie保存时长，10天
//                .userDetailsService(userDetailsService)     //

                .and()
                .logout()                                   // 开启登出功能
                .logoutUrl("/logout")                  // 处理登出请求的映射地址
                .addLogoutHandler(myLogoutHandler)
                .permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEnteyPiontHandler)  //未登录
                .accessDeniedHandler(myAuthenticationAccessDeniedHandler)      //未授权
                .and()
                .csrf().disable();
        ;
    }

    // 认证
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
