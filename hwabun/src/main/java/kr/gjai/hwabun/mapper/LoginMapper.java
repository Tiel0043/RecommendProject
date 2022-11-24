package kr.gjai.hwabun.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.gjai.hwabun.entity.MemberDTO;

@Mapper
public interface LoginMapper {
	public MemberDTO loginCheck(MemberDTO mdo);
}
