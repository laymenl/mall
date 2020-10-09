package com.cskaoyan.mapper;

import com.cskaoyan.bean.GoodsPart.VO.CategoryVO;
import com.cskaoyan.bean.shop.category.Category;

import java.util.List;

public interface CategoryMapper {

    List<CategoryVO> getAllUnDeletedCategoryVO();


    Integer getPidById(Integer id);


    Category selectByPrimaryKey(Integer categoryId);
<<<<<<< HEAD

    Category SelectCurrentCategory();

    List<Category> SelectCategoryList();

    List<Category> SelectCurrentSubCategory();

    Category SelectCurrentCategoryById(Integer id);

    List<Category> SelectCurrentSubCategoryById(Integer id);
=======
>>>>>>> 1109be14e2f4f112ea4ce734cadacdfd8abca678
}
