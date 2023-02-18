package com.complus.am.assignment.v2.handler;


import com.complus.am.assignment.v2.dto.TradeReport;
import com.complus.am.assignment.v2.enumeration.TradeReportType;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface TradeReportHandler {

    TradeReportType getTradeReportType();

    Class getTypeClass();

    default List<String> buildHeaders() {
        Class clazz = getTypeClass();
        return Arrays.stream(clazz.getDeclaredFields() )
                .filter(f -> f.getAnnotation(CsvBindByPosition.class) != null
                        && f.getAnnotation(CsvBindByName.class) != null)
                .sorted(Comparator.comparing(f -> f.getAnnotation(CsvBindByPosition.class).position()))
                .map(f -> f.getAnnotation(CsvBindByName.class ).column())
                .toList();
    }

    List<? extends TradeReport> handle(String brokerName, LocalDateTime tradeDate);

}
