package test240731.object1;

import java.util.ArrayList;
import java.util.HashMap;

// Controller : 
public class FarmController {
	HashMap<Farm, Integer> hMap = new HashMap<>();
	ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount) {
		// 전달 받은 f가 hMap 안에 key로 존재하지 않을 때
		// f와 amount를 각각 키와 값으로 저장 후 true 반환, 존재할 경우 false 반환.
		if (hMap.containsKey(f)) { // f라는 키로 데이터가 존재한다면 -> 추가불가
			return false;
		} else {
			hMap.put(f, amount);
			return true;
		}
	}
	
	public boolean removeKind(Farm f) {
		return false;
	}
	
	public boolean changeAmount(Farm f, int amount) {
		return false;
	}
	
	public HashMap<Farm, Integer> printFarm() {
		return hMap;
	}
	
	public boolean buyFarm(Farm f) {
		return false;
	}
	
	public boolean removeFarm(Farm f) {
		return false;
	}
	
	public ArrayList<Farm> printBuyFarm() {
		return list;
	}
}
