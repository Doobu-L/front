package com.example.front.domain;


import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SchedulerDto {
  private List<ScheduleDto> schedules;
  private Long id;
  private String title;
}
