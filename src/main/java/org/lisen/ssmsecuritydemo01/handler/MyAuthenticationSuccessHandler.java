package org.lisen.ssmsecuritydemo01.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version 1.0.0
 * @Date 2022-03-10 15:37
 * @Created by lisen
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private Logger logger;
    @Autowired
    private ObjectMapper objectMapper;

//    @Autowired
//    private HttpSessionRequestCache requestCache;
//    @Autowired
//    private DefaultRedirectStrategy redirectStrategy;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {


        logger.info("用户"+authentication.getName()+"登录成功");
//        设置返回内容的数据形式和编码格式
        response.setContentType("application/json;charset=UTF-8");
        //将户认证成功的信息以json数据的形式返回给前端
        response.getWriter().write(objectMapper.writeValueAsString(authentication));

//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//        if (savedRequest == null)
//            redirectStrategy.sendRedirect(request, response, "/");
//        else
//            redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
    }
}
