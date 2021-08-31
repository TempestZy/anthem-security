package com.tempest.anthem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring security startup class
 *
 * @author tempest_zy
 * @date 2021-08-31
 */
@SpringBootApplication
@MapperScan({"com.tempest.anthem.**.mapper"})
public class AnthemSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnthemSecurityApplication.class, args);
	}

}
