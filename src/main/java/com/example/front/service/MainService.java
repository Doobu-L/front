package com.example.front.service;

import com.example.front.domain.UserDto;
import com.example.front.service.api.MainApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

  private final MainApiService apiService;

  public UserDto getUser(){
    return apiService.getUser();
  }

}
