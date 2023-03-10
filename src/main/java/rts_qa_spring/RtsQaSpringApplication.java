package rts_qa_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rts_qa_spring.quotes.LoadCsvData;
import rts_qa_spring.quotes.Person;
import rts_qa_spring.quotes.PersonRepository;
import rts_qa_spring.quotes.QuoteRepository;

import java.util.List;

@SpringBootApplication
public class RtsQaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(RtsQaSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            PersonRepository personRepository,
            QuoteRepository quoteRepository) {
        return args -> {
            LoadCsvData dataLoader = new LoadCsvData();
            List<Person> personList = dataLoader.loadPerson();
            personRepository.saveAllAndFlush(personList);
        };
    }
}
