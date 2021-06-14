package com.example.demo.core;

import com.example.demo.dto.in.CoffeeFilter;
import com.example.demo.dto.out.Coffee;

import java.util.List;

public interface BistrotCore {

    List<Coffee> getCoffees(CoffeeFilter coffeeFilter);
}
