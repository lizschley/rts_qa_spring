package rts_qa_spring.quotes;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rts_qa_spring.RtsQaSpringApplication;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;


public class LoadCsvData {
    private final static Logger logger = LoggerFactory.getLogger(RtsQaSpringApplication.class);

    public static HashMap<String, String> tableData = new HashMap<>();

       //logger.info("");
    public void load_csv_data() throws Exception {
        tableData.put("Person", "person.csv");
        tableData.put("Quote", "quote.csv");
        String filename = tableData.get("Person");
        logger.info("****> ok - using> " + filename);
        List<Record> records = csvToJson(filename);
        logger.info(records.toString());
    }

    public List<Record> csvToJson (String filename) throws IOException {
        File file = getFile(filename);
        InputStream input = new FileInputStream(file);
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> records = parser.parseAllRecords(input);
        return records;
    }

    private File getFile(String fileName) throws IOException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

}
