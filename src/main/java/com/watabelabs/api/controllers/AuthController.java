package com.watabelabs.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** AuthController */
@RestController
@RequestMapping("/api/v1")
public class AuthController {

  @GetMapping("/hello-world")
  public String hello() {
    return "Hello World";
  }
}
