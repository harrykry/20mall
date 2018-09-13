package com.harry.controller;

import com.harry.common.pojo.EasyUITreeNode;
import com.harry.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: 20mall
 * @description:
 * @author: Harry
 * @create: 2018-09-08 18:58
 **/
@RestController
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id") Long parentId){
        return itemCatService.getItemCatListByParentId(parentId);
    }
}
