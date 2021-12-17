/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.service;

import com.aet.demo.domain.Ping;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Ping.class)
@RequestMapping(value = "/api/ping", produces = "application/json")
public class PingService {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getPing(){
        Ping ping = new Ping();
        ping.setSuccess(true);
        return new ResponseEntity<>(ping, HttpStatus.OK);
    }
}
