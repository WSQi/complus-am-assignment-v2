package com.complus.am.assignment.v2.integration;

import com.complus.am.assignment.v2.enumeration.TradeReportType;
import com.complus.am.assignment.v2.handler.TradeReportRegistry;
import com.complus.am.assignment.v2.service.CsvReportService;
import com.complus.am.assignment.v2.service.TradeReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class TradeReportServiceTest {

    @Autowired
    private TradeReportService tradeReportService;

    @MockBean
    private CsvReportService csvReportService;

    @Autowired
    private TradeReportRegistry tradeReportRegistry;


    private static final String BROKER_NAME = "Broker_A";
    private static final String TRADE_DATE = "2022-04-08";

    @Test
    void getCsvTradeReport_UnknownReportType_ExceptionThrown() {
        assertThatThrownBy(() ->
                tradeReportService.getCsvTradeReport(TradeReportType.fromValue("UNKNOWN"), BROKER_NAME, TRADE_DATE))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void getCsvTradeReport_ParametersSupplied_RunSuccessfully() {
        when(csvReportService.toCsv(any(), any())).thenReturn(new byte[] {});
        byte[] actualBytes = tradeReportService.getCsvTradeReport(TradeReportType.FxForwardTradeReport, BROKER_NAME, TRADE_DATE);
        assertEquals("bytes[]", new byte[] {}, actualBytes);
    }

}
