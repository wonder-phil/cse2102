// src/main/java/com/example/web/Pages.java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Count;

import jakarta.servlet.http.HttpSession;

//@SessionAttributes("count")

@Controller
public class Pages {
  @GetMapping("/")       public String landing() { return "index"; }
  @GetMapping("/home")   
  public String home(HttpSession session, Model model)    { 
    		Count count = (Count) session.getAttribute("count");
		if (null == count) {
			count = new Count();
		}
		count.inc();
		System.out.println("Count is " + count.getCount());	
		model.addAttribute("count", count); // for the view
    
    return "home"; 
  }

  @GetMapping("/user/p") public String userOnly(){ return "user"; }
  @GetMapping("/admin/p")public String adminOnly(){ return "admin"; }
  @GetMapping("/login")  public String login()   { return "login"; }

    @PostMapping("/home")   
    public String homePost(HttpSession session, Model model)    
    { 
      Count count = (Count) session.getAttribute("count");
      if (null == count) {
        count = new Count();
      }
      count.inc();
      System.out.println("Count is " + count.getCount());	
      model.addAttribute("count", count); // for the view
      return "home"; 
    }

}
