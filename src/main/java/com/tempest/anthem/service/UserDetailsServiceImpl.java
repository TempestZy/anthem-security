package com.tempest.anthem.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tempest.anthem.entity.AnthemUser;
import com.tempest.anthem.mapper.AnthemUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * user service
 *
 * @author zhaoy
 * @date 2021-08-31 16:47
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AnthemUserMapper anthemUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AnthemUser anthemUser = anthemUserMapper
                .selectOne(Wrappers.<AnthemUser>lambdaQuery().eq(AnthemUser::getName, username));
        if (anthemUser == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return anthemUser;
    }
}
