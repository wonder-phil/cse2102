package com.example.demo.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Greeting;
import com.example.demo.model.MyString;
import com.example.demo.model.GetQuestion;
import com.example.demo.model.Count;
import com.example.demo.model.MyString;



@Controller 
public class HomeController { 

	@GetMapping("/") 
	public String home() { 
		return "home";  // for home.html 
	} 

	@GetMapping("/greeting")
		public String greetingForm(Model model) {
			Count count = new Count();
			Count.count = Count.count + 1;
			model.addAttribute("greeting", new Greeting());
			model.addAttribute("count", count);
			
			return "greeting";
	}

	@GetMapping("/get_question")
	public String questionForm(Model model) {
		Count count = new Count();
		Count.count = Count.count + 1;
		MyString myString = new MyString();
		GetQuestion getQuestion = new GetQuestion();
		myString.setMyString(getQuestion.nextQuestion());
		model.addAttribute("myString", myString );
		model.addAttribute("count", count);
		
		return "question";
}

	  @PostMapping("/greeting")
 		 public String greetingSubmit(@ModelAttribute Greeting greeting, @ModelAttribute Count count, Model model) {
    		model.addAttribute("greeting", greeting);
			model.addAttribute("count", count);
    	return "result";
  	}
  
}
