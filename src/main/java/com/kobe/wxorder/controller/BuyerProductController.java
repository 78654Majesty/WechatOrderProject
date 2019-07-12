package com.kobe.wxorder.controller;

import com.google.common.collect.Lists;
import com.kobe.wxorder.model.ProductInfo;
import com.kobe.wxorder.service.ProductInfoService;
import com.kobe.wxorder.utils.ResultVOUtil;
import com.kobe.wxorder.vo.ProductVO;
import com.kobe.wxorder.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductInfo> productInfos = productInfoService.findAll();
        if (CollectionUtils.isEmpty(productInfos)) {
            return ResultVOUtil.success();
        }
        productInfos.forEach(product->{
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName("");
            productVO.setCategoryType(0);
            productVO.setProductInfoVOList(Lists.newArrayList());
        });

        return ResultVOUtil.success();
    }
}
