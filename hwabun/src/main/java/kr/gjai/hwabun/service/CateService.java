package kr.gjai.hwabun.service;

import java.util.List;

import kr.gjai.hwabun.entity.CosmeticsDTO;

public interface CateService {
	public List<CosmeticsDTO> getProductList(String cate);
}
