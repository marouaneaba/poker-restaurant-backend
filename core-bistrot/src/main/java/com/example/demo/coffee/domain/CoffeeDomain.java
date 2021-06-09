package com.example.demo.coffee.domain;

import com.example.demo.coffee.repository.CoffeeRepository;
import com.example.demo.core.AbstractBistrotCore;
import com.example.demo.dto.in.CoffeeFilter;
import com.example.demo.dto.out.Coffee;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CoffeeDomain extends AbstractBistrotCore {

  private CoffeeRepository coffeeRepository;

  public List<Coffee> getCoffees(final CoffeeFilter coffeeFilter) {
    Example e = Example.of(coffeeFilter);
  this.coffeeRepository.findAll(e);
    return null;
  }
}
