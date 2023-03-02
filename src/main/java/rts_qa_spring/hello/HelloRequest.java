package rts_qa_spring.hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloRequest {
    private final String name;

    public HelloRequest(
            @JsonProperty("hello") String name) {
        this.name = name;
    }

    public String getHello() {
        return hello_string;
    }
}

