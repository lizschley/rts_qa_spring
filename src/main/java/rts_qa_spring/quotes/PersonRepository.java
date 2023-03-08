package rts_qa_spring.quotes;

import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
