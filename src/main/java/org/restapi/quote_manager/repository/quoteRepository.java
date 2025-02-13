package org.restapi.quote_manager.repository;

import org.restapi.quote_manager.dto.quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quoteRepository  extends JpaRepository<quote, Integer>{

}
