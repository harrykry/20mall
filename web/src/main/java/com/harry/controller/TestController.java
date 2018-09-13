package com.harry.controller;

import com.harry.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program: 20mall
 * @description:
 * @author: Harry
 * @create: 2018-09-08 01:52
 **/

@Controller
public class TestController {

    @Autowired
    private TestService testService;

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/b")
    @ResponseBody
    public String test() {

        return testService.test();
    }


}
