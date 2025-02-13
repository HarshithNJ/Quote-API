package org.restapi.quote_manager.controller;

import org.restapi.quote_manager.dto.quote;
import org.restapi.quote_manager.service.quoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quoteController {
    
    @Autowired
    quoteService service;


    // to Add a new quote
    @PostMapping("/quotes")
    public ResponseEntity<Object> addQuote(@RequestBody quote quote){
        return service.addQuote(quote);
    }
}
