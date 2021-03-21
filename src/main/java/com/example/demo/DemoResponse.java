package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoResponse {
  private String id;
  private String flightName;
  private String time;
}
