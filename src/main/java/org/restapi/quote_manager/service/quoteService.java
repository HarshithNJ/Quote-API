package org.restapi.quote_manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.restapi.quote_manager.dto.quote;
import org.restapi.quote_manager.repository.quoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class quoteService {
    
    @Autowired
    quoteRepository repository;

    public ResponseEntity<Object> addQuote(quote quote) {
        if(repository.existsByText(quote.getText())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Quote already exists");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }else{
            repository.save(quote);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Quote added successfully");
            map.put("Quote", quote);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> addMultipleQuotes(List<quote> quotes) {
        for(quote quote : quotes){
            if(repository.existsByText(quote.getText())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Quote already exists");
    
                return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
            }
        }
        repository.saveAll(quotes);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Quotes added successfully");
        map.put("Quotes", quotes);

        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }
}
