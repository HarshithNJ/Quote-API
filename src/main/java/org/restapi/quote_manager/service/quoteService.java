package org.restapi.quote_manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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












    public ResponseEntity<Object> getAllQuotes() {
        List<quote> quotes = repository.findAll();

        if(quotes.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No quotes found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Quotes fetched successfully");
            map.put("Quotes", quotes);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getQuoteByAuthor(String author) {
        List<quote> quotes = repository.findByAuthor(author);

        if(quotes.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No quotes found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Quotes fetched successfully");
            map.put("Quotes", quotes);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getQuoteByCategory(String category) {
        List<quote> quotes = repository.findByCategory(category);

        if (quotes.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No quotes found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Quotes fetched successfully");
            map.put("Quotes", quotes);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }













    public ResponseEntity<Object> deleteQuote(int id) {
        Optional<quote> quote = repository.findById(id);

        if(quote.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Quote deleted successfully");

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Quote not found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }













    public ResponseEntity<Object> updateQuote(int id, quote quote) {
        Optional<quote> quote1 = repository.findById(id);

        if(quote1.isPresent()){
            quote quote2 = quote1.get();

            if(quote.getAuthor() != null)
                quote2.setAuthor(quote.getAuthor());
            
            if(quote.getText() != null)
                quote2.setText(quote.getText());

            if(quote.getCategory() != null)
                quote2.setCategory(quote.getCategory());

            repository.save(quote2);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Quote updated successfully");
            map.put("Quote", quote2);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Quote not found with id: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }
}
