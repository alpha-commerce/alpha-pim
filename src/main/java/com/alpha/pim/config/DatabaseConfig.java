package com.alpha.pim.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseConfig {

  public DatabaseConfig() {
    super();
  }

  private Implementation impl;
}
