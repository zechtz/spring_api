package com.watabelabs.api.controllers;

import com.watabelabs.api.config.Constants;
import com.watabelabs.api.dto.RegistrationRequest;
import com.watabelabs.api.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** AuthController */
@RestController
@AllArgsConstructor
@RequestMapping(Constants.API_V1_AUTH)
public class AuthController {
  private final AuthService authService;

  @PostMapping("/sign-up")
  public ResponseEntity<String> signUp(@RequestBody RegistrationRequest registrationRequest) {
    authService.signUp(registrationRequest);
    return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
  }
}
