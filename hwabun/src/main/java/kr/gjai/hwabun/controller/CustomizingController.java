package kr.gjai.hwabun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomizingController {

	@RequestMapping("/customizing")
	public String customizingMain() {
		
		return "/customizing/customizing";
	}
}
