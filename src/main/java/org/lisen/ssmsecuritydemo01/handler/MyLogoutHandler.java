package org.lisen.ssmsecuritydemo01.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Version 1.0.0
 * @Date 2022-03-15 15:28
 * @Created by lisen
 */
@Component
public class MyLogoutHandler implements LogoutHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = httpServletResponse.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("注销成功");
        out.write("账户已注销!");
        out.flush();
        out.close();
    }
}
