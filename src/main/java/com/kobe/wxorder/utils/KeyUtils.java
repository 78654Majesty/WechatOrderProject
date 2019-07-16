package com.kobe.wxorder.utils;

import java.util.UUID;

/**
 * description
 *
 * @author fanglingxiao
 * @date 2019/7/16
 */
public class KeyUtils {

    /**
     * 生成唯一主键
     * @return uniqueKey
     */
    public static synchronized String createUniqueKey(){
        String uniqueKey = UUID.randomUUID().toString().replace("-", "");
        return System.currentTimeMillis()+uniqueKey;
    }
}
