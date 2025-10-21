package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.RequestBody;  


@RestController 
public class HomeController {

  @PostMapping(path="/say-hi-back", consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public String say_hi_back(@RequestParam(value = "data", // @RequestBody  @RequestParam
    defaultValue = "Enjoy␣your␣day!\n") String data) {
  return "Echo: " + data;
  }

  @PostMapping(path="/email_address_valid", consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public String isEmailValid(@RequestParam(value = "email") String email) {
    String data = "";
    if (email.contains("@") && email.contains(".")) {
      data = "Valid email address.";
    } else {
      data = "Invalid email address.";
    }   
    return "Email check: " + email + " is " + data + "\n";
  }
}