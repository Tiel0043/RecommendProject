package kr.gjai.hwabun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkinMBTIDTO {
// 테이블 생성하지 않고 페이지에 뿌릴 정보 DTO
	
	
	private String skinMBTI; 
	private String skinSimple; 
	private String skinResult;
	private String skinStrength;
	private String skinWeakness;
	private String skinSolution;
	private String mbtiColor1;
	private String mbtiColor2;
	
	
}
