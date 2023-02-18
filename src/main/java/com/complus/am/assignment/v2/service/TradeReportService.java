package com.complus.am.assignment.v2.service;

import com.complus.am.assignment.v2.enumeration.TradeReportType;
import com.complus.am.assignment.v2.handler.TradeReportRegistry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class TradeReportService {

    private final TradeReportRegistry tradeReportRegistry;

    public byte[] getCsvTradeReport(@NonNull TradeReportType reportType, @NonNull String brokerName, @NonNull String tradeDate) {
        var date = LocalDate.parse(tradeDate).atStartOfDay();
        var handler = tradeReportRegistry.getHandlerFor(reportType)
                .orElseThrow(() -> new IllegalArgumentException("unable to find handler: "+reportType));
        var dtos = handler.handle(brokerName, date);
        log.info("dtos: {}", dtos);
        return null;
    }

}
