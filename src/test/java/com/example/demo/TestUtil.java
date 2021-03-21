package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

class TestUtil {

  public static <T> String toJson(T object) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return mapper.writeValueAsString(object);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static String getFileContent(String file) throws IOException {
    return IOUtils.toString(new ClassPathResource(file).getInputStream(), Charset.defaultCharset());
  }

  public static <T> T stringToObject(String jsonString, Class<T> clazz) {

    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.readValue(jsonString, clazz);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  static Demo createDemo() {
    return Demo.builder()
        .id("1")
        .flightName("ethihad")
        .time("12:00")
        .build();
  }
  static DemoRequest createDemoRequest() {
    return DemoRequest.builder()
        .flightName("ethihad")
        .time("12:00")
        .build();
  }
  static DemoResponse createDemoResponse() {
    return DemoResponse.builder()
        .id("1")
        .flightName("ethihad")
        .time("12:00")
        .build();
  }
}
