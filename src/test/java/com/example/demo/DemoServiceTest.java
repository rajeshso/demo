package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class DemoServiceTest {

  @Mock
  DemoMapper mockMapper;
  @Mock
  DemoRepository mockRepository;
  @InjectMocks
  DemoService demoService;

  @Test
  void givenDemoRequestWhenCreateDemoShouldSaveDemoInRepo() {
    //given
    final DemoRequest demoRequest = TestUtil.createDemoRequest();
    final Demo demo = TestUtil.createDemo();
    final DemoResponse demoResponse = TestUtil.createDemoResponse();
    doReturn(demo)
        .when(mockMapper)
        .toDemo(demoRequest);
    doReturn(demoResponse)
        .when(mockMapper)
        .toDemoResponse(demo);
    doReturn(demo)
        .when(mockRepository)
        .save(any(Demo.class));
    //when
    final DemoResponse actual = demoService.createDemo(demoRequest);
    //then
    assertThat(actual.getId()).isNotNull();
  }
  //GET
  //PUT
  //DELETE
}
