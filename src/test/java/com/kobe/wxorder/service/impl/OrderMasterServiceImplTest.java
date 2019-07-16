package com.kobe.wxorder.service.impl;

import com.kobe.wxorder.utils.KeyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterServiceImplTest {

    @Test
    public void orderCreate(){
        String orderId = KeyUtils.createUniqueKey();
        System.out.println(orderId);
    }
}