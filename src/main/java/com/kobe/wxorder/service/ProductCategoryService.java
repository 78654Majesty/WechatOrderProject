package com.kobe.wxorder.service;

import com.kobe.wxorder.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /** */
    ProductCategory findById(Integer categoryId);

    /** */
    ProductCategory findByType(Integer categoryType);

    /** */
    List<ProductCategory> findAll();
}
