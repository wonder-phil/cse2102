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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.questions.*;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;


@SessionAttributes("count")

@Controller 
public class HomeController { 

	@GetMapping("/") 
	public String home() { 
		return "home";  // for home.html 
	} 

	@GetMapping({"/get_question", "/get-question"})
	public String questionForm(HttpSession session, Model model) {

		Count count = (Count) session.getAttribute("count");
		if (null == count) {
			count = new Count();
		}
		count.inc();
		System.out.println("Count is " + count.getCount());	
		model.addAttribute("count", count); // for the view
		
		MyString myStringObject = (MyString) session.getAttribute("myString")
;		if (myStringObject == null) {
			myStringObject = new MyString();
		}
		GetQuestion getQuestion = new GetQuestion();
		myStringObject.setMyString(getQuestion.nextQuestion(count.getCount()).getQuestion());
		model.addAttribute("myString", myStringObject ); // for the view

		return "question";
	}

	@PostMapping({"/get_question", "/get-question"})
	public String questionFormPOST(	HttpSession session,
									@RequestParam String answer, 
									Model model) {
		System.out.println("The answer is " + answer);
		
		Count count = (Count) session.getAttribute("count");
		if (count == null) {
			count = new Count();
		}

		GetQuestion getQuestion = new GetQuestion();
		QuestionTrueFalse qtf = getQuestion.nextQuestion(count.getCount());
		model.addAttribute("QuestionTrueFalse", qtf);

		MyString myStringObject = (MyString) session.getAttribute("myString");
		if (myStringObject == null) {
			myStringObject = new MyString();
		}
		
		System.out.println("Count is " + count.getCount());	

		count.inc();
		model.addAttribute("count", count);
		
		myStringObject.setMyString(getQuestion.nextQuestion(count.getCount()).getQuestion());
		model.addAttribute("myString", myStringObject );

		// Compare Boolean values correctly (avoid reference equality)
		Boolean answerBool = Boolean.valueOf(answer);
		if (answerBool.equals(qtf.getAnswer())) {
			System.out.println("Correct!");
		} else {
			System.out.println("Wrong!");
		}		
		
		return "question";
	}

	@PostMapping("/reset")
  	public String reset(HttpServletRequest req) {
    	req.getSession().invalidate(); // next request gets a new session
    	return "redirect:/question";
  	}

}
