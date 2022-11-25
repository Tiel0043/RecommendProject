package kr.gjai.hwabun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller

@Log4j2
public class JoinController {
	
	
	@GetMapping("/join")
	public String join() {
		log.info("join..........!!!!!");
		
		return "join/join";
	}
	
	
	
}