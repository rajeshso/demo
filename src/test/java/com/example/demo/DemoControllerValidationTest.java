package com.example.demo;

import static com.example.demo.TestUtil.getFileContent;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@WebMvcTest(controllers = DemoController.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class DemoControllerValidationTest {

  @Mock
  private DemoService demoService;

  @Autowired
  public MockMvc mockMvc;

  @Test
  void positiveTest() throws Exception {
    MockHttpServletRequestBuilder builder = post("/demo-controller")
        .contentType(APPLICATION_JSON)
        .accept(APPLICATION_JSON)
        .content(getFileContent("templates/search-invalid-search-type.json"));

    mockMvc.perform(builder).andExpect(status().isBadRequest());
  }
}
