package com.cskaoyan.bean.GoodsPart.BO;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.Product;
import com.cskaoyan.bean.GoodsPart.Specification;
import com.cskaoyan.bean.shop.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCreateBOAndDetailVO {
    Goods goods;
    List<Product> products;
    List<Specification> specifications;
    List<Attribute> attributes;
    // for /detail
    Integer[] categoryIds;
}
