package com.alpha.pim.pim;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alpha.pim.PimApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PimApplication.class,
  properties = {
    "spring.cloud.zookeeper.enabled=false", "spring.cloud.zookeeper.config.watcher.enabled=false"})
public class PimApplicationTests {

  @Autowired
  private WebApplicationContext context;

  protected static MockMvc mvc;

  @Before
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testPing() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

}
