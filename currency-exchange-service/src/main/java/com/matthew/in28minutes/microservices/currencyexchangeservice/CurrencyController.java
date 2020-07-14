/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthew.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matth
 */
@RestController
public class CurrencyController {
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieExchangeValue(@PathVariable String from, @PathVariable String to){
        
        return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
    }
}
