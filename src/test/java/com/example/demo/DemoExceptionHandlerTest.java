package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.http.MockHttpInputMessage;

public class DemoExceptionHandlerTest {

  private DemoExceptionHandler demoExceptionHandler = new DemoExceptionHandler();

  @Test
  void canMapDataNotFoundException() {
    DataNotFoundException dataNotFoundException = new DataNotFoundException(String.format("%s by '%s' was not found", Demo.class.getSimpleName(), "123"));
    final ResponseEntity<String> stringResponseEntity = demoExceptionHandler
        .handleDataNotFoundException(dataNotFoundException);
    assertThat(stringResponseEntity.getBody()).isEqualTo("Demo by '123' was not found");
  }

  @Test
  void canMapHttpMessageNotReadableException() throws IOException {
    //given
    MockHttpInputMessage mockHttpInputMessage = new MockHttpInputMessage("".getBytes());
    HttpMessageNotReadableException httpMessageNotReadableException = new HttpMessageNotReadableException("",new Exception("flightName should not be null"),
        mockHttpInputMessage);
    //when
    final ResponseEntity<String> stringResponseEntity = demoExceptionHandler
        .handleHttpMessageNotReadableException(httpMessageNotReadableException);
    //then
    assertThat(stringResponseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
    assertThat(stringResponseEntity.getBody()).isEqualTo("flightName should not be null");
  }

}
