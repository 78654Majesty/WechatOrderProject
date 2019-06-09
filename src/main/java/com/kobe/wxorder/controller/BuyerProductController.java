package com.kobe.wxorder.controller;

import com.kobe.wxorder.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 买家购买商品
 * @author fanglingxiao
 * @date 2019/6/9
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO list(){
        return new ResultVO();
    }
}
