package test240715.object2;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("상품명 : ");
		String name = sc.nextLine();
		
		System.out.print("가격 : ");
		int Price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수량 : ");
		int Quantity = sc.nextInt();
		sc.nextLine();
		
		Product p = new Product(name, Price, Quantity);
		
		System.out.println("총 구매 가격 : " + (p.getPrice() * p.getQuantity()) + " 원");
	}

}