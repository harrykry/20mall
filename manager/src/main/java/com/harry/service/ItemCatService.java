package com.harry.service;

import com.harry.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @program: 14taotao
 * @description:
 * @author: Harry
 * @create: 2018-09-04 15:15
 */
public interface ItemCatService {
    /**
     * 根据父节点的id查询子节点的列表
     * @param parentId
     * @return
     */
    public List<EasyUITreeNode> getItemCatListByParentId(Long parentId);
}
