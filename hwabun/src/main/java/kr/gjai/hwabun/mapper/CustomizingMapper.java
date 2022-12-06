package kr.gjai.hwabun.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.gjai.hwabun.entity.ConsultingDTO;
import kr.gjai.hwabun.entity.IngredientsDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.SkinTestQuestionDTO;

@Mapper
public interface CustomizingMapper {

	public void reservation(ConsultingDTO vo);
	
	public List<SkinTestQuestionDTO> getQuestion(HashMap<String, Object> queBundle);
	
	public int testCount(MemberDTO mvo);

	public List<IngredientsDTO> getTypeIngredients(String ingredient_type); 
}
