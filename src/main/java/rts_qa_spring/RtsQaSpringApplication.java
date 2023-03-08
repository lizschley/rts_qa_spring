package rts_qa_spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RtsQaSpringApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory
            .getLogger(RtsQaSpringApplication.class);

    public static void main(String[] args) {
        logger.info("1. STARTING : Spring boot application starting");
        SpringApplication.run(RtsQaSpringApplication.class, args);
        logger.info("3. STOPPED  : Spring boot application end of main");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("2. EXECUTING : command line runner");

        for(int i=0;i<=5;i++){
            logger.info("Count = "+i);
        }
    }
}
