/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthew.in28minutes.microservices.limitsservice;

import com.matthew.in28minutes.microservices.limitsservice.bean.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matth
 */
@RestController
public class LimitsConfigController {
    
    @Autowired
    private Configuration configuration;
    
    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfig(){
        return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
