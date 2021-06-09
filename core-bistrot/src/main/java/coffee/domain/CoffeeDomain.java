package coffee.domain;

import coffee.repository.CoffeeRepository;
import com.example.demo.dto.in.CoffeeFilter;
import com.example.demo.dto.out.Coffee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CoffeeDomain {

  private ObjectMapper objectMapper;

  private CoffeeRepository coffeeRepository;

  public List<Coffee> getCoffees(final CoffeeFilter coffeeFilter) {
    return this.coffeeRepository.findAll(Example.of(coffeeFilter));
  }
}
