package com.tempest.anthem;

import com.tempest.anthem.entity.AnthemUser;
import com.tempest.anthem.mapper.AnthemUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class AnthemSecurityApplicationTests {

    @Autowired
    private AnthemUserMapper anthemUserMapper;

    @Test
    void contextLoads() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("123456"));
    }

}
