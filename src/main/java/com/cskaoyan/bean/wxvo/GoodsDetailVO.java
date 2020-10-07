package com.cskaoyan.bean.wxvo;

import com.cskaoyan.bean.GoodsPart.Attribute;
import com.cskaoyan.bean.GoodsPart.Goods;
import com.cskaoyan.bean.GoodsPart.Product;
import com.cskaoyan.bean.GoodsPart.Specification;
import com.cskaoyan.bean.shop.brand.Brand;
import com.cskaoyan.bean.shop.issue.Issue;
import com.cskaoyan.promoteModule.grouponManage.bean.listRecord.Groupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDetailVO {

    private List<SpecificationListEntity> specificationList;
    private List<Groupon> groupon = null;
    private List<Issue> issue;
    private int userHasCollect;
    private CommentEntity comment;
    private List<Attribute> attribute;
    private Brand brand;
    private List<Product> productList;
    private Goods info;

}
