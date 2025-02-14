package org.restapi.quote_manager.controller;

import java.util.List;

import org.restapi.quote_manager.dto.quote;
import org.restapi.quote_manager.service.quoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // to Add multiple quotes
    @PostMapping("/quotes/multiple")
    public ResponseEntity<Object> addMultipleQuotes(@RequestBody List<quote> quotes){
        return service.addMultipleQuotes(quotes);
    }






    // to Get all quotes
    @GetMapping("/quotes")
    public ResponseEntity<Object> getAllQuotes(){
        return service.getAllQuotes();
    }

    // to Get quotes by author name
    @GetMapping("/quotes/{author}")
    public ResponseEntity<Object> getQuoteByAuthor(@PathVariable String author){
        return service.getQuoteByAuthor(author);
    }

    // to get quotes by category
    @GetMapping("/quotes/category/{category}")
    public ResponseEntity<Object> getQuoteByCategory(@PathVariable String category){
        return service.getQuoteByCategory(category);
    }
}
