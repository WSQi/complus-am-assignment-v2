package com.complus.am.assignment.v2.integration;

import com.complus.am.assignment.v2.controller.TradeReportController;
import com.complus.am.assignment.v2.enumeration.TradeReportType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TradeReportControllerTest {

    @Autowired
    private TradeReportController tradeReportController;

    private static final String BROKER_NAME = "Broker_A";
    private static final String TRADE_DATE_STR = "2020-04-08";
    private static final LocalDateTime TRADE_DATE = LocalDate
            .parse(TRADE_DATE_STR)
            .atStartOfDay();
    private static final String EXPECTED_CSV_CONTENT = "tradeRef,productId,productName,tradeDate,qty,buySell,price\n" +
            "T-FWD-1,1,AUDNZD FRD Exp14Jul2021,20200408,1000000,B,1.067591\n" +
            "T-FWD-2,2,AUDNZD FRD Exp15Jul2021,20200408,8000000,B,0.7518301\n" +
            "T-FWD-3,3,AUDNZD FRD Exp15Jul2021,20200408,25000000,B,1.186073\n";

    @Test
    void getCsvTradeReport_ParamSupplied_RunSuccessfully() {
        var bytes = tradeReportController.getCsvTradeReport(TradeReportType.FxForwardTradeReport, BROKER_NAME, TRADE_DATE_STR);
        assertEquals(EXPECTED_CSV_CONTENT, new String(bytes));
    }

}
