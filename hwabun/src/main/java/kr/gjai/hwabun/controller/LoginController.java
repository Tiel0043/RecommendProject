package kr.gjai.hwabun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String goLogin() {
		return "/login/login";
	}
	
	@RequestMapping("/login.do")
	public String loginCheck(MemberDTO mdo, HttpSession session) {
		System.out.println(mdo.getMb_id());
		System.out.println(mdo.getMb_pw());
		MemberDTO mvo = loginService.loginCheck(mdo);
		if(mvo != null) {
			session.setAttribute("mvo", mvo);
			System.out.println(session.getAttribute("mvo"));
			System.out.println("로그인 완료");
		}
		return "redirect:/getProductList?cate=남성";
	}
	
	@RequestMapping("/logout.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/getProductList?cate=남성";
	}
}
