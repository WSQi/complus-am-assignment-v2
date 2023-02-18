package com.complus.am.assignment.v2.handler;


import com.complus.am.assignment.v2.dto.TradeReport;
import com.complus.am.assignment.v2.enumeration.TradeReportType;

import java.time.LocalDateTime;
import java.util.List;

public interface TradeReportHandler {

    TradeReportType getTradeReportType();

    List<? extends TradeReport> handle(String brokerName, LocalDateTime tradeDate);

}
