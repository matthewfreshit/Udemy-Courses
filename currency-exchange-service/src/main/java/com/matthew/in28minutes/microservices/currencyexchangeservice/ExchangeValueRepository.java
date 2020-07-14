/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matthew.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author matth
 */
public interface ExchangeValueRepository extends 
        JpaRepository<ExchangeValue, Long>{
    
    ExchangeValue findByFromAndTo(String from,String to);
}
