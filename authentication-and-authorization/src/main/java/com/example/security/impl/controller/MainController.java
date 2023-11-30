package com.example.security.impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class MainController {

  @GetMapping("/info")
  public String getInfo() {
    return "info";
  }

  @GetMapping("/about")
  public String getAbout() {
    return "about";
  }

  @GetMapping("/admin")
  public String getAdmin() {
    return "admin";
  }

}
