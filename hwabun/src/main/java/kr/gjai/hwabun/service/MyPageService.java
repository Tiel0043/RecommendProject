package kr.gjai.hwabun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.ReviewDTO;
import kr.gjai.hwabun.mapper.MyPageMapper;

@Service
public class MyPageService {

	@Autowired
	MyPageMapper myPageMapper;

	public List<MemberDTO> getInfo(String mb_id){
		
		
		return myPageMapper.getInfo(mb_id);
		
		
		
	}
	
	
	public void changePwd(String mb_id, String pwd) {
		
		myPageMapper.changePwd(mb_id,pwd);
		
		
	}


	public List<ReviewDTO> showReview(String mb_id) {
		
		return myPageMapper.showReview(mb_id);
		
	}
	
	
	
}
