package kr.gjai.hwabun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.ReviewDTO;
import kr.gjai.hwabun.service.MyPageService;

@Controller
public class MyPageController {
	
	@Autowired
	MyPageService myPageService;
	
	@GetMapping("/myaccount-info")
	public String AccountInfo(HttpSession session,Model model) {
		

		MemberDTO mb=(MemberDTO)session.getAttribute("mvo");		
	
		List<MemberDTO> ulist=myPageService.getInfo(mb.getMb_id());
		model.addAttribute("info",ulist.get(0));
		
		return "mypage/page-member";
	}
	
	@ResponseBody
	@RequestMapping("/changePwd")
	public void changePwd(@RequestParam(value="pwd") String pwd, HttpSession session) {
		
		MemberDTO mb=(MemberDTO)session.getAttribute("mvo");
		myPageService.changePwd(mb.getMb_id(),pwd);
		
	}

	
	
	@GetMapping("/myaccount-order")
	public String AccountOrder() {
		return "mypage/page-orders-detail";
	}
	@GetMapping("/myaccount-tracking")
	public String AccountTracking() {
		return "mypage/page-orders-tracking";
	}
	@GetMapping("/myaccount-reviews")
	public String AccountReviews(HttpSession session,Model model){
		
		MemberDTO mb=(MemberDTO)session.getAttribute("mvo");
		List<ReviewDTO> rlist=myPageService.showReview(mb.getMb_id());
		model.addAttribute("rlist",rlist);
		return "mypage/page-reviews";
	}
	
	
	
	
}
