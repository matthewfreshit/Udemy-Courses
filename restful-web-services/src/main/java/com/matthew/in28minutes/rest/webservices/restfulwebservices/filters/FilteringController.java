/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthew.in28minutes.rest.webservices.restfulwebservices.filters;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matth
 */
@RestController
public class FilteringController {
    
    
    //field1,field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("Value1","Value2","Value3");
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1","field2");
        
        return convertSomeBeanValue(mapping,filter);
    }
    
    
    //field2,field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveSomeBeanList(){
        List<SomeBean> asList = Arrays.asList(new SomeBean("Value1","Value2","Value3"),new SomeBean("Value4","Value5","Value6"));
        
        MappingJacksonValue mapping = new MappingJacksonValue(asList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field2","field3");
        
        return convertSomeBeanValue(mapping,filter);
    }
    
    private MappingJacksonValue convertSomeBeanValue(MappingJacksonValue mapping, SimpleBeanPropertyFilter filter){
        //Must define "SomeBeanFilter in SomeBean class
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);
        
        mapping.setFilters(filters);
        
        return mapping;
    }
}
