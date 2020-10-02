package com.cskaoyan.bean.GoodsPart.BO;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.Product;
import com.cskaoyan.bean.GoodsPart.Specification;
import lombok.Data;

import java.util.List;

@Data
public class GoodsCreateBO {
    Goods goods;
    List<Product> products;
    List<Specification> specifications;
    List<Attribute> attributes;
}
