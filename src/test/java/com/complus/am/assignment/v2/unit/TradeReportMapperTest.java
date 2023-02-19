package com.complus.am.assignment.v2.unit;

import com.complus.am.assignment.v2.entity.Trade;
import com.complus.am.assignment.v2.enumeration.BuySellType;
import com.complus.am.assignment.v2.mapper.TradeReportMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TradeReportMapperTest {

    @Spy
    private TradeReportMapper tradeReportMapper = Mappers.getMapper(TradeReportMapper.class);

    @Test
    void tradeToFxForwardTradeReport_EntitySupplied_RunSuccessfully() {
        final var tradeRef = "T-FWD-1";
        final var expectedTradeDate = "20220408";
        final var tradeDateStr = "2022-04-08";
        final var tradeDate = LocalDate.parse(tradeDateStr).atStartOfDay();
        final var productId = 1L;
        final var productName = "AUDNZD FRD Exp14Jul2021";
        final var qty = BigInteger.TEN;
        final var buySell = BuySellType.BUY;
        final var price = new BigDecimal("1.067591000");
        final var expectedPrice = "1.067591";
        final var trade = Trade.builder()
                .tradeRef(tradeRef)
                .productId(productId)
                .productName(productName)
                .tradeDate(tradeDate)
                .qty(qty)
                .buySell(buySell)
                .price(price)
                .build();
        var actual = tradeReportMapper.tradeToFxForwardTradeReport(trade);
        assertEquals("tradeRef", tradeRef, actual.getTradeRef());
        assertEquals("productId", productId, actual.getProductId());
        assertEquals("productName", productName, actual.getProductName());
        assertEquals("tradeDate", expectedTradeDate, actual.getTradeDate());
        assertEquals("qty", qty, actual.getQty());
        assertEquals("buySell", buySell, actual.getBuySell());
        assertEquals("price", expectedPrice, actual.getPrice());
    }

}
