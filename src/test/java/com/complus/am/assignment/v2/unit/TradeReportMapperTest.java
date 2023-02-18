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
import java.time.LocalDateTime;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TradeReportMapperTest {

    @Spy
    private TradeReportMapper tradeReportMapper = Mappers.getMapper(TradeReportMapper.class);

    @Test
    void tradeToFxForwardTradeReport_EntitySupplied_RunSuccessfully() {
        final var now = LocalDateTime.now();
        final var trade = Trade.builder()
                .tradeRef("T-FWD-1")
                .productId(1L)
                .productName("AUDNZD FRD Exp14Jul2021")
                .tradeDate(now)
                .qty(BigInteger.TEN)
                .buySell(BuySellType.BUY)
                .price(BigDecimal.TEN)
                .build();
        var actual = tradeReportMapper.tradeToFxForwardTradeReport(trade);
        assertEquals("tradeRef", "T-FWD-1", actual.getTradeRef());
        assertEquals("productId", 1L, actual.getProductId());
        assertEquals("productName", "AUDNZD FRD Exp14Jul2021", actual.getProductName());
        assertEquals("tradeDate", now.toString(), actual.getTradeDate().toString());
        assertEquals("qty", BigInteger.TEN, actual.getQty());
        assertEquals("buySell", BuySellType.BUY, actual.getBuySell());
        assertEquals("price", BigDecimal.TEN, actual.getPrice());
    }

}
