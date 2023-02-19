package com.complus.am.assignment.v2.controller;

import com.complus.am.assignment.v2.enumeration.TradeReportType;
import com.complus.am.assignment.v2.service.TradeReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Trade Report Controller")
@RestController
@RequestMapping("/v1/report")
@RequiredArgsConstructor
public class TradeReportController {

    private final TradeReportService tradeReportService;

    @Operation(summary = "Generate Trade Report")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "CSV generated successfully",
                        content = {@Content(mediaType = "text/csv")}),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content)
            }
    )
    @GetMapping(value = "/trade/{reportType}", produces = "text/csv")
    public byte[] getCsvTradeReport(@PathVariable("reportType")
                                        @NotNull TradeReportType reportType,
                                 @RequestParam
                                        @Schema(description = "used to filter records listed in the report", example = "Broker_A")
                                        @NotNull String brokerName,
                                 @RequestParam
                                        @Schema(description = "used to filter records listed in the report", example = "2020-04-08")
                                        @NotNull String tradeDate) {
        return tradeReportService.getCsvTradeReport(reportType, brokerName, tradeDate);
    }

}
