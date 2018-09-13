package com.harry.service;


import com.harry.common.pojo.EasyUIDataGridResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MANAGER")
public interface ItemService {

    @RequestMapping(value="/item/list")
    public EasyUIDataGridResult getItemList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);
}
