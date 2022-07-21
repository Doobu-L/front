package com.example.front.controller;

import com.example.front.domain.UserDto;
import com.example.front.service.MainService;
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
    modelMap.addAttribute("user",user);
    return "main.html";
  }

}
