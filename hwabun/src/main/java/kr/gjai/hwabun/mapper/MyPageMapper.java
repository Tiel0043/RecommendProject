package kr.gjai.hwabun.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.ReviewDTO;

@Mapper
public interface MyPageMapper {

	

	@Select("select * from members where mb_id=#{mb_id}")
	public List<MemberDTO> getInfo(String mb_id);

	
	@Update("update members set mb_pw=#{param2} where mb_id=#{param1}")
	public void changePwd(String param1, String param2);

	@Select("select r.*, c.cos_name, m.mb_name from reviews r,cosmetics c, members m where r.cos_seq=c.cos_seq and m.mb_id=r.mb_id and r.mb_id=#{mb_id}")
	public List<ReviewDTO> showReview(String mb_id);

	
	
	
	
	
	
}
