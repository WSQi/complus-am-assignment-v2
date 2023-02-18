package com.complus.am.assignment.v2.service;

import com.complus.am.assignment.v2.dto.TradeReport;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvReportService {

    @SneakyThrows
    public byte[] toCsv(List<String> headers, List<TradeReport> tradeReports) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        writer.append(headers.stream().collect(Collectors.joining(","))+"\n");
        StatefulBeanToCsvBuilder<TradeReport> builder = new StatefulBeanToCsvBuilder<>(writer);
        StatefulBeanToCsv<TradeReport> beanWriter = builder
                .withSeparator(',')
                .withApplyQuotesToAll(false)
                .build();
        beanWriter.write(tradeReports);
        writer.close();
        return os.toByteArray();
    }

}
