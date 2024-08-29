package test240715.object3;

public class Circle extends Point {
	private int radius;

	public Circle() { // 기본생성자
		super();
	}

	public Circle(int x, int y, int radius) { // 매개변수 생성자
		super(x,y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() { // 필드에 담긴 데이터를 반환하는 메소드
		return null;
	}
}
