package com.complus.am.assignment.v2.dto;

import com.complus.am.assignment.v2.enumeration.BuySellType;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
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

    @CsvBindByName(column = "tradeRef")
    @CsvBindByPosition(position = 0)
    private String tradeRef;
    @CsvBindByName(column = "productId")
    @CsvBindByPosition(position = 1)
    private Long productId;
    @CsvBindByName(column = "productName")
    @CsvBindByPosition(position = 2)
    private String productName;
    @CsvBindByName(column = "tradeDate")
    @CsvBindByPosition(position = 3)
    private String tradeDate;
    @CsvBindByName(column = "qty")
    @CsvBindByPosition(position = 4)
    private BigInteger qty;
    @CsvBindByName(column = "buySell")
    @CsvBindByPosition(position = 5)
    private BuySellType buySell;
    @CsvBindByName(column = "price")
    @CsvBindByPosition(position = 6)
    private BigDecimal price;

}
