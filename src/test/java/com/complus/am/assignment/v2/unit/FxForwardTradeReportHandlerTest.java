package com.complus.am.assignment.v2.unit;

import com.complus.am.assignment.v2.dao.TradeRepository;
import com.complus.am.assignment.v2.dto.FxForwardTradeReport;
import com.complus.am.assignment.v2.entity.Trade;
import com.complus.am.assignment.v2.enumeration.BuySellType;
import com.complus.am.assignment.v2.handler.impl.FxForwardTradeReportHandler;
import com.complus.am.assignment.v2.mapper.TradeReportMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FxForwardTradeReportHandlerTest {

    @InjectMocks
    private FxForwardTradeReportHandler fxForwardTradeReportHandler;

    @Mock
    private TradeRepository tradeRepository;

    @Spy
    private TradeReportMapper tradeReportMapper = Mappers.getMapper(TradeReportMapper.class);

    private static final String BROKER_NAME = "Broker_A";
    private static final LocalDateTime TRADE_DATE = LocalDate
            .parse("2022-04-08")
            .atStartOfDay();

    @Test
    void handle_RecordsFound_RunSuccessfully() {
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
        when(tradeRepository.findAllByBrokerNameAndTradeDate(BROKER_NAME, TRADE_DATE))
                .thenReturn(List.of(trade));
        List<FxForwardTradeReport> tradeReports = (List<FxForwardTradeReport>) fxForwardTradeReportHandler.handle(BROKER_NAME, TRADE_DATE);
        assertEquals("tradeRef", tradeRef, tradeReports.get(0).getTradeRef());
        assertEquals("productId", productId, tradeReports.get(0).getProductId());
        assertEquals("productName", productName, tradeReports.get(0).getProductName());
        assertEquals("tradeDate", expectedTradeDate, tradeReports.get(0).getTradeDate());
        assertEquals("qty", qty, tradeReports.get(0).getQty());
        assertEquals("buySell", buySell, tradeReports.get(0).getBuySell());
        assertEquals("price", expectedPrice, tradeReports.get(0).getPrice());
    }

}
