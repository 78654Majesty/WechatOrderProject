package com.kobe.wxorder.service.impl;
import java.util.Date;

import com.kobe.wxorder.dao.ProductCategoryDao;
import com.kobe.wxorder.model.ProductCategory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImplTest.class);

    @Test
    public void findByCategoryId() {
        ProductCategory p = new ProductCategory();
        p.setCategoryName("床上用品");
        p.setCategoryType(1);
        p.setCreateTime(new Date());
        p.setUpdateTime(new Date());

        productCategoryDao.save(p);
        ProductCategory byCategoryId = productCategoryDao.findByCategoryId(1);
        logger.info("通过商品类目id查询{}",byCategoryId);
    }

    @Test
    public void findByCategoryType() {
    }

    @Test
    public void findAll() {
    }
}