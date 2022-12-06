package kr.gjai.hwabun.service;

import java.util.List;

import kr.gjai.hwabun.entity.ConsultingDTO;
import kr.gjai.hwabun.entity.IngredientsDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.SkinMBTIDTO;
import kr.gjai.hwabun.entity.SkinTestQuestionDTO;

public interface CustomizingService {

	public List<SkinTestQuestionDTO> getQuestion(MemberDTO mvo);

	public void reservation(ConsultingDTO vo, MemberDTO mvo);

	public List<IngredientsDTO> getTypeIngredients(String ingredient_type);

	public SkinMBTIDTO[] getAllMbtiResult();

}
