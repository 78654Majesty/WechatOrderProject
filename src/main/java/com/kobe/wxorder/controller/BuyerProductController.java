package com.kobe.wxorder.controller;

import com.google.common.collect.Lists;
import com.kobe.wxorder.model.ProductCategory;
import com.kobe.wxorder.model.ProductInfo;
import com.kobe.wxorder.service.ProductCategoryService;
import com.kobe.wxorder.service.ProductInfoService;
import com.kobe.wxorder.utils.ResultVOUtil;
import com.kobe.wxorder.vo.ProductInfoVO;
import com.kobe.wxorder.vo.ProductVO;
import com.kobe.wxorder.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家购买商品
 *
 * @author fanglingxiao
 * @date 2019/6/9
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    private static final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);

    @GetMapping("/list")
    public ResultVO list() {
        //获取所有上架商品
        List<ProductInfo> productInfos = productInfoService.findAll();
        List<ProductVO> list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(productInfos)) {
            logger.info("为获取到商品列表数据！");
            return ResultVOUtil.success();
        }
        //查询类目
        List<Integer> categoryTypes = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypes);
        //封装数据
        categoryList.forEach(category -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVO> infoVOList = productInfos.stream()
                    .filter(f -> category.getCategoryType().equals(f.getCategoryType()))
                    .map(productInfo -> {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        productInfoVO.setProductId(productInfo.getProductId());
                        productInfoVO.setProductName(productInfo.getProductName());
                        productInfoVO.setProductPrice(productInfo.getProductPrice());
                        productInfoVO.setProductDescription(productInfo.getProductDescription());
                        productInfoVO.setProductIcon(productInfo.getProductIcon());
                        return productInfoVO;
                    }).collect(Collectors.toList());
            productVO.setProductInfoVOList(infoVOList);
            list.add(productVO);
        });
        return ResultVOUtil.success(list);
    }
}
