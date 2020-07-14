/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthew.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matth
 */
@RestController
public class PersonVersioningController {
    
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Matthew Leleux");
    }
    
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Matthew","Leleux"));
    }
    
    @GetMapping(value="/person/param",params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Matthew Leleux");
    }
    
    @GetMapping(value="/person/param",params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Matthew","Leleux"));
    }
    
    @GetMapping(value="/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Matthew Leleux");
    }
    
    @GetMapping(value="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Matthew","Leleux"));
    }
    
    @GetMapping(value="/person/produces",produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Matthew Leleux");
    }
    
    @GetMapping(value="/person/produces",produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Matthew","Leleux"));
    }
}
