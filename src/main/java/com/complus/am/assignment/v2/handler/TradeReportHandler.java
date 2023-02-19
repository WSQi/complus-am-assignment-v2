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

    /**
     * Used for matching the correct handler for TradeReportRegistry
     * @return enum TradeReportType
     */
    TradeReportType getTradeReportType();

    /**
     * For headers generation
     * @return Class with signature of <? extends TradeReport>
     */
    Class getTypeClass();

    /**
     * Default implementation of headers generation
     * @return List of headers in String format
     */
    default List<String> buildHeaders() {
        Class clazz = getTypeClass();
        return Arrays.stream(clazz.getDeclaredFields() )
                .filter(f -> f.getAnnotation(CsvBindByPosition.class) != null
                        && f.getAnnotation(CsvBindByName.class) != null)
                .sorted(Comparator.comparing(f -> f.getAnnotation(CsvBindByPosition.class).position()))
                .map(f -> f.getAnnotation(CsvBindByName.class ).column())
                .toList();
    }

    /**
     * Concrete implementation of retrieving TradeReports
     * @param brokerName
     * @param tradeDate
     * @return List of subclass of TradeReport
     */
    List<? extends TradeReport> handle(String brokerName, LocalDateTime tradeDate);

}
