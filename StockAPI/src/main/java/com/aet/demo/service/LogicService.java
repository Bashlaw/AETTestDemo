/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aet.demo.service;

import com.aet.demo.domain.Logic;
import com.aet.demo.resource.LogicResource;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@ExposesResourceFor(Logic.class)
@RequestMapping(value = "/api/logic", produces = "application/json")
public class LogicService {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> posts(@RequestBody Logic log) {
        LogicResource logic = new LogicResource();
        int res = logic.solution(log.getArray());
        log.setAns(res);
        log.setArray(log.getArray());
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

}
