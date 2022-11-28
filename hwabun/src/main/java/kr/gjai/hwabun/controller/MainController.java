package kr.gjai.hwabun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MainController {
	
	@RequestMapping({"/","/main"})
	public void main(Model model) {
		log.info("main 확인!!");
		model.addAttribute("main","main");
		
	}
}
