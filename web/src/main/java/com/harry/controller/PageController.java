package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: 20mall
 * @description:
 * @author: Harry
 * @create: 2018-09-08 16:23
 **/
@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable(value = "page") String page) {
        return page;
    }
}
