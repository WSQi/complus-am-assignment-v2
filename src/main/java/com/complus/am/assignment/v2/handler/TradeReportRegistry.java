package com.complus.am.assignment.v2.handler;

import com.complus.am.assignment.v2.enumeration.TradeReportType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TradeReportRegistry {

    private Map<TradeReportType, TradeReportHandler> tradeReportHandlers;

    public TradeReportRegistry(List<TradeReportHandler> tradeReportHandlers) {
        this.tradeReportHandlers = tradeReportHandlers.stream()
                .collect(Collectors.toMap(TradeReportHandler::getTradeReportType, Function.identity()));
    }

    public Optional<TradeReportHandler> getHandlerFor(TradeReportType tradeReportType) {
        return Optional.ofNullable(tradeReportHandlers.get(tradeReportType));
    }

}
