package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseRespVo;
import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("admin/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

//    本地图片存储位置，可于application.yml中自行修改
    @Value("${storage.path}")
    String storagePath;


    @RequestMapping("create")
    public BaseRespVo create(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        int length = file.getBytes().length;
        String key = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.indexOf("."));
        File fileDestination = new File(storagePath, key);
        String url = "http://localhost:8083/storage/fetch/" + key;
        file.transferTo(fileDestination);
        Storage storage = new Storage(null, key, originalFilename, contentType, length, url, new Date(), new Date(), false);
        Storage storageResp = storageService.insertFile(storage);
        return BaseRespVo.ok(storageResp);
    }

    @RequestMapping("list")
    public BaseRespVo list(String key, String name, Integer page, Integer limit, String sort, String order){
        ListBean listBean = storageService.queryStorageListBean(key, name, page,limit,sort,order);
        return BaseRespVo.ok(listBean);
    }

    @RequestMapping("update")
    public BaseRespVo update(@RequestBody Storage storage){
        storageService.updateStorage(storage);
        return BaseRespVo.ok(storage);
    }

    @RequestMapping("delete")
    public BaseRespVo delete(@RequestBody Storage storage){
        storageService.deleteStorage(storage);
        return BaseRespVo.ok();
    }
}
