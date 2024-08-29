package test240731.object1;

import java.util.Scanner;

// View : 사용자에게 보여지는 시각적인 요소(출력문, 입력문)
public class FarmMenu {
	Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("3. 종료");
			System.out.print("메뉴 번호 선택 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.adminMenu();
				break;
			case 2:
				this.customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.addNewKind();;
				break;
			case 2:
				this.removeKind();
				break;
			case 3:
				this.changeAmount();
				break;
			case 4:
				this.printFarm();;
				break;
			case 9:
				this.mainMenu();
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void customerMenu() {
		
	}
	
	public void addNewKind() {
		// ‘1. 과일 / 2. 채소 / 3. 견과’를 통해 번호로 종류를 받고 추가 농산물의 이름, 수량도 받음.
		while(true) { 
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			
			int type = sc.nextInt();
			sc.nextLine();
			
			// 이때 없는 번호를 선택하면 “잘못 입력하셨습니다. 다시 입력해주세요.”가
			// 출력되며 다시 번호를 받고, 선택한 종류에 따라 생성되는 객체가 다름.
			if(type != 1 && type != 2 && type != 3) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue; // 잘못입력하셨습니다가 계속 반복되기 떄문에 continue를 넣어준다.
			}
			
			System.out.println("이름 : ");
			String name = sc.nextLine();
			
			System.out.println("수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			
			Farm newItem = null;
			
			switch(type) {
			case 1:
				newItem = new Fruit("과일", name);
				break;
			case 2:
				newItem = new Vegetable("채소", name);
				break;
			case 3:
				newItem = new Nut("견과", name);
				break;
			}
			
			if(fc.addNewKind(newItem, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			} else {
				System.out.println("새 농산물 추가에 실해하였습니다. 다시 입력해주세요.");
			}
		}	
//		객체 안에 종류와 이름을 저장. 데이터를 저장한 객체와 수량을 fc(FarmController)의
//		addNewKind()로 넘기고 전달 받은 반환 값이 true면 “새 농산물이 추가되었습니다.”,
//		false면 “새 농산물 추가에 실패하였습니다. 다시 입력해주세요.” 출력

	}
	
	public void removeKind() {
		// ‘1. 과일 / 2. 채소 / 3. 견과’를 통해 번호로 종류를 받고 삭제할 농산물의 이름도 받음. 
		
		//이때 없는 번호를 선택하면 “잘못 입력하셨습니다. 다시 입력해주세요.”가
		// 출력되며 다시 번호를 받고, 
		
		// 선택한 종류에 따라 생성되는 객체가 다름.
		
		// 객체 안에 종류와 이름을 저장. 
		
		// 데이터를 저장한 객체를 fc의 removeKind()로 넘기고
		// 전달받은 반환 값이 true면 “농산물 삭제에 성공하였습니다.”,
		// false면 “새 농산물 추가에 실패하였습니다. 다시 입력해주세요.” 출력

	}
	
	public void changeAmount() {
		
	}
	
	public void printFarm() {
		
	}
	
	public void buyFarm() {
		
	}
	
	public void removeFarm() {
		
	}
	
	public void printBuyFarm() {
			
	}
}
