/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.service;

import com.aet.demo.domain.Stock;
import com.aet.demo.repository.StockRepository;
import com.aet.demo.resource.StockResource;
import com.aet.demo.resource.StockResourceAssembler;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Stock.class)
@RequestMapping(value = "/api/stock", produces = "application/json")
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<StockResource>> findAllOrders() {
        List<Stock> stocks = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(stocks), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<StockResource> createOrder(@RequestBody Stock stock) {
        Stock createdStock = repository.create(stock);
        return new ResponseEntity<>(assembler.toResource(createdStock), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StockResource> findOrderById(@PathVariable Long id) {
        Optional<Stock> stock = repository.findById(id);

        if (stock.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(stock.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<StockResource> updateOrder(@PathVariable Long id, @RequestBody Stock updatedStock) {
        boolean wasUpdated = repository.update(id, updatedStock);

        if (wasUpdated) {
            return findOrderById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
