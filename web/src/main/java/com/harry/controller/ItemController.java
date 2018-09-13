package com.harry.controller;

import com.harry.common.pojo.EasyUIDataGridResult;
import com.harry.common.util.JsonUtils;
import com.harry.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: 20mall
 * @description:
 * @author: Harry
 * @create: 2018-09-08 17:06
 **/
@Slf4j
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/item/list",method= RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows){
        //1.引入服务
        //2.注入服务
        //3.调用服务的方法
        return itemService.getItemList(page, rows);
    }

    @Value("/Users/zhukai/Documents/")
    private String uploadDir;

    @RequestMapping(value = "/pic/upload", produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public String uploadImage(MultipartFile file) throws RuntimeException {

        if (file.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", 1);
            map.put("message", "上传失败");
            return JsonUtils.objectToJson(map);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = uploadDir;
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        log.info(dest.getAbsolutePath());
        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
        try {
            file.transferTo(dest);
            log.info("上传成功后的文件路径未：" + filePath + fileName);
            Map<String, Object> map = new HashMap<>();
            map.put("error", 0);
            map.put("url", filePath);
            // 6.返回map
            return JsonUtils.objectToJson(map);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("error", 1);
        map.put("message", "上传失败");
        return JsonUtils.objectToJson(map);
    }
}
