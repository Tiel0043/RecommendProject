package kr.gjai.hwabun.service;

import java.util.HashMap;
import java.util.List;

import kr.gjai.hwabun.entity.AnswerDTO;
import kr.gjai.hwabun.entity.ConsultingDTO;
import kr.gjai.hwabun.entity.IngredientsDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.SkinMBTIDTO;


public interface CustomizingService {

	public HashMap<String, Object> getQuestion(MemberDTO mvo);

	public void reservation(ConsultingDTO vo, MemberDTO mvo);

	public List<IngredientsDTO> getTypeIngredients(String ingredient_type);

	public SkinMBTIDTO[] getAllMbtiResult();

	public void mbtiAnalysis(AnswerDTO answer, String[] ingredient, MemberDTO mvo);

}
