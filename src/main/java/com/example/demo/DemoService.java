package com.example.demo;

import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DemoService {

  private final DemoMapper demoMapper;
  private final DemoRepository demoRepository;

  public DemoResponse createDemo(@NonNull final DemoRequest demoRequest) {
    return demoMapper.toDemoResponse(demoRepository.save(demoMapper.toDemo(demoRequest)));
  }

  public List<DemoResponse> getDemoList() {
    return demoMapper.toDemoResponseList(demoRepository.findAll());
  }

  public DemoResponse getDemo(@NonNull final String id) {
    final Optional<Demo> optionalDemo = demoRepository.findById(id);
    if (optionalDemo.isPresent()) {
      return demoMapper.toDemoResponse(optionalDemo.get());
    }else {
      throw new DataNotFoundException(String.format("%s by '%s' was not found", Demo.class.getSimpleName(), id));
    }
  }

  public void updateDemo(@NonNull final String id, DemoRequest demoRequestUpdate) {
    final Optional<Demo> optionalDemo = demoRepository.findById(id);
    if (optionalDemo.isPresent()) {
      final Demo demoCurrent = optionalDemo.get();
      final Demo demoUpdated = demoCurrent.toBuilder().flightName(demoRequestUpdate.getFlightName())
          .time(demoRequestUpdate.getTime())
          .build();
      demoRepository.save(demoUpdated);
    }else {
      throw new DataNotFoundException(String.format("%s by '%s' was not found", Demo.class.getSimpleName(), id));
    }
  }

  public void deleteDemo(@NonNull final String id) {
    demoRepository.deleteById(id);
  }


}
