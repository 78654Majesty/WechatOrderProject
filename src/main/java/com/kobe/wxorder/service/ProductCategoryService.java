package com.kobe.wxorder.service;

import com.kobe.wxorder.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /** 根据类目id*/
    ProductCategory findByCategoryId(Integer categoryId);

    /** 根据类目编号 */
    ProductCategory findByCategoryType(Integer categoryType);

    /** 查询所有类目 */
    List<ProductCategory> findAll();
}
