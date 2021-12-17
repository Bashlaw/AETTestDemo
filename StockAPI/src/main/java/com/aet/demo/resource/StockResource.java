/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.resource;

import com.aet.demo.domain.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Administrator
 */
public class StockResource extends ResourceSupport {

    private final long id;
    private final String name, createDate, lastupdateDate;
    private final double price;

    public StockResource(Stock stock) {
        id = stock.getId();
        name = stock.getName();
        price = stock.getPrice();
        createDate = stock.getCreateDate();
        lastupdateDate = stock.getLastupdateDate();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getLastupdateDate() {
        return lastupdateDate;
    }

}
