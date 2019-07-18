package com.kobe.wxorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/18
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
