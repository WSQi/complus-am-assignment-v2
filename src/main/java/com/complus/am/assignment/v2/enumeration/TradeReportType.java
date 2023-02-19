package com.complus.am.assignment.v2.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TradeReportType {
    FxForwardTradeReport("fxForward");

    private String value;

    private static final Map<String, TradeReportType> valueMap;

    static {
        valueMap = Arrays.stream(TradeReportType.values())
                .collect(Collectors.toMap(TradeReportType::getValue, Function.identity()));
    }

    TradeReportType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static TradeReportType fromValue(String value) {
        return valueMap.getOrDefault(value, null);
    }

}
