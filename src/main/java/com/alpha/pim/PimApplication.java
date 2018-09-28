package com.alpha.pim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PimApplication {

  public static void main(String[] args) {
    SpringApplication.run(PimApplication.class, args);
  }

  @GetMapping
  public long ping() {
    return System.currentTimeMillis();
  }
}
