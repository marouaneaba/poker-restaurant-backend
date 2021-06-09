package com.example.demo.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Coffee {

    @JsonProperty("name")
    public String name;

    @JsonProperty("quantity")
    public Integer quantity;

    @JsonProperty("isAvailable")
    public boolean isAvailable;

    @JsonProperty("isSelected")
    public boolean isSelected;
}
