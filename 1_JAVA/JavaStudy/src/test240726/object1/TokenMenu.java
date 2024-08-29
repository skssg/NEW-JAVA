package test240726.object1;

import java.util.Scanner;


public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	
	public void mainMenu() {
//		1. 지정 문자열 ➔ tokenMenu()
//		2. 입력 문자열 ➔ inputMenu()
//		3. 프로그램 끝내기 ➔ “프로그램을 종료합니다” 출력 후 종료
//		잘못 입력했을 시 “잘못 입력하셨습니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.tokenMenu();
				break;
			case 2:
				this.inputMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
		public void tokenMenu(){
//		TokenController(tc)의 afterToken()의 반환 값을 가지고
//		토큰 처리 후 글자, 토큰 처리 후 개수, 모두 대문자로 변환 한 것을 출력
		String str = "J a v a P r o g r a m ";
//		토큰 처리 전 글자, 토큰 처리 전 개수를 출력
		System.out.println("토큰 처리 전 글자 : " + str);
		System.out.println("토큰 처리 전 개수 : " + str.length());
		String newStr = tc.afterToken(str);
		System.out.println("토큰 처리 후 글자 : " + newStr);
		System.out.println("토큰 처리 후 개수 : " + newStr.length());
		System.out.println("모두 대문자로 변환 : " + newStr.toUpperCase());
		}
		
		public void inputMenu(){
			System.out.print("문자열을 입력하세요 : ");
			String str = sc.nextLine();
			String firstCapStr = tc.firstCap(str);
			System.out.println("첫 글자 대문자 : " + firstCapStr);
			
			System.out.print("찾을 문자 하나를 입력하세요 : ");
			char target = sc.next().charAt(0);
			int count = tc.findChar(str, target);
			
			System.out.println(target + "문자가 들어간 개수 : " + count);
//		// tc에 firstCap()로 입력 받은 문자열을 넘기고 반환 값 출력
//		찾을 문자를 하나 입력하세요 :
//		// tc에 findChar()로 위에 입력 받은 문자열과 방금 받은 문자를 인자로 넘겨
//		// 반환 값 출력
		}
		
}
