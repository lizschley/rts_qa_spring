package rts_qa_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rts_qa_spring.quotes.*;


import java.util.*;

@SpringBootApplication
public class RtsQaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(RtsQaSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            PersonRepository personRepository, QuoteRepository quoteRepository) {
        return args -> {
            LoadCsvData dataLoader = new LoadCsvData();
            HashMap<String, Person> personHash = dataLoader.loadPerson();
            List<QuotesFromCsv> csvQuoteList = dataLoader.loadQuote();
            Iterator<QuotesFromCsv> quotesFromCsvIterator = csvQuoteList.listIterator();
            Person person = new Person();
            ArrayList<Quote> quotes = new ArrayList<Quote>();
            while (quotesFromCsvIterator.hasNext()) {
                QuotesFromCsv csvQuote = quotesFromCsvIterator.next();
                String key = csvQuote.getPersonId();
                person = personHash.get(key);
                Quote quote = new Quote();
                quote.setQuote(csvQuote.getQuote());
                quote.setQuoteNote(csvQuote.getQuoteNote());
                quote.setPerson(person);
                quotes.add(quote);
            }
            Collection<Person> values = personHash.values();
            ArrayList<Person> people = new ArrayList<Person>(values);
            personRepository.saveAll(people);
            quoteRepository.saveAll(quotes);
        };

    }
}
