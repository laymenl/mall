package com.cskaoyan.service.wx;

import com.cskaoyan.bean.wxvo.CatalogVO;
import com.cskaoyan.bean.wxvo.CategoryCurrentVO;

public interface CatalogService {
    CatalogVO index();

    CategoryCurrentVO current(Integer id);
}
