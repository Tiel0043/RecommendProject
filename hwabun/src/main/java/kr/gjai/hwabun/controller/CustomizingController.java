package kr.gjai.hwabun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CustomizingController {

	@RequestMapping("/customizing")
	public String customizingMain() {
		log.info("customizing main 확인!!");
		return "/customizing/customizing";
	}
	
	@RequestMapping("/skintest")
	public String aiSkinTest() {
		log.info("skin MBTI 확인!!");
		return "/customizing/skintest";
	}
	
}
