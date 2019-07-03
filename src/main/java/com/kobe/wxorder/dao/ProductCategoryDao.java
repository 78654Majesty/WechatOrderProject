package com.kobe.wxorder.dao;

import com.kobe.wxorder.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author fanglingxiao
 * @createTime 2019/6/3
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    ProductCategory findByCategoryType(Integer categoryType);

    ProductCategory findByCategoryId(Integer categoryId);

    ProductCategory findByCategoryTypeIn(List<Integer> categoryType);
}
