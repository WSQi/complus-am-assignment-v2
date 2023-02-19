package com.complus.am.assignment.v2.handler.impl;

import com.complus.am.assignment.v2.dao.TradeRepository;
import com.complus.am.assignment.v2.dto.FxForwardTradeReport;
import com.complus.am.assignment.v2.dto.TradeReport;
import com.complus.am.assignment.v2.enumeration.TradeReportType;
import com.complus.am.assignment.v2.handler.TradeReportHandler;
import com.complus.am.assignment.v2.mapper.TradeReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FxForwardTradeReportHandler implements TradeReportHandler {

    private final TradeRepository tradeRepository;

    private final TradeReportMapper tradeReportMapper;

    @Override
    public TradeReportType getTradeReportType() {
        return TradeReportType.FxForwardTradeReport;
    }

    @Override
    public Class getTypeClass() {
        return FxForwardTradeReport.class;
    }

    @Override
    public List<? extends TradeReport> handle(String brokerName, LocalDateTime tradeDate) {
        var trades = tradeRepository.findAllByBrokerNameAndTradeDate(brokerName, tradeDate);
        return trades.stream()
                .map(tradeReportMapper::tradeToFxForwardTradeReport)
                .toList();
    }

}
