package org.restapi.quote_manager.controller;

import org.restapi.quote_manager.service.quoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quoteController {
    
    @Autowired
    quoteService service;
}
