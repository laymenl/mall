package com.cskaoyan.service;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.Storage;

public interface StorageService {

    Storage insertFile(Storage storage);
    ListBean queryStorageListBean(String key, String name, Integer page, Integer limit, String sort, String order);
    void updateStorage(Storage storage);
    void deleteStorage(Storage storage);
}
