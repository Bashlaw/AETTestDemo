/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.repository;

/**
 *
 * @author Administrator
 */
import org.springframework.stereotype.Repository;

import com.aet.demo.domain.Stock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class StockRepository extends InMemoryRepository<Stock> {

    @Override
    protected void updateIfExists(Stock original, Stock updated) {
        original.setName(updated.getName());
        original.setPrice(updated.getPrice());
//        original.setCreateDate(updated.getCreateDate());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);
        original.setLastupdateDate(formatDateTime);
    }

}
