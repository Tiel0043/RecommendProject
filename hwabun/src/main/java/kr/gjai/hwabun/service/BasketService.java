package kr.gjai.hwabun.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.gjai.hwabun.entity.BasketDTO;
import kr.gjai.hwabun.entity.CosmeticsDTO;
import kr.gjai.hwabun.entity.EventDTO;
import kr.gjai.hwabun.entity.TempBasketDTO;
import kr.gjai.hwabun.mapper.BasketMapper;
@Service
public class BasketService {
	
	@Autowired
	BasketMapper basketMapper;
	
	
	public CosmeticsDTO getCosmetics(int cos_seq) {
		
		
		return basketMapper.getCosmetics(cos_seq);
		
		
	}
	
	
	
	
	
	public List<CosmeticsDTO> showCosmetics(){
		
		
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
	
	public List<TempBasketDTO> willPurchase(String mb_id, String pchase) {
		
		List<TempBasketDTO> blist=new ArrayList<TempBasketDTO>();
		
		
		try {
		String[] pchase_seq=pchase.split(",");
		
		for(int i=0;i<pchase_seq.length;i++) {
			
			
			blist.add(basketMapper.willPurchase(mb_id,Integer.parseInt(pchase_seq[i])).get(0));
			basketMapper.throwSeq(Integer.parseInt(pchase_seq[i]),mb_id);
			
			
			}
		
		}
		catch(Exception e){
			
			blist.add(basketMapper.willPurchase(mb_id,Integer.parseInt(pchase)).get(0));
			basketMapper.throwSeq(Integer.parseInt(pchase), mb_id);
			
			
		}
		
		return blist;
		
		
		
		
	}
	
	
	
	
	
	
	
}