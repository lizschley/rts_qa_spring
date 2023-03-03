package rts_qa_spring.cucumber.cucumberglue;

import rts_qa_spring.RtsQaSpringApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = RtsQaSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = RtsQaSpringApplication.class, loader = SpringBootContextLoader.class)

public class CucumberSpringConfiguration {
}


