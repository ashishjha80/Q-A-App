package com.crio.buildoutqa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BuildoutQaApplication {
  public static void main(String[] args) {
    SpringApplication.run(BuildoutQaApplication.class, args);
  }

  // Want a new obj every time
  @Bean
  @Scope("prototype")
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}