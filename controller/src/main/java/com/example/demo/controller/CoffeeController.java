package com.example.demo.controller;

import com.example.demo.common.BistrotEndPointApi;
import com.example.demo.dto.in.CoffeeFilter;
import com.example.demo.dto.out.Coffee;
import com.example.demo.facade.BistrotFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController(BistrotEndPointApi.COFFEES)
@RequiredArgsConstructor
public class CoffeeController {

    private final BistrotFacade bistrotFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Coffee> get(@RequestHeader Integer version, @RequestHeader CoffeeFilter coffeeFilter) {
        return ResponseEntity.ok(this.bistrotFacade.get(version).get(coffeeFilter));
    }
}
