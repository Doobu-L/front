package com.example.front.domain;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private Set<SchedulerDto> schedulerDtos;

  private String userId;
  private String password;
  private String email;
}