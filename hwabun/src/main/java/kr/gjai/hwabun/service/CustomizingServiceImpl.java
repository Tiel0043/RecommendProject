package kr.gjai.hwabun.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.ConsultingDTO;
import kr.gjai.hwabun.entity.IngredientsDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.SkinMBTIDTO;
import kr.gjai.hwabun.entity.SkinTestQuestionDTO;
import kr.gjai.hwabun.mapper.CustomizingMapper;


@Service
public class CustomizingServiceImpl implements CustomizingService{
	
	@Autowired
	CustomizingMapper customizingMapper;
	
	// 1:1 컨설팅 예약 관련 메소드
	@Override
	public void reservation(ConsultingDTO vo, MemberDTO mvo) {
		vo.setMb_id(mvo.getMb_id());
		customizingMapper.reservation(vo);
		
	}
	
	// 피부진단 질문지 가져오는 메소드
	@Override
	public List<SkinTestQuestionDTO> getQuestion(MemberDTO mvo) {
		
		// 이전 테스트 횟수 체크용
		int testCnt = customizingMapper.testCount(mvo);
		
		List<SkinTestQuestionDTO> que = new ArrayList<SkinTestQuestionDTO>();
		HashMap<String, Object > queBundle = new HashMap<String, Object>();
		
		if(testCnt==0) {		
			if(mvo.getMb_gender()=='F') {
				queBundle.put("start", 101);
				queBundle.put("end", 199); // 101~ first 여성

			}else{
				queBundle.put("start", 201);
				queBundle.put("end", 299); // 201~ first 남성
				
			}		
		}else {
			if(mvo.getMb_gender()=='F') {
				
				queBundle.put("start", 301);
				queBundle.put("end", 399); // 301~ 두번 이상 여성
				
			}else{
				
				queBundle.put("start", 401);
				queBundle.put("end", 499); // 401~ 두번 이상 남성
					
			}
		}
		
		que= customizingMapper.getQuestion(queBundle); 
		
		return que;
	}

	// 특정 성분 유형 모두 가져오기
	@Override
	public List<IngredientsDTO> getTypeIngredients(String ingredient_type) {
		List<IngredientsDTO> ingre = customizingMapper.getTypeIngredients(ingredient_type);
		return ingre;
	}

	@Override
	public SkinMBTIDTO[] getAllMbtiResult() {
		SkinMBTIDTO[] mbti = new SkinMBTIDTO[16]; 
		mbti[0] = new SkinMBTIDTO("DRPT","건조 민감▼ 색조▲ 주름▼","여드름&모공 하나 보이지 않는 타고난 달걀피부", "고운 피부 결, 염증 반응이 거의 나타나지 않음","건조함, 자외선에 취약한 편","SPF30+이상의 자외선 차단제, 브라이트닝 성분이 함유된 모이스처라이저 사용","#7E87C2","#7e87c213");
		mbti[1] = new SkinMBTIDTO("DRPW", "건조 민감▼ 색소▲ 주름▲","빛나는 리즈 시절만 믿고 방치하다 나이들어 훅 간 피부","자극에 강한 피부 타입","건조하고 당기는 피부. 디스크팟, 이마와 눈가의 주름","SPF 30+ 이상의 자외선 차단제, 레티놀 등 브라이트닝 필링, 항산화제, 모이스처라이저","#0376C2","#0376c215");
		mbti[2] = new SkinMBTIDTO("DRNT", "건조 민감▼ 색소▼ 주름▼","모든 피부 고민으로 부터 자유로운 일명 건강 피부 (한국인에게 흔한 타입)","깨끗한 피부 결과 톤, 피부 문제가 거의 없음","약간의 건조함","데일리 모이스처라이저,주기적인 각질 관리","#B1B6DA","#b1b6da15");
		mbti[3] = new SkinMBTIDTO("DRNW", "건조 민감▼ 색소▼ 주름▲","해가 지나갈수록 노화 속도가 빠르게 나타나는 피부","균일한 피부톤","건조함, 미세한 잔주름","SPF 15+ 이상의 자외선 차단제 항산화제","#95B5DB","#95b4db13");
		mbti[4] = new SkinMBTIDTO("DSPT", "건조 민감▲ 색소▲ 주름▼","피부가 좋았던 적이 없눈 모태 개복치 피부","끝까지 탄력을 잃지 않는 편, 개선의 여지가 존재","건조함과 반복되는 염증으로 고르지 못한 피부 톤, 국소적인 소양감","보습이 1순위, 알러지 유발 성분 제외, 반드시 민감성 제품만 사용, 패치 테스트 필수","#8ECFCB","#8ecfcb11");
		mbti[5] = new SkinMBTIDTO("DSPW", "건조 민감▲ 색소▲ 주름▲","영원히 고통받는 총체적 난국 건성 민감 피부","","피부가 매우 민감하고 얇아 자극에 쉽게 반응, 주름이 생기기 쉬움, 모든 종류의 문제를 보일 수 있는 피부","반드시 민감성 제품만 사용, 패치 테스트 필수. 전문가에 의한 엄격한 피부관리 필요","#c1d692","#c0d69213");
		mbti[6] = new SkinMBTIDTO("DSNT", "건조 민감▲ 색소▼ 주름▼","작은 자극에도 쉽게 붉어지는 선인장 피부(한국인에게 흔한 타입)","다크스팟과 주름, 모공이 적은 편", "극심한 건조함과 화끈거림, 각질과 붉은 기가 동시에 나타남","저자극 클렌징 오메가-3 섭취","#A6CF5C","#a7cf5c18");
		mbti[7] = new SkinMBTIDTO("DSNW", "건조 민감▲ 색소▼ 주름▲","날마다 컨디션이 급변하는 속건조 피부","균일한 피부톤","주름이 쉽게 생기는 편","피부 장벽 강화 보습제, 항산화 및 항염증 성분","#03A29B","#03a29a1a");
		mbti[8] = new SkinMBTIDTO("ORPT", "지성 민감▼ 색소▲ 주름▼","단점보다 장점이 많고 관리하기 쉬운 메추리알 피부","주름과 자극에 강한 편", "번들거림, 어둡고 칙칙한 피부톤", "SPF 30+ 이상의 자외선 차단제, 브라이트닝 필링","#E87306","#e873061a");
		mbti[9] = new SkinMBTIDTO("ORPW", "지성 민감▼ 색소▲ 주름▲","모공이 넓지만 여드름은 쉽게 나지 않는 감귤 피부","자극에 강한 피부","번들거림, 균일하지 못한 피부 톤, 모공이 넓은 편","SPF30+ 이상의 자외선 차단제, 항산화제","#F9BE03","#f9c00317");
		mbti[10] = new SkinMBTIDTO("ORNT", "지성 민감▼ 색소▼ 주름▼","흠잡을 것 하나 없는 건강한 광채 탱탱볼 피부(한국인에게 흔한 타입)","부드럽고 유연한 피부","모공이 큰 편, 블렉헤드가 생기기 쉬움", "피지 흡착 성분. 논 코메도제닉(Non Comedogenic 모공막힘 가능성 낮은 ) 보습제","#FBD25C","#fbd35c18");
		mbti[11] = new SkinMBTIDTO("ORNW", "지성 민감▼ 색소▼ 주름▲","여드름은 쉽게 올라오지 않지만 때이른 잔주름이 나타나기 쉬운 지성 피부","매끈한 피부", "건조 타입 보다는 적지만 잔주름이 쉽게 나타나는 편","항산화 필링","#F2AF69","#f2b06915");
		mbti[12] = new SkinMBTIDTO("OSPT", "지성 민감▲ 색소▲ 주름▼","여드름과 색소침착이 있지만 주름은 쉽게 지지 않는 피부","끝까지 탄력을 잃지 않는 편, 개선의 여지가 존재", "피지, 염증, 색소침착의 악순환 반복","반드시 민감성 제품만 사용할 것, 필링은 가급적 자제. 피부 장벽 강화 성분. 오일 베이스 및 워터프루프 제품 사용 자제","#EC9DB8","#ec9db91a");
		mbti[13] = new SkinMBTIDTO("OSPW", "지성 민감▲ 색소▲ 주름▲","영원히 고통받는 총체적 난국 지성 민감 피부","", "여드름 부터 색소, 주름이 생기기 쉬움. 모든 종류의 문제를 보일수 있는 피부","반드시 민감성 제품만 사용할 것. 패치테스트 필수. 전문가에 의한 엄격한 피부 관리 필요","#F29A97","#f29a9718");
		mbti[14] = new SkinMBTIDTO("OSNT", "지성 민감▲ 색소▼ 주름▼","성인 여드름이 올라올 수 있지만 50대 이후 진정한 승리자 피부(한국인에게 흔한 타입)", "여드름 자국으로 이어지지 않는 편. 나이가 들수록 관리하기 쉬움", "번들거림. 염증 반응으로 인한 붉은 기", "저자극 데일리 모이스처라이저","#E80342","#e8034417");
		mbti[15] = new SkinMBTIDTO("OSNW", "지성 민감▲ 색소▼ 주름▲","햇빛에 쉽게 붉어지고 번들거리며 종종 여드름이 보이는 피부","피부가 햇빛에 붉어질 뿐 검게 변하지 않음","번들거림, 주름이 생기기 쉬움", "저자극 데일리 모이스처라이저. 항산화제","#DD0371","#dd037017");

		return mbti;
	}

	
	
}
