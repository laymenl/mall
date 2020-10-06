package com.cskaoyan.service.impl;

import com.cskaoyan.mapper.MallConfigMapper;
import com.cskaoyan.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    MallConfigMapper mallConfigMapper;
    @Override
    public Map selectByKey_name(String condition) {
        List<Map> maps = mallConfigMapper.selectMallConfig(condition);
        HashMap<String, Object> resultMap = new HashMap<>();

        for(Map map:maps){
            String key = (String) map.get("key");
            int i=key.indexOf("_");
            key=key.substring(0,i)+key.substring(i+1);
            if (key.contains("share")){
                String value = (String) map.get("value");
                if ("true".equals(value)){
                    resultMap.put(key,true);
                }else {
                    resultMap.put(key,false);
                }
            }else {
                resultMap.put(key,map.get("value"));
            }
        }
        return resultMap;
    }
}
