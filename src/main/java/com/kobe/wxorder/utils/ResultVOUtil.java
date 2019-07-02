package com.kobe.wxorder.utils;

import com.kobe.wxorder.vo.ResultVO;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/2
 */
public class ResultVOUtil {
    public static ResultVO success(Object obj){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(obj);
        return resultVO;
    }

    public static ResultVO success(){
        return null;
    }

    public static ResultVO error(int code,String msg){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
