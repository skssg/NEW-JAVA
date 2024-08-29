package com.kh.view;

import java.util.Random;
import java.util.Scanner;

import com.kh.controller.StartController;
import com.kh.vo.Baseball;
import com.kh.vo.Game;

public class PlayMenu {
	private Game loginUser;
	private Scanner sc;
	private StartController tc;
	
	public PlayMenu(Game loginUser,StartController tc,Scanner sc) {
		super();
		this.loginUser = loginUser;
		this.tc = tc;
		this.sc = sc;
	}
	
	public void menu() {
		
		while(true) {
			System.out.println("==========게임시작 메뉴==========");
			System.out.println("1.선수등록");
			System.out.println("2.선수수정");
			System.out.println("3.선수목록");
			System.out.println("4.선수삭제");
			System.out.println("5.선수검색");
			System.out.println("6.게임시작");
			System.out.println("9.게임종료");
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				list();
				break;
			case 4:
				delete();
				break;
			case 5:
				search();
				break;
			case 6:
				startGame();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요.");
			}
		}
	}
	
	public void insert() {
		System.out.println("===========선수등록==========");
		System.out.print("선수이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("왼손/오른손 입력 : ");
		String hand = sc.nextLine();
		
		System.out.print("선수나이 입력 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		Baseball b = new Baseball(name, hand, age);
		if(tc.insert(b)) {
			System.out.println("선수 등록 완료");
		} else {
			System.out.println("선수 등록 실패");
		}
	}
	
	public void update() {
		System.out.println("===========선수수정===========");
		int i = 0;
		while(i < 3) {
			System.out.print("수정할 선수 입력 : ");
			String updateName = sc.nextLine();
			
			Baseball serachBaseball = tc.serachBaseballByName(updateName);
			if (serachBaseball == null) {
				System.out.println("해당 선수의 이름이 존재하지 않습니다.");
				i++;
				continue;
			}
			
			System.out.print("수정할 선수이름 입력 : ");
			String name = sc.nextLine();
			
			System.out.print("수정할 왼손/오른손 입력 : ");
			String hand = sc.nextLine();
			
			System.out.print("수정할 선수나이 입력 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			Baseball newBaseball = new Baseball(name, hand, age);
			if(tc.update(serachBaseball, newBaseball)) {
				System.out.println("선수 수정 성공");
			} else {
				System.out.println("책 수정 실패");
			}
			return;
		}
	}
	
	public void list() {
		System.out.println("==========선수목록==========");
		for (Baseball player : tc.getAllPlayers()) {
			System.out.println(player);
		}
	}
	
	public void delete() {
		this.list();
		
		System.out.print("삭제할 선수 입력 : ");
		String name = sc.nextLine();
		
		Baseball b = tc.serachBaseballByName(name);
		
		if(b == null) {
			System.out.println("입력한 선수를 찾을 수 없습니다.");
			return;
		}
		
		if(tc.delete(b)) {
			System.out.println("정상적으로 삭제하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
	
	public void search() {
		System.out.println("==========선수검색==========");
		System.out.print("검색할 선수 이름 입력 : ");
		String name = sc.nextLine();
		
		Baseball player = tc.findPlayer(name);
	      if (player != null) {
	          System.out.println("선수 정보: " + player);
	      } else {
	          System.out.println("선수를 찾을 수 없습니다.");
	      }
	}
	
	private void startGame() {
		System.out.println("==========게임시작==========");
		
		Random random = new Random();
		String[] options = {"좌", "우", "중앙"};
		
		while (true) {
            // 사용자의 선택 입력
            System.out.print("좌, 우, 중앙 중 선택: ");
            String userChoice = sc.nextLine();

            // 유효성 검사
            boolean isValidChoice = false;
            for (String option : options) {
                if (userChoice.equals(option)) {
                    isValidChoice = true;
                    break;
                }
            }

            if (!isValidChoice) {
                System.out.println("잘못된 입력입니다. 좌, 우, 중앙 중에서 선택해 주세요.");
                continue;
            }

            // 게임 결과 결정
            int outcome = random.nextInt(100); // 0부터 99까지의 난수 생성

            if (outcome < 40) { // 40% 확률로 아웃
                System.out.println("결과: 아웃");
                System.out.println("게임 종료");
                break; // 게임 종료
            } else if (outcome < 10) { // 10% 확률로 홈런
                System.out.println("결과: 홈런");
            } else { // 나머지 확률로 안타
                System.out.println("결과: 안타");
            }
        }
    }
}