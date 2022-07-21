package com.example.front.service.api;

import com.example.front.domain.UserDto;
import com.example.front.resttemplate.SchedulerRestTemplate;
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
    httpHeaders.setBearerAuth("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY1ODQwMTI2NX0.oeGpAwj32QKWeFOW4_v0mvDBBCiSomokHqo4t-3RYPOnmvPRJi-xld15N7RyohTuZgznMqV8Q1taTnulW-AlUw");
    ResponseEntity<UserDto> response = restTemplate.get("/api/users"+"/4",httpHeaders,UserDto.class);
    return response.getBody();
  }
}
