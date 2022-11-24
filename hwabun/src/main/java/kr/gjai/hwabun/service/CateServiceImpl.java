package kr.gjai.hwabun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.CosmeticsDTO;
import kr.gjai.hwabun.mapper.CateMapper;

@Service
public class CateServiceImpl implements CateService{

	@Autowired
	CateMapper cateMapper;
	
	@Override
	public List<CosmeticsDTO> getProductList(String cate) {
		List list = cateMapper.getProductList(cate);
		return list;
	}

}
