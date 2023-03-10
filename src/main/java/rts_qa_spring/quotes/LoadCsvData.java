package rts_qa_spring.quotes;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
@Log4j2
public class LoadCsvData {

    public List<Person> loadPerson() throws Exception {
        log.info("Loading data using --> person.csv");
        List<Record> records = csvToList("person.csv");
        List<Person> personList = new ArrayList<>();
        records.forEach(record -> {
            Person person = new Person();
            person.setId(Long.parseLong(record.getString("person_id")));
            person.setPersonNote(record.getString("person_note"));
            person.setBirthDate(record.getString("birth_date"));
            person.setDeathDate(record.getString("death_date"));
            person.setFirstName(record.getString("first_name"));
            person.setLastName(record.getString("last_name"));
            personList.add(person);
        });
        log.info(personList.toString());
        return personList;
    }

    public List<Quote> loadQuote(PersonRepository personRepository) throws Exception {
        // Todo: in foreach - use the PersonRepository to look up the Person
        log.info("Loading data using --> quote.csv");
        List<Record> records = csvToList("quote.csv");
        List<Quote> quoteList = new ArrayList<>();
        records.forEach(record -> {
            log.info(record.toString());
        });
        return quoteList;
    }

    public List<Record> csvToList (String filename) throws Exception {
        File file = getFile(filename);
        InputStream input = new FileInputStream(file);
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> records = parser.parseAllRecords(input);
        return records;
    }

    @NotNull
    @Contract("_ -> new")
    private File getFile(String fileName) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
