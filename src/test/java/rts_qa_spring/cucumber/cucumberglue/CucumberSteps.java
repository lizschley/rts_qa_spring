package rts_qa_spring.cucumber.cucumberglue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CucumberSteps {

    @LocalServerPort
    String port;

    ResponseEntity<String> lastResponse;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ResponseEntity<String> responseEntity;

    @When("the client named {string} calls hello")
    public void callHello(String name) {
        responseEntity = testRestTemplate.getForEntity("http://localhost:8083/examples/hello?name=" + name, String.class);
    }

    @Then("the client receives status code of 200")
    public void checkStatus200(){

        assertEquals(responseEntity.getStatusCode() , HttpStatus.OK);
    }

    @Then("the client call sum with {int} and {int}")
    public void callSum(int a, int b) {
        responseEntity = testRestTemplate.getForEntity("http://localhost:8080/examples/sum?a=" + a +"&b=" + b,
                String.class);

    }

    @And("the client with name {string} receives server hello message")
    public void checkHelloResponseValue(String name) {

        assertTrue(responseEntity.getBody().contains(name));
    }

    @And("check results of sum correspond with expected result {int}")
    public void checkResultOfSum(int expectedResult) {

        assertEquals(Integer.parseInt(responseEntity.getBody()), expectedResult);
    }

}
