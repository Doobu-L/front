package com.example.front.service.api;

import com.example.front.domain.ListDto;
import com.example.front.domain.ScheduleDto;
import com.example.front.domain.UserDto;
import com.example.front.resttemplate.SchedulerRestTemplate;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainApiService {

  private final SchedulerRestTemplate restTemplate;


  public UserDto getUser() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBearerAuth("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY1ODgyMjYzNn0.hOMQ2FYsGPDCOPvtGpV-fIcsF-sjZCXx63Q6nNz1EZC6z5kdlv1aO8Kzb-NdZFSVtNUAJKjY-GptR3Kse0-7pQ");
    ResponseEntity<UserDto> response = restTemplate.get("/api/users"+"/4",httpHeaders,UserDto.class);
    return response.getBody();
  }

  public List<ScheduleDto> getSchedulesBySchedulersIds(List<Long> ids){
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBearerAuth("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY1ODgyMjYzNn0.hOMQ2FYsGPDCOPvtGpV-fIcsF-sjZCXx63Q6nNz1EZC6z5kdlv1aO8Kzb-NdZFSVtNUAJKjY-GptR3Kse0-7pQ");

    ListDto listDto = new ListDto();
    listDto.setIds(ids);
    ResponseEntity<ScheduleDto[]> response = restTemplate.post("/api/schedules",httpHeaders,listDto,ScheduleDto[].class);
    return Arrays.asList(response.getBody());
  }
}
