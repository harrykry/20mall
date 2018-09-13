package com.harry.service;

import com.harry.common.pojo.EasyUIDataGridResult;

public interface ItemService {
    /** 
    * @Description: 根据当前的页码和每页 的行数进行分页查询
    * @Param: [page, rows] 
    * @return: com.harry.common.pojo.EasyUIDataGridResult 
    * @Author: Harry 
    * @Date: 2018/9/8 
    */ 
    public EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
