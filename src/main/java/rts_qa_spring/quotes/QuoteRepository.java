package rts_qa_spring.quotes;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuoteRepository extends PagingAndSortingRepository<Quote, Long> {
}
