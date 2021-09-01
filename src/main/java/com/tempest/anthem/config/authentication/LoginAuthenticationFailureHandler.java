package com.tempest.anthem.config.authentication;

import com.google.gson.Gson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * login failure handler
 *
 * @author zhaoy
 * @date 2021-09-01 10:28
 */
@Component
public class LoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("code", 400);
        paramsMap.put("msg", exception.getMessage());
        response.addHeader("access-control-allow-origin","*");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(paramsMap));
        out.flush();
        out.close();
    }
}
