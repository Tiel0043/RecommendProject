package kr.gjai.hwabun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.gjai.hwabun.entity.CosmeticsDTO;
import kr.gjai.hwabun.service.RankService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class RankController {
	
	@Autowired
	RankService rankService;
	
	@GetMapping("/rank")
	public String getAllProduct(Model model) {
		List<CosmeticsDTO> list = rankService.getAllProduct();
		model.addAttribute("list", list);
		return "rank/rank";
	}
}
