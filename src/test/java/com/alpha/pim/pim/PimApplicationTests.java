package com.alpha.pim.pim;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alpha.pim.PimApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PimApplication.class,
  properties = {
    "spring.cloud.zookeeper.enabled=false", "spring.cloud.zookeeper.config.watcher.enabled=false"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PimApplicationTests {

  private static final Logger LOGGER = LoggerFactory.getLogger(PimApplicationTests.class);

  @Autowired
  private WebApplicationContext context;

  protected static MockMvc mvc;

  /** The pim microservice test json. */
  private static JSONObject testDataJson = null;

  private static String productId = null;

  static {
    try {
      testDataJson = new JSONObject(
        FileUtils.readFileToString(new File("src/test/resources/testdata.json"), "UTF-8"));
    } catch (JSONException | IOException e) {
      LOGGER.error("Error occured at reading test data from file", e);
    }
  }

  @Before
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testPing() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/ping").contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  @Test
  public void testProduct1Create() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products");
    request.content(testDataJson.getJSONObject("createProductSuccess").toString());
    MvcResult result = mvc.perform(request.contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    String response = result.getResponse().getContentAsString();
    productId = (new JSONObject(response)).getString("id");
  }

  //@Test
  public void testProduct2FindAll() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products");
    mvc.perform(request.contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  //@Test
  public void testProduct2Find() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/{id}", productId);
    mvc.perform(request.contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  //@Test
  public void testProduct3Update() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/products/{id}", productId);
    request.content(testDataJson.getJSONObject("updateProductSuccess").toString());
    mvc.perform(request.contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  //@Test
  public void testProduct3UpdateDetails() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/products/{id}", productId);
    request.content(testDataJson.getJSONObject("updateProductDetailsSuccess").toString());
    mvc.perform(request.contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  //@Test
  public void testProduct4Delete() throws Exception {
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/products/{id}", productId);
    mvc.perform(request.contentType(MediaType.APPLICATION_JSON).secure(true))
      .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

}
