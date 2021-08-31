package com.tempest.anthem;

import com.tempest.anthem.entity.AnthemUser;
import com.tempest.anthem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AnthemSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println("mybatis plus select begin ----");
        List<AnthemUser> anthemUserList = userMapper.selectList(null);
        anthemUserList.forEach(System.out::println);
    }

}
