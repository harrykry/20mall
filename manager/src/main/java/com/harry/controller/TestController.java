package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 20mall
 * @description: 测试
 * @author: Harry
 * @create: 2018-09-08 00:09
 **/
@RestController
public class TestController {
    @RequestMapping(name = "/a")
    public String test() {
        return "------";
    }
}
