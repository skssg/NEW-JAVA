package test01.t240704;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		/*
		   사용자로부터 입력 받은 숫자의단을 출력하세요.
		   
		   ex.
		   숫자 : 4
		   ===== 4단 =====
		   4 * 1 = 4
		   4 * 2 = 8
		   4 * 3 = 12
		   4 * 4 = 16
		   4 * 5 = 20
		   4 * 6 = 24
		   4 * 7 = 28
		   4 * 8 = 32
		   4 * 9 = 36
		 */
//		Scanner sc = new Scanner(System.in);
//		
//		int dan;
//		System.out.print("숫자 : ");
//		dan= sc.nextInt();
//		
//		System.out.println("==== " + dan + "단 =====");
//		for(int i = 1; i <10; i++) {
//			System.out.println(dan + " * " + i + " = " + (dan * i));
			
		/*
			사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
			단, 9를 초과하는 숫자가 들어오면 "9 이하의 숫자만 입력해주세요"를 출력하세요.
			
			숫자 : 4					숫자 : 10
			===== 4단 =====				9이하의 숫자만 입력해주세요.
			===== 5단 =====
			===== 6단 =====
			===== 7단 =====
			===== 8단 =====
			===== 9단 =====
			(해당 단의 내용들은 길이 상 생략)
		 */
		Scanner sc = new Scanner(System.in);
			
		int dan;
		System.out.print("숫자 : ");
		dan= sc.nextInt();
		
		if (dan <= 9) {
			
			for(int j = dan; j <= 9; j++) {
				
				System.out.println("==== " + j + "단 =====");
				for(int i = 1; i < 10; i++) {
					System.out.println(j + " * " + i + " = " + (j * i));
				}
			}
		} else {
			System.out.println("9이하의 수를 입력하세요.");
		}
		
	}
}
