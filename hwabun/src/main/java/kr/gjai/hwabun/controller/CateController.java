package kr.gjai.hwabun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.gjai.hwabun.entity.CosmeticsDTO;
import kr.gjai.hwabun.service.CateService;

@Controller
public class CateController { // 대분류 상품 조회 컨트롤러
	
	@Autowired
	CateService cateService;
	
	@GetMapping("/getProductList")
	public String getProductList(@RequestParam(value="cate") String cate,Model model) { // 대분류 입력받는다
		List<CosmeticsDTO> list = cateService.getProductList(cate);
		model.addAttribute("cos_list", list);
		System.out.println(list);
		return "product/product-list";
	}
	
}
