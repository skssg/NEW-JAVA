package test240715.object3;

public class Rectangle extends Point {
	private int width;
	private int height;
	
	public Rectangle() { // 기본 생성자
		super();
	}

	public Rectangle(int x, int y, int width, int height) { // 매개변수 생성자
		super(x,y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() { // 필드에 담긴 데이터를 반환하는 메소드
		return null;
	}
}
