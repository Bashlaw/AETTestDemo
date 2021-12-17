/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.resource;

import com.aet.demo.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class StockResourceAssembler extends ResourceAssembler<Stock, StockResource> {

    @Autowired
    protected EntityLinks entityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public StockResource toResource(Stock stock) {

        StockResource resource = new StockResource(stock);

        final Link selfLink = entityLinks.linkToSingleResource(stock);

        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));

        return resource;
    }
}
