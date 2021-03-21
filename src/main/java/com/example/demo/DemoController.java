package com.example.demo;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-controller")
@Slf4j
@RequiredArgsConstructor
@Validated
public class DemoController {

  private final DemoService demoService;

  @PostMapping(path = "/",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public DemoResponse createDemo(@Valid @RequestBody DemoRequest demoRequest) {
    return demoService.createDemo(demoRequest);
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public DemoResponse getDemo(@PathVariable("id") String id) {
    return demoService.getDemo(id);
  }

  @GetMapping(path = "/", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public List<DemoResponse> getDemoList() {
    return demoService.getDemoList();
  }


  @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public void updateDemo(
      @PathVariable("id") String id,
      @RequestBody @Valid DemoRequest demoRequest
  ) {
    demoService.updateDemo(id, demoRequest);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteDemo(
      @PathVariable("id") String id
  ) {
    demoService.deleteDemo(id);
  }
}
