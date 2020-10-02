package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Storage;
import com.cskaoyan.mapper.StorageMapper;
import com.cskaoyan.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public Storage insertFile(Storage storage) {
        storageMapper.insert(storage);
        return storage;
    }

}
