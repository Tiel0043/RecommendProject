package kr.gjai.hwabun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.service.JoinService;
import lombok.extern.log4j.Log4j2;

@Controller

@Log4j2
public class JoinController {
	
	@Autowired
	JoinService joinService;

	// 회원가입 폼 페이지로 
	@GetMapping("/join")
	public String join() {
		log.info("join..........!!!!!");
		
		return "join/join";
	}
	@RequestMapping("/idCheck")
	public @ResponseBody String idCheck(String mb_id) {
		log.info(mb_id);
		String idCheckResult = joinService.idCheck(mb_id);
		log.info(idCheckResult);
		return idCheckResult;
	}
	
	// 회원가입 폼 작성 후 
	@PostMapping("/join")
	public String join(MemberDTO mdo, HttpSession session) {

		log.info(mdo);
		joinService.register(mdo);	
		log.info("회원가입성공!!");
		MemberDTO mvo = joinService.getMemInfo(mdo);
		session.setAttribute("mvo", mvo);
		
		return "redirect:/main";
	}
	
}
