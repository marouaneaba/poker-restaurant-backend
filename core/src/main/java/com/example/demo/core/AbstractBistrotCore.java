package com.example.demo.core;

import com.example.demo.facade.BistrotFacade;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.FatalBeanException;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractBistrotCore implements BistrotCore {

  private BistrotFacade bistrotFacade;

  @PostConstruct
  void init(){

    val version = Optional.ofNullable(this.getClass().getAnnotation(Implementation.class))
                          .map(Implementation::version)
                          .orElseThrow(() -> new FatalBeanException("AbstractShoeCore implementation should be annotated with @Implementation"));

    this.bistrotFacade.register(version, this);
  }

}
