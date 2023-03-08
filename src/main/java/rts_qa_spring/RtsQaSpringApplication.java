package rts_qa_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rts_qa_spring.quotes.LoadData;

@SpringBootApplication
public class RtsQaSpringApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RtsQaSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LoadData classObj = new LoadData();
        classObj.load_data();
    }
}
