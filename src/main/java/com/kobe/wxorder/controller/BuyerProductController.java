package com.kobe.wxorder.controller;

import com.kobe.wxorder.model.OrderMaster;
import com.kobe.wxorder.service.OrderMasterService;
import com.kobe.wxorder.vo.ResultVO;
import com.kobe.wxorder.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 买家购买商品
 * @author fanglingxiao
 * @date 2019/6/9
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private OrderMasterService orderMasterService;

    @GetMapping("/list")
    public ResultVO list(){
        List<OrderMaster> orderMaster = orderMasterService.findByBuyerOpenid("fang944211886");
        return ResultVOUtil.success(orderMaster);
    }
}
