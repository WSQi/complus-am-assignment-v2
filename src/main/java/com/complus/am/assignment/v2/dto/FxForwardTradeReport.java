package com.complus.am.assignment.v2.dto;

import com.complus.am.assignment.v2.enumeration.BuySellType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class FxForwardTradeReport extends TradeReport {

    private String tradeRef;
    private Long productId;
    private String productName;
    private String tradeDate;
    private BigInteger qty;
    private BuySellType buySell;
    private BigDecimal price;

}
