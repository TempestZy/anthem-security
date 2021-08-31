package com.tempest.anthem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * user
 *
 * @author zhaoy
 * @date 2021-08-31 16:11
 */
@Data
@TableName("anthem_user")
public class AnthemUser implements Serializable {
    private Long id;

    private String name;

    private String realName;

    private String password;

    private String email;

    private String phone;

}
