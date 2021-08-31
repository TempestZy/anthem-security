package com.tempest.anthem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 *
 * @author zhaoy
 * @date 2021-08-31 15:37
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/string")
    public String test() {
        return "ok";
    }
}
