package org.lisen.ssmsecuritydemo01.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0.0
 * @Date 2022-03-10 15:35
 * @Created by lisen
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
        //登录失败信息返回
//        request.getMethod();
//        request.setAttribute("msg", exception.getMessage());
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("message", exception.getMessage());
//        //response.getWriter().write(objectMapper.writeValueAsString(paramMap));
//        //写出流
//        PrintWriter out = response.getWriter();
//        out.write(objectMapper.writeValueAsString(paramMap));
//        out.flush();
//        out.close();
//        request.getRequestDispatcher("/user/toLogin").forward(request, response);
    }
}
