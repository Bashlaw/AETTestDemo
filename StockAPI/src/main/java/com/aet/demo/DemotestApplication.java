package com.aet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import com.aet.demo.resource.LogicResource;

@EnableEntityLinks
@EnableHypermediaSupport(type = HypermediaType.HAL)
@SpringBootApplication
public class DemotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotestApplication.class, args);
        LogicResource logic = new LogicResource();
        int[] A = {1, 3, 6, 4, 1, 2};
        int[] B = {5, -1, -3};
        int res = logic.solution(A);
        int res1 = logic.solution(B);
        System.out.println("First anwser is equal to " + res);
        System.out.println("Second anwser is equal to " + res1);
    }

}
