package com.kjb.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kjb~
 * @version 1.0.0
 */

@Data
@ToString
@Schema(title = "支付交易表")
public class PayDTO implements Serializable {

    private Integer id;

    //流水id
    @Schema(title = "流水id")
    private String payNo;
    // 订单id
    @Schema(title = "订单id")
    private String orderNo;
    //用户id
    @Schema(title = "用户id")
    private Integer userId;
    // 交易金额
    @Schema(title = "交易id")
    private BigDecimal amount;

}
