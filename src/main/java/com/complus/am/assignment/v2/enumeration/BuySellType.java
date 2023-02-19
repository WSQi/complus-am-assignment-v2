package com.complus.am.assignment.v2.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum BuySellType {
    BUY("B"),
    SELL("S");

    private String value;

    private static final Map<String, BuySellType> valueMap;

    static {
        valueMap = Arrays.stream(BuySellType.values())
                .collect(Collectors.toMap(BuySellType::getValue, Function.identity()));
    }

    BuySellType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static BuySellType fromValue(String value) {
        return valueMap.getOrDefault(value, null);
    }

}
