package kr.gjai.hwabun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.gjai.hwabun.entity.CosmeticsDTO;

@Mapper
public interface CateMapper {
	public List<CosmeticsDTO> getProductList(String cate);
}
