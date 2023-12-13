package com.example.B;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Widget {

    @JsonProperty("num")
    private int num;
    @JsonProperty("fruit")
    private String fruit;
    @JsonProperty("letter")
    private char letter;
}
