package controller;

import com.example.demo.common.BistrotEndPointApi;
import com.example.demo.dto.out.Coffee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CoffeeController {

  private MockMvc mockMvc;

  private ObjectMapper jsonMapper;

  @Test
  @Rollback
  @DisplayName("Get /Coffees")
  public void shouldReturnSuccessAndAllCoffeesWhenDatabaseIsNotEmpty() throws Exception {
    // Given
    // When
    MvcResult result =
        this.mockMvc
            .perform(
                get(BistrotEndPointApi.COFFEES)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("version", 1))
            .andExpect(status().isOk())
            .andReturn();
    // Then
    assertThat(result)
            .isNotNull()
            .asList()
            .hasSizeGreaterThanOrEqualTo(1);
  }

  @Test
  @Rollback
  @DisplayName("Get /Coffees")
  public void shouldReturnSuccessAndEmptyWhenDatabaseIsEmpty() throws Exception {
    // Given
    // vide db
    // When
    MvcResult result =
        this.mockMvc
            .perform(
                get(BistrotEndPointApi.COFFEES)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("version", 1))
            .andExpect(status().isOk())
            .andReturn();
    // Then
    assertThat(result)
            .asList()
            .isEmpty();
  }

  @Test
  @DisplayName("Get /Coffees")
  public void shouldReturnSuccessAndCoffeesAvailableWhenNeedAvailableCoffees() throws Exception {
    // Given
    // When
    MvcResult result =
        this.mockMvc
            .perform(
                get(BistrotEndPointApi.COFFEES)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("version", 1)
                    .param("available", Boolean.TRUE.toString()))
            .andExpect(status().isOk())
            .andReturn();
    // Then
    List<Coffee> coffees = this.jsonMapper.readValue(result.getResponse().getContentAsString(), List.class);
    assertThat(coffees).extracting(Coffee::isAvailable).allMatch(value -> true == value);
    assertThat(coffees).extracting(Coffee::isAvailable).noneMatch(value -> false == value);
  }

  @Test
  @DisplayName("Get /Coffees")
  public void shouldReturnSucceessAndCoffeesSelectedWhenNeedSelectedCoffees() throws Exception {
    // Given
    // When
    MvcResult result =
        this.mockMvc
            .perform(
                get(BistrotEndPointApi.COFFEES)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("version", 1)
                    .param("selecteed", Boolean.TRUE.toString()))
            .andExpect(status().isOk())
            .andReturn();
    // Then
    List<Coffee> coffees = this.jsonMapper.readValue(result.getResponse().getContentAsString(), List.class);
    assertThat(coffees).extracting(Coffee::isSelected).allMatch(value -> true == value);
    assertThat(coffees).extracting(Coffee::isSelected).noneMatch(value -> false == value);
  }
}
