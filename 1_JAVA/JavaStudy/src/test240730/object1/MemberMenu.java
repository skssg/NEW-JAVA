package test240730.object1;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 ==========");
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.joinMembership();
				break;
			case 2:
				this.logIn();
				break;
			case 3:
				this.sameName();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 번호 선택 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.changePassword();
				break;
			case 2:
				this.changeName();
				break;
			case 3:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void joinMembership() {
		// 회원가입하기 위해 아이디, 비밀번호, 이름을 받고 비밀번호와 이름은
		// Member객체에 담고 id와 객체는 MemberController(mc)의 joinMembership()로 보냄.
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		Member m = new Member(name, password);
		// 받은 결과에 따라 true면 “성공적으로 회원가입 완료하였습니다.”,
		// false면 “중복된 아이디입니다. 다시 입력해주세요.” 출력
		if(mc.joinMembership(id, m)) {
			System.out.println("성공적으로 회원가입 완료하였습니다.");
		} else {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
	}
	
	public void logIn() {
		while(true) {
			// 아이디와 비밀번호를 사용자에게 받아 mc의 logIn()메소드로 넘겨 줌
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			String name = mc.logln(id, password);
			// 반환 값 있으면 “OOO님, 환영합니다!” 출력 후 로그인 된 화면으로(memberMenu()),
			// 없으면 “틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.” 출력 후 반복
			if(name != null) {
				System.out.println(name + "님, 환영합니다!");
				return;
			} else {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void changePassword() {
		// 아이디와 비밀번호, 변경할 비밀번호를 받아 mc의 chagePassword()로 보냄.
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("현재 비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("새로운 비밀번호 : ");
		String newPwd = sc.nextLine();
		
		// 받은 결과 값이 true면 “비밀번호 변경에 성공했습니다.”,
		// false면 “비밀번호 변경에 실패했습니다. 다시 입력해주세요.” 출력 후 반복
		if (mc.changePassword(id, password, newPwd)) {
			System.out.println("비밀번호 변경에 성공했습니다.");
		} else {
			System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
		}
	}
	
	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			String name = mc.logln(id, password);
			if(name != null) {
				System.out.println("현재 설정된 이름 : " + name);
				
				System.out.println("변경할 이름 : ");
				String newName = sc.nextLine();
				
				mc.changeName(id, newName);
			} else {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
			}
			// 아이디와 비밀번호를 받아 mc의 logIn()으로 넘겨 현재 저장되어 있는 이름을 받고
			// 사용자에게 현재 저장되어 있는 이름을 출력하여 보여줌.
			// 변경할 이름을 받아 mc의 chageName()로 id와 함께 넘기고
			// “이름 변경에 성공하였습니다.” 출력
			// 만일 logIn()로부터 저장되어 있는 이름을 받지 못 했다면
			// “이름 변경에 실패했습니다. 다시 입력해주세요” 출력 후 반복
		}
	}
	
	public void sameName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		TreeMap result = mc.sameName(name);
		if(result.isEmpty()) {
			System.out.println("회원을 잦지 못하였습니다.");
		} else {
			for(Object entry : result.entrySet()) {
				Entry<String, String> en = (Entry)entry;
				System.out.println(en.getKey() + " : " + en.getValue());
			}
		}
	}
}
