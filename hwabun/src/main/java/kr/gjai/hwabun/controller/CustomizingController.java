package kr.gjai.hwabun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.gjai.hwabun.entity.ConsultingDTO;
import kr.gjai.hwabun.entity.IngredientsDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.SkinMBTIDTO;
import kr.gjai.hwabun.entity.SkinTestQuestionDTO;
import kr.gjai.hwabun.service.CustomizingService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CustomizingController {

	@Autowired
	CustomizingService customizingService;
	
	// 맞춤형 메인 페이지 
	@RequestMapping("/customizing")
	public String customizingMain() {
		
		log.info("customizing main 확인!!");
		
		return "/customizing/customizing";
	}
	
	// 피부 진단 페이지
	@RequestMapping("/skintest")
	public String skinTest(Model model,HttpSession session,HttpServletRequest request) {
		
				
		session = request.getSession();
		MemberDTO mvo = (MemberDTO)session.getAttribute("mvo");	
		
		// 질문지 보내기
		List<SkinTestQuestionDTO> que= customizingService.getQuestion(mvo);
		model.addAttribute("que",que);
		
		// 선택할 알러지 성분 보내기
		String ingredient_type = "알러지";
		List<IngredientsDTO> ingre = customizingService.getTypeIngredients(ingredient_type);
		model.addAttribute("ingre",ingre);
		
		log.info("skin MBTI test 확인!!");
		
		return "/customizing/skintest";
	}
	
	// 피부 진단 결과 로딩 페이지
	@RequestMapping("/loadingResult")
	public String loadingResult(Model model) {
		 
		SkinMBTIDTO[] mbti = customizingService.getAllMbtiResult();
		model.addAttribute("mbti",mbti);

		log.info("skin MBTI loading 확인!!");
		
		return "/customizing/loadingResult";
	}
	
	
	// 피부 진단 결과 페이지
	@RequestMapping("/result")
	public String testResult(Model model) {
		
		SkinMBTIDTO[] mbti = customizingService.getAllMbtiResult();
		model.addAttribute("mbti",mbti[11]);
		
		log.info("skin MBTI result 확인!!");
		
		return "/customizing/result";
	}
	
	// 1:1 맞춤 화장품 상당 예약 페이지
	@GetMapping("/reservation")
	public String skinConsulting() {
		
		log.info("reservation 페이지 확인!!");
		
		return "/customizing/reservation";
	}
	
	// 1:1 맞춤 화장품 상당 예약 페이지
	@PostMapping("/reservation")
	public String skinConsulting(ConsultingDTO vo,HttpSession session,HttpServletRequest request) {
		
		session = request.getSession();
		MemberDTO mvo = (MemberDTO)session.getAttribute("mvo");	
		customizingService.reservation(vo, mvo);
		
		log.info("reservation 완료 확인!!");
		
		return "redirect:/completedReservation";
	}
	
	// 1:1 맞춤 화장품 상담 예약 완료 페이지
	@RequestMapping("/completedReservation")
	public String completedReservation() {
		
		log.info("reservation 완료 페이지 확인!!");
		
		return"/customizing/completedReservation";
	}
	
	// 화장품 라인 추천 서비스
	@RequestMapping("/recommendation")
	public String recommendation() {
		
		log.info("recommendation 페이지 확인!!");
		
		return "/customizing/recommendation";
	}
	
}
