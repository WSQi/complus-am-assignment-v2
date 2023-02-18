package com.complus.am.assignment.v2.entity;

import com.complus.am.assignment.v2.enumeration.BuySellType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRADE")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Trade extends BaseEntity {

    @Length(max = 20)
    @Column(name = "broker_name", nullable = false)
    private String brokerName;

    @Length(max = 20)
    @Column(name = "trade_ref", nullable = false, unique = true)
    private String tradeRef;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Length(max = 50)
    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "trade_date", nullable = false)
    private LocalDateTime tradeDate;

    @Column(name = "qty", nullable = false)
    private BigInteger qty;

    @Length(max = 1)
    @Column(name = "buy_sell", nullable = false)
    private BuySellType buySell;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
