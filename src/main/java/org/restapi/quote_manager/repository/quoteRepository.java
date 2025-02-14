package org.restapi.quote_manager.repository;

import java.util.List;

import org.restapi.quote_manager.dto.quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quoteRepository  extends JpaRepository<quote, Integer>{

    boolean existsByText(String text);

    List<quote> findByAuthor(String author);

    List<quote> findByCategory(String category);

}
