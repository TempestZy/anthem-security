package com.tempest.anthem.config;

import com.tempest.anthem.config.authentication.LoginAuthenticationFailureHandler;
import com.tempest.anthem.config.authentication.LoginAuthenticationSuccessHandler;
import com.tempest.anthem.config.authentication.LoginValidateAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * spring security config
 *
 * @author zhaoy
 * @date 2021-08-31 16:40
 */
@Configuration
@EnableWebSecurity
public class AnthemSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginValidateAuthenticationProvider loginValidateAuthenticationProvider;

    @Resource
    private LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;

    @Resource
    private LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 基础设置
        http.httpBasic()
                .and()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/index")
                    .successHandler(loginAuthenticationSuccessHandler)
                    .failureHandler(loginAuthenticationFailureHandler)
                    .permitAll();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置自定义认证
        auth.authenticationProvider(loginValidateAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
