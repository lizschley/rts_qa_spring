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
        logger.info("STARTING : Spring boot application starting");
        SpringApplication.run(RtsQaSpringApplication.class, args);
        logger.info("STOPPED  : Spring boot application stopped");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("EXECUTING : command line runner");

        for(int i=0;i<=10;i++){
            logger.info("Count ="+i);
        }
    }
}
