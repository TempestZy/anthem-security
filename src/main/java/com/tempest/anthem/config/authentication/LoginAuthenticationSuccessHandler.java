package com.tempest.anthem.config.authentication;

import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * login success handler
 *
 * @author zhaoy
 * @date 2021-09-01 10:19
 */
@Component
public class LoginAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("code", 200);
        paramsMap.put("msg", "登录成功");
        response.addHeader("access-control-allow-origin","*");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(paramsMap));
        out.flush();
        out.close();
    }
}
