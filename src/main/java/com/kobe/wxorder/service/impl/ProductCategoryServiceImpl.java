package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.dao.ProductCategoryDao;
import com.kobe.wxorder.model.ProductCategory;
import com.kobe.wxorder.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/2
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findByCategoryId(Integer categoryId) {
        return productCategoryDao.findByCategoryId(categoryId);
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        return productCategoryDao.findByCategoryType(categoryType);
    }

    @Override
    public ProductCategory findByCategoryTypeIn(List<Integer> categoryType) {
        return productCategoryDao.findByCategoryTypeIn(categoryType);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }
}
