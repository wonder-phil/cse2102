// src/main/java/com/example/web/Pages.java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pages {
  @GetMapping("/")       public String landing() { return "index"; }
  @GetMapping("/home")   public String home()    { return "home"; }
  @GetMapping("/user/p") public String userOnly(){ return "user"; }
  @GetMapping("/admin/p")public String adminOnly(){ return "admin"; }
  @GetMapping("/login")  public String login()   { return "login"; }
}
