package com.example.demo;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DemoMapper {
  DemoResponse toDemoResponse(Demo demo);
  Demo toDemo(DemoRequest demoRequest);
  @IterableMapping(elementTargetType = DemoResponse.class)
  List<DemoResponse> toDemoResponseList(List<Demo> demoList);
}
