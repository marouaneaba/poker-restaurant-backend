package com.example.demo.facade;

import com.example.demo.core.BistrotCore;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BistrotFacade {

    private final Map<Integer, BistrotCore> implementations = new HashMap<>();

    public BistrotCore get(Integer version){
        return implementations.get(version);
    }

    public void register(Integer version, BistrotCore implementation){
        this.implementations.put(version, implementation);
    }
}
