package com.kobe.wxorder.controller;

import com.kobe.wxorder.enums.ResponseError;
import com.kobe.wxorder.service.OrderMasterService;
import com.kobe.wxorder.utils.ResultVOUtil;
import com.kobe.wxorder.vo.OrderFormVO;
import com.kobe.wxorder.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * description
 * 订单
 * @author fanglingxiao
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    private static final Logger logger = LoggerFactory.getLogger(BuyerOrderController.class);

    @Autowired
    private OrderMasterService orderMasterService;

    /**
     * 创建订单
     * @param orderFormVO orderFormVO
     * @param bindingResult bindingResult
     * @return ResultVO
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderFormVO orderFormVO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            logger.info("参数错误{}，创建订单失败！",bindingResult.getFieldError().getDefaultMessage());
            return ResultVOUtil.error(ResponseError.PARAMS_REEOR.getCode(),ResponseError.PARAMS_REEOR.getMessage());
        }
        String orderId = orderMasterService.create(orderFormVO);
        return ResultVOUtil.success(orderId);
    }
}
