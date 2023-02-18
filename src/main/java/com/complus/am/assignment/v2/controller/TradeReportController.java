package com.complus.am.assignment.v2.controller;

import com.complus.am.assignment.v2.enumeration.TradeReportType;
import com.complus.am.assignment.v2.service.TradeReportService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/report")
@RequiredArgsConstructor
public class TradeReportController {

    private final TradeReportService tradeReportService;

    @GetMapping(value = "/trade", produces = "text/csv")
    public byte[] getCsvTradeReport(@RequestParam @NotNull TradeReportType reportType,
                                 @RequestParam @NotNull String brokerName,
                                 @RequestParam String tradeDate) {
        return tradeReportService.getCsvTradeReport(reportType, brokerName, tradeDate);
    }

}
