package com.cskaoyan.service.impl;

import com.cskaoyan.bean.ListBean;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.bean.StorageExample;
import com.cskaoyan.mapper.StorageMapper;
import com.cskaoyan.service.StorageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public Storage insertFile(Storage storage) {
        storageMapper.insert(storage);
        return storage;
    }

    @Override
    public ListBean queryStorageListBean(String key, String name, Integer page, Integer limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        StorageExample storageExample = new StorageExample();
        StorageExample.Criteria criteria = storageExample.createCriteria();
        if(name != null){
            criteria.andNameLike("%"+name+"%");
        }
        if(key != null){
            criteria.andKeyLike("%"+key+"%");
        }
        storageExample.setOrderByClause(sort + " " + order);
        List<Storage> storages = storageMapper.selectByExample(storageExample);
        PageInfo pageInfo = new PageInfo(storages);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(storages);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public void updateStorage(Storage storage) {
        storage.setUpdateTime(new Date());
        storageMapper.updateByPrimaryKey(storage);
    }

    @Override
    public void deleteStorage(Storage storage) {
        storageMapper.deleteByPrimaryKey(storage.getId());
    }
}
