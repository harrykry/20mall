package com.harry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.harry.common.pojo.EasyUIDataGridResult;
import com.harry.mapper.TbItemMapper;
import com.harry.pojo.TbItem;
import com.harry.pojo.TbItemExample;
import com.harry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: 20mall
 * @description:
 * @author: Harry
 * @create: 2018-09-08 16:38
 **/

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper mapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //1.设置分页的信息 使用pagehelper
        if(page==null)page=1;
        if(rows==null)rows=30;
        PageHelper.startPage(page, rows);
        //2.注入mapper
        //3.创建example 对象 不需要设置查询条件
        TbItemExample example = new TbItemExample();
        //4.根据mapper调用查询所有数据的方法
        List<TbItem> list = mapper.selectByExample(example);
        //5.获取分页的信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        //6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(info.getList());
        //7.返回
        return result;
    }

}
