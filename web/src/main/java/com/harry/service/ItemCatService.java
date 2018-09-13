package com.harry.service;

import com.harry.common.pojo.EasyUITreeNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MANAGER")
public interface ItemCatService {
    @RequestMapping("/item/cat/list")
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id") Long parentId);
}