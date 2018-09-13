package com.harry.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "MANAGER")
public interface TestService {
    @RequestMapping("/a")
    public String test();
}
