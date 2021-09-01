package com.tempest.anthem.config.authentication;

import com.tempest.anthem.entity.AnthemUser;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * set anthem authentication
 *
 * @author zhaoy
 * @date 2021-08-31 17:20
 */
@Component
@AllArgsConstructor
public class LoginValidateAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 输入的用户名
        String username = authentication.getName();

        // 输入的密码
        String rawPassword = (String) authentication.getCredentials();
        AnthemUser anthemUser = (AnthemUser) userDetailsService.loadUserByUsername(username);

        // 验证密码
        if (!passwordEncoder.matches(rawPassword, anthemUser.getPassword())) {
            throw new BadCredentialsException("输入密码错误");
        }
        return new UsernamePasswordAuthenticationToken(anthemUser, rawPassword, anthemUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
