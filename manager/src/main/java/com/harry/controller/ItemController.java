package com.harry.controller;

import com.harry.common.pojo.EasyUIDataGridResult;
import com.harry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 20mall
 * @description:
 * @author: Harry
 * @create: 2018-09-08 17:11
 **/
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/item/list")
    public EasyUIDataGridResult getItemList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        return itemService.getItemList(page, rows);
    }
}
