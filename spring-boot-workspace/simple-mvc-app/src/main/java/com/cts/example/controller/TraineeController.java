package com.cts.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cts.example.pojo.Trainee;

@Controller

public class TraineeController {
	
	RestTemplate rt=new RestTemplate();

	@GetMapping("/get-trainee")
	public String getTrainee(@RequestParam("tid") int id, Model m) {
		Trainee trainee=rt.getForObject("http://localhost:8500/trainees/"+id, Trainee.class);
		m.addAttribute("trainee", trainee);
		
	
		
		return "show.jsp";
		
		
	}
	@PostMapping("/add-trainee")
	public String addTrainee(Model m) {
		Trainee trainee=new Trainee(1005, "Javed");
		rt.postForObject("http://localhost:8500/trainees",trainee, Trainee.class);
		m.addAttribute("trainee", trainee);
		
	
		
		return "show.jsp";
		
	}
	
	
	
}
