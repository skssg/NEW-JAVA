package test240729.object1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet lottery = new HashSet(); // 추첨 대상을 담을 HashSet 객체 생성(lottery)
	private HashSet win = new HashSet(); // 당첨 대상을 담을 HashSet 객체 생성(win)
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
		// 전달 받은 l을 lottery에 추가 후, 추가 결과인 boolean 값 반환
	}
	
	public boolean deleteObject(Lottery l) {
		boolean isRemove = lottery.remove(l);
		if (isRemove && win != null) {
			win.remove(l);
		}
		// 전달 받은 l을 lottery에서 삭제
		return isRemove;
		// 당첨자 목록(win) 중에 삭제된 추첨 대상자가 존재할 수 있으니
		// 삭제 결과인 boolean 값과 win객체가 null이 아닐 때에만
		// win에도 해당 추첨 대상자 삭제

	}
	
	public HashSet winObject() {
		// 이 때, 당첨자 수는 무조건 4명이며 이를 위해 추첨자 수는 4명 이상이어야 함
		if(lottery.size() < 4) {
			return null;
		}
		// 추첨 대상자 중에서 랜덤으로 뽑아 당첨 목록에 넣는 메소드
		// 랜덤으로 뽑기 위해 lottery를 ArrayList에 담고,
		List<Lottery> list = new ArrayList<>();
		list.addAll(lottery);
		// 인덱스를 이용해 win에 당첨자 저장
		// 당첨자 4명을 뽑기위한 반복 4번
		while(win.size() < 4) { // 사이즈확인해서 4명이하면 계속진행
			int rand = (int)(Math.random() * list.size()); // 랜덤발생
			win.add(list.get(rand)); // 랜덤자리에 있는 사람을 당첨목록에 추가
		}
		
		return win;
		// 만일 당첨자 목록에 삭제된 추첨 대상자가 있다면
		// 기존에 당첨된 사람은 제외하고 삭제된 사람의 자리만 새로운 추첨자로 채움
	}
	
	public TreeSet sortedWinObject() {
		TreeSet sortedWinSet = new TreeSet(new SortedLottery());
		sortedWinSet.addAll(win);		
		return sortedWinSet;
		// 이름으로 오름차순 정렬하되, 이름이 같으면 번호로 오름차순 하는
		// 정렬기준을 가지고 정렬된 결과를 반환
		// 이 때, 미리 만들어진 win을 가지고 정렬하기 때문에
		// 당첨 대상 확인을 꼭 먼저 해야함
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
		// 전달 받은 l을 win에서 찾고 찾은 결과인 boolean 값 반환
	}
}
