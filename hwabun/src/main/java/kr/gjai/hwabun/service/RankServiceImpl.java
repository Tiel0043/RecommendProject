package kr.gjai.hwabun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.CosmeticsDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.mapper.RankMapper;

@Service
public class RankServiceImpl implements RankService{
	
	@Autowired
	RankMapper rankMapper;
	
	@Override
	public List<CosmeticsDTO> getAllProduct() {
		List<CosmeticsDTO> list= rankMapper.getAllProduct();
		return list;
	}

}
