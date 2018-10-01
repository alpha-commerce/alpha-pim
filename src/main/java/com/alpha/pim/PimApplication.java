package com.alpha.pim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableSwagger2
public class PimApplication {

  public static void main(String[] args) {
    SpringApplication.run(PimApplication.class, args);
  }

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select().apis(RequestHandlerSelectors.basePackage("com.alpha.pim.web"))
      .build();
  }

  @GetMapping("/ping")
  public long ping() {
    return System.currentTimeMillis();
  }
}
