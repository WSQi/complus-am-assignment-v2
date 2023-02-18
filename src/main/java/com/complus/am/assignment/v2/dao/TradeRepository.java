package com.complus.am.assignment.v2.dao;

import com.complus.am.assignment.v2.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    List<Trade> findAllByBrokerNameAndTradeDate(String brokerName, LocalDateTime tradeDate);

}
