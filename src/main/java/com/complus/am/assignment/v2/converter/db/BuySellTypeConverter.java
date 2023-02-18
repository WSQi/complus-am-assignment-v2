package com.complus.am.assignment.v2.converter.db;

import com.complus.am.assignment.v2.enumeration.BuySellType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BuySellTypeConverter implements AttributeConverter<BuySellType, String> {
    @Override
    public String convertToDatabaseColumn(BuySellType giftCode) {
        return giftCode.getValue();
    }

    @Override
    public BuySellType convertToEntityAttribute(String s) {
        return BuySellType.fromValue(s);
    }
}
