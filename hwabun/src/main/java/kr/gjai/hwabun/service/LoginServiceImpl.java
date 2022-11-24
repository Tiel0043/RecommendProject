package kr.gjai.hwabun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public MemberDTO loginCheck(MemberDTO mdo) {
		MemberDTO mvo = loginMapper.loginCheck(mdo);
		return mvo;
	}
	
}
