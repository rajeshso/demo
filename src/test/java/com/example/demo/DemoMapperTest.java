package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DemoMapperImpl.class})
public class DemoMapperTest {

  @Autowired
  public DemoMapper demoMapper;

  @Test
  void toDemo_shouldMapDemoRequestToDemo() {
    //given
    final DemoRequest given = TestUtil.createDemoRequest();
    final Demo expected = TestUtil.createDemo();
    //when
    final Demo actual = demoMapper.toDemo(given);
    //then
    assertThat(actual).isEqualToIgnoringGivenFields(expected,"id");
  }

  //DemoResponse toDemoResponse(Demo demo);
  @Test
  void toDemoResponse_shouldMapDemoToDemoResponse() {
    //given
    final Demo given = TestUtil.createDemo();
    final DemoResponse expected = TestUtil.createDemoResponse();
    //when
    final DemoResponse actual = demoMapper.toDemoResponse(given);
    //then
    assertThat(actual).isEqualToIgnoringGivenFields(expected,"id");
  }

}
