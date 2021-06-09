package com.poker.shop.core;

import com.example.demo.annotation.Implementation;

@Implementation(version = 2)
public class ShoeCoreNew /*extends AbstractShoeCore*/ {

  /*@Override
  public Shoes search(final ShoeFilter filter) {
    return Shoes.builder()
                .shoes(List.of(Shoe.builder()
                                   .name("New shoe")
                                   .color(filter.getColor().orElse(ShoeFilter.Color.BLACK))
                                   .size(filter.getSize().orElse(BigInteger.TWO))
                                   .build()))
                .build();
  }
  */

}
