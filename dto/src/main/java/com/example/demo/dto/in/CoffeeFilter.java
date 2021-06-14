package com.example.demo.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CoffeeFilter {

    @JsonProperty("isSelected")
    public boolean isSelected;

    @JsonProperty("isAvailable")
    public boolean isAvailable;
}
