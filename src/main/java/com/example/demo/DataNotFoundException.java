package com.example.demo;

import lombok.Getter;

@Getter
class DataNotFoundException extends RuntimeException {

  public DataNotFoundException(String message) {
    super(message);
  }
/*  private final Class<?> clazz;
  private final String val;

  public DataNotFoundException(@NonNull Class<?> clazz, String val) {
    super(format("%s by '%s' was not found", clazz.getSimpleName(), val));
    this.clazz = clazz;
    this.val = val;
  }

  public DataNotFoundException(String message) {
    super(message);
    this.clazz = null;
    this.val = null;
  }*/
}
