package com.example.demo.core;

import com.example.demo.dto.in.CoffeeFilter;
import com.example.demo.dto.out.Coffee;

public interface BistrotCore {

    Coffee get(CoffeeFilter coffeeFilter);
}
