package com.alpha.pim.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "product")
@Getter
@Setter
@Component
public class ProductConfig {

  public ProductConfig() {
    super();
  }

  private DatabaseConfig database;
}
