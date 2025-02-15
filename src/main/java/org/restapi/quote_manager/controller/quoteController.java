package org.restapi.quote_manager.controller;

import java.util.List;

import org.restapi.quote_manager.dto.quote;
import org.restapi.quote_manager.service.quoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Quote Controller", description = "A API for quote Management")
public class quoteController {
    
    @Autowired
    quoteService service;


    // to Add a new quote
    @PostMapping("/quotes")
    @Operation(summary = "To add Quote", description = "Add a new quote")
    @ApiResponse(responseCode = "201", description = "Quote added successfully")
    @ApiResponse(responseCode = "406", description = "Quote already exists")
    public ResponseEntity<Object> addQuote(@RequestBody quote quote){
        return service.addQuote(quote);
    }

    // to Add multiple quotes
    @PostMapping("/quotes/multiple")
    @Operation(summary = "To add Multiple Quotes", description = "Add multiple quotes")
    @ApiResponse(responseCode = "201", description = "Quotes added successfully")
    @ApiResponse(responseCode = "406", description = "Quote already exists")
    public ResponseEntity<Object> addMultipleQuotes(@RequestBody List<quote> quotes){
        return service.addMultipleQuotes(quotes);
    }






    // to Get all quotes
    @GetMapping("/quotes")
    @Operation(summary = "To get all quotes", description = "Get all quotes")
    @ApiResponse(responseCode = "302", description = "Quotes retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No quotes found")
    public ResponseEntity<Object> getAllQuotes(){
        return service.getAllQuotes();
    }

    // to Get quotes by author name
    @GetMapping("/quotes/{author}")
    @Operation(summary = "To get quotes by author", description = "Get quotes by author")
    @ApiResponse(responseCode = "302", description = "Quotes retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No quotes found for the given author")
    public ResponseEntity<Object> getQuoteByAuthor(@PathVariable String author){
        return service.getQuoteByAuthor(author);
    }

    // to get quotes by category
    @GetMapping("/quotes/category/{category}")
    @Operation(summary = "To get quotes by category", description = "Get quotes by category")
    @ApiResponse(responseCode = "302", description = "Quotes retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No quotes found for the given category")
    public ResponseEntity<Object> getQuoteByCategory(@PathVariable String category){
        return service.getQuoteByCategory(category);
    }








    // To Delete a Quote
    @DeleteMapping("/quotes/{id}")
    @Operation(summary = "To delete a quote", description = "Delete a quote")
    @ApiResponse(responseCode = "200", description = "Quote deleted successfully")
    @ApiResponse(responseCode = "404", description = "Quote not found")
    public ResponseEntity<Object> deleteQuote(@PathVariable int id){
        return service.deleteQuote(id);
    }






    // To Update a Quote
    @PatchMapping("/quotes/{id}")
    @Operation(summary = "To update a quote", description = "Update a quote")
    @ApiResponse(responseCode = "200", description = "Quote updated successfully")
    @ApiResponse(responseCode = "404", description = "Quote not found")
    public ResponseEntity<Object> updateQuote(@PathVariable int id, @RequestBody quote quote){
        return service.updateQuote(id, quote);
    }
}
