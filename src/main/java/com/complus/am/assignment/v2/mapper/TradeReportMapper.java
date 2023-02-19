package com.complus.am.assignment.v2.mapper;

import com.complus.am.assignment.v2.dto.FxForwardTradeReport;
import com.complus.am.assignment.v2.entity.Trade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface TradeReportMapper {

    @Mapping(target = "tradeDate", expression = "java(localDateTimeToString(trade))")
    @Mapping(target = "price", expression = "java(bigDecimalToString(trade))")
    FxForwardTradeReport tradeToFxForwardTradeReport(Trade trade);

    @Named("localDateTimeToString")
    default String localDateTimeToString(Trade trade) {
        if (trade.getTradeDate() == null) {
            return null;
        }
        return trade.getTradeDate()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    @Named("bigDecimalToString")
    default String bigDecimalToString(Trade trade) {
        if (trade.getPrice() == null) {
            return null;
        }
        return trade.getPrice().stripTrailingZeros().toPlainString();
    }

}
