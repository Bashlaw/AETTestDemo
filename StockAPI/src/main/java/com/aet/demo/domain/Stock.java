/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.domain;

/**
 *
 * @author Administrator
 */
public class Stock implements Identifiable {

    private long id;
    private String name, createDate, lastupdateDate;
    private double price;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastupdateDate() {
        return lastupdateDate;
    }

    @Override
    public void setLastupdateDate(String lastupdateDate) {
        this.lastupdateDate = lastupdateDate;
    }
}
