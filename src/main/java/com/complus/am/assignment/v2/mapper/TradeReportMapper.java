package com.complus.am.assignment.v2.mapper;

import com.complus.am.assignment.v2.dto.FxForwardTradeReport;
import com.complus.am.assignment.v2.entity.Trade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TradeReportMapper {

    FxForwardTradeReport tradeToFxForwardTradeReport(Trade trade);

}
