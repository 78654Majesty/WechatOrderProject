package com.kobe.wxorder.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * description
 *  购买商品业（包含类目）
 * @author fanglingxiao
 * @date 2019/7/11
 */
@Data
public class ProductVO {
    //类目名
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
