package kr.gjai.hwabun.service;

import java.util.List;

import kr.gjai.hwabun.entity.CosmeticsDTO;
import kr.gjai.hwabun.entity.UserSkinDTO;

public interface RankService {

	public List<CosmeticsDTO> getAllProduct();

	public List<CosmeticsDTO> getRankSales();

	public List<CosmeticsDTO> getRankLikes();

	public List<CosmeticsDTO> getCateRankSales(String cate);

	public List<CosmeticsDTO> getCateRankLikes(String cate);

	public List<CosmeticsDTO> getRankReviews();

	

}
