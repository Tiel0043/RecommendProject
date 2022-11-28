package kr.gjai.hwabun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.mapper.JoinMapper;

@Service
public class JoinServiceImpl implements JoinService{

	@Autowired
	JoinMapper joinMapper;
	
	
	  @Override 
	  public void register(MemberDTO mdo) {
	  
	  joinMapper.register(mdo); 
	  
	  }


	@Override
	public MemberDTO getMemInfo(MemberDTO mdo) {
		
		MemberDTO mvo = joinMapper.getMemInfo(mdo);
	  	return mvo; 
	  	
	}


	@Override
	public String idCheck(String mb_id) {
		MemberDTO mvo = joinMapper.idCheck(mb_id);
		
		if(mvo!=null) {
			return"retry";
		}else {
			return "null";
		}
		
	}
	  
	  
	 
	
}
