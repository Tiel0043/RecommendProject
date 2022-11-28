package kr.gjai.hwabun.service;

import kr.gjai.hwabun.entity.MemberDTO;

public interface JoinService {

	public void register(MemberDTO mdo);

	public MemberDTO getMemInfo(MemberDTO mdo);

	public String idCheck(String mb_id);
	
}
