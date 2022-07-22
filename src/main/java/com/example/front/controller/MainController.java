package com.example.front.controller;

import com.example.front.domain.ScheduleDto;
import com.example.front.domain.SchedulerDto;
import com.example.front.domain.UserDto;
import com.example.front.service.MainService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

  private final MainService mainService;

  @GetMapping
  public String loadMain(ModelMap modelMap){
    UserDto user = mainService.getUser();
    List<SchedulerDto> schedulerDtos = user.getSchedulerDtos().stream().collect(Collectors.toList());
    List<ScheduleDto> scheduleDtos = schedulerDtos.stream()
        .map(SchedulerDto::getSchedules)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

    modelMap.addAttribute("user",user);
    modelMap.addAttribute("schedulers",schedulerDtos);
    modelMap.addAttribute("schedules",scheduleDtos);
    return "main.html";
  }

}
