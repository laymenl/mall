package com.cskaoyan.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MallConfigMapper {

    List<Map> selectMallConfig(@Param("condition") String condition);
}
