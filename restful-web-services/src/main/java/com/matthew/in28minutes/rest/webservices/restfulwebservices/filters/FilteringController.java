/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthew.in28minutes.rest.webservices.restfulwebservices.filters;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matth
 */
@RestController
public class FilteringController {
    
    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("Value1","Value2","Value3");
    }
    
    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(new SomeBean("Value1","Value2","Value3"),new SomeBean("Value4","Value5","Value6"));
    }
}
