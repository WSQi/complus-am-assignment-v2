package com.complus.am.assignment.v2.converter.web;

import com.complus.am.assignment.v2.enumeration.TradeReportType;
import org.springframework.core.convert.converter.Converter;

public class TradeReportTypeConverter implements Converter<String, TradeReportType> {
    @Override
    public TradeReportType convert(String source) {
        return TradeReportType.fromValue(source);
    }
}
