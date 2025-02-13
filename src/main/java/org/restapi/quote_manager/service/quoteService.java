package org.restapi.quote_manager.service;

import org.restapi.quote_manager.repository.quoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class quoteService {
    
    @Autowired
    quoteRepository repository;
}
