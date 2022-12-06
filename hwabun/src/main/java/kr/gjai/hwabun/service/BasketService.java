package kr.gjai.hwabun.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.gjai.hwabun.entity.BasketDTO;
import kr.gjai.hwabun.entity.CosmeticDTO;
import kr.gjai.hwabun.entity.EventDTO;
import kr.gjai.hwabun.entity.MemberDTO;
import kr.gjai.hwabun.entity.TempBasketDTO;
import kr.gjai.hwabun.mapper.BasketMapper;

@Service
public class BasketService {

	
	@Autowired
	BasketMapper basketMapper;

	
	
	public CosmeticDTO getCosmetics(int cos_seq) {
		
		
		return basketMapper.getCosmetics(cos_seq);
		
		
	}
	
	
	
	
	
	public List<CosmeticDTO> showCosmetics(){
		
		
		return basketMapper.showCosmetics();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<TempBasketDTO> showBasket(String nickname){
		
		
		return basketMapper.showBasket(nickname);
		
	}
	

	

	
	
	
	

	public void saveBasket(int cos_seq, String nickname, int cnt) {
		// TODO Auto-generated method stub
	
		
		int knn=-1;
		List<BasketDTO> tlist=basketMapper.showBasket1(nickname);
		int bn=basketMapper.countBasket(nickname);
		
		
		
		for(int i=0;i<bn;i++) {
		
			if( cos_seq==tlist.get(i).getCos_seq() ) {
				
				
				knn=tlist.get(i).getCos_seq();
				cos_seq=knn;
				break;
				
			}
			
		

		}
		
		
		if(knn==-1) {
			
			
			basketMapper.insertBasket(cos_seq,nickname,cnt);
			
			
		}else {
			
		
			basketMapper.updateBasket(cos_seq,nickname,cnt);
			
		}
		
		
		
		
	}





	public void plusCnt(int cos_seq, String nickname) {
		basketMapper.plusCnt(cos_seq,nickname);
		
	}





	public void minusCnt(int cos_seq, String nickname) {
		basketMapper.minusCnt(cos_seq,nickname);
		
	}





	public void throwSeq(int cos_seq, String nickname) {
		basketMapper.throwSeq(cos_seq,nickname);
		
	}





	public void clearCart(String nickname) {
		basketMapper.clearCart(nickname);
		
	}





	public void changeCnt(int cos_seq, String nickname, int cnt) {
		basketMapper.changeCnt(cos_seq, nickname,cnt);
		
	}




	public int countBasket(String nickname) {
		
		return basketMapper.countBasket(nickname);
		
	}





	public void registerEvent(EventDTO edo) {
		basketMapper.registerEvent(edo);	
	}





	public void dropEvent(EventDTO edo) {
		basketMapper.dropEvent(edo);
		
	}





	public void payEvent(List<TempBasketDTO> tlist, String mb_id, String user_session) {
		for(int i = 0; i < tlist.size(); i++) {
			 EventDTO edo = new EventDTO();
			 edo.setCos_seq(tlist.get(i).getCos_seq());
			 edo.setUser_id(mb_id);
			 edo.setUser_session(user_session);
			 basketMapper.payEvent(edo);
		 }
		
	}

	
	
	
	
	
}
