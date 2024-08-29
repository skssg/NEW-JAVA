package com.kh.view;

import java.util.Scanner;

import com.kh.controller.GameController;
import com.kh.controller.StartController;
import com.kh.vo.Game;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private GameController gc = new GameController();
	private StartController tc = new StartController();

	public void menu() {
		
		while(true) {
			System.out.println("==========야구게임==========");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디찾기");
			System.out.println("4. 비밀번화찾기");
			System.out.println("9. 프로그램종료");
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				loginMember();
				break;
			case 2:
				insertMember();
				break;
			case 3:
			case 4:
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
		}
	}
	
	public void insertMember() {
		System.out.println("==========회원가입==========");
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		Game g = new Game(id, pwd, name, age);
		if(gc.insertMember(g)) {
			System.out.println("회원가입에 성공하였습니다.");
		} else {
			System.out.println("회원가입에 실패하였습니다.");
		}
	}
	
	public void loginMember() {
		System.out.println("=========== 로그인 ==========");
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.nextLine();
		
		Game loginMember = gc.loginMember(id, pwd);
		if(loginMember == null) {
			System.out.println("로그인에 실패하였습니다. id, pwd를 다시 확인하세요.");
		} else {
			System.out.println("로그인에 성공하였습니다.");
			System.out.println(loginMember.getUserName() + "님 반갑습니다.");
			
			this.loginMenu(loginMember);
		}
	}
	
	public void loginMenu(Game loginMember) {
		
		while(true) {
			System.out.println("===============메뉴선택=================");
			System.out.println("1. 게임메뉴로");
			System.out.println("2. 게임방법");
			System.out.println("9. 로그아웃");
	
			System.out.print("메뉴 입력 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				new PlayMenu(loginMember, tc, sc).menu();
				break;
			case 2:
				this.description();
				break;
			case 9:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다. 다시입력해주세요");
			}
		}
	}
	
	public void description() {
		System.out.println("==========게임 방법==========");
		System.out.println("게임시작인 1을 눌러줍니다.");
		System.out.println("1을 누르게 되면 게임시작 메뉴가 나오게 됩니다.");
		System.out.println("게임시작 메뉴가 나오면 선수 등록을 해줍니다.");
		System.out.println("선수등록을 해준 후 경기시작인 6을 눌러줍니다.");
		System.out.println("선수를 선택해줍니다.");
		System.out.println("게임이 시작되면 좌,우,중앙을 적어줍니다.");
		System.out.println("안타가 나오면 계속하시고 아웃이 되면 자동으로 종료됩니다.");
	}
}
