package com.example.demo.coffee.domain;

import com.example.demo.coffee.repository.CoffeeRepository;
import com.example.demo.core.AbstractBistrotCore;
import com.example.demo.core.Implementation;
import com.example.demo.dto.in.CoffeeFilter;
import com.example.demo.dto.out.Coffee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;

import java.util.List;

@Implementation(version = 1)
@RequiredArgsConstructor
public class CoffeeDomain extends AbstractBistrotCore {

  private CoffeeRepository coffeeRepository;

  public List<Coffee> getCoffees(final CoffeeFilter coffeeFilter) {
    Example coffeeExample = Example.of(coffeeFilter);
    return this.coffeeRepository.findAll(coffeeExample);
  }
}
