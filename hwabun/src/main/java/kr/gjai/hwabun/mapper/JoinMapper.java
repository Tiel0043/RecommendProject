package kr.gjai.hwabun.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.gjai.hwabun.entity.MemberDTO;

@Mapper
public interface JoinMapper {

	public void register(MemberDTO mdo);

	public MemberDTO getMemInfo(MemberDTO mdo);

	public MemberDTO idCheck(String mb_id);

}
