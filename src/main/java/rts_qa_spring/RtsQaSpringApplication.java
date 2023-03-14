package rts_qa_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rts_qa_spring.quotes.*;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class RtsQaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(RtsQaSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            PersonRepository personRepository) {
        return args -> {
            LoadCsvData dataLoader = new LoadCsvData();
            HashMap<String, Person> personHash = dataLoader.loadPerson();
            List<QuotesFromCsv> quoteList = dataLoader.loadQuote();
        };
    }
}
