package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

  @GetMapping("/")
  public String index() {
    return "index"; // renders templates/index.html
  }

  @PostMapping("/hello")
  public String hello(@RequestParam(defaultValue = "My Good Friend") String name, Model model) {
    model.addAttribute("name", name);
    return "greet"; // renders templates/greet.html
  }
}
