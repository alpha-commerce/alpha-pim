package com.alpha.pim.pim;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PimApplication.class,
  properties = {
    "spring.cloud.zookeeper.enabled=false", "spring.cloud.zookeeper.config.watcher.enabled=false"})
public class PimApplicationTests {

  @Test
  public void contextLoads() {
  }

}
