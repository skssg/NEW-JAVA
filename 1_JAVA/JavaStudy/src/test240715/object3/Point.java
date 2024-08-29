package test240715.object3;

public class Point {
	private int x;
	private int y;
	
	public Point() { // 기본생성자
		super();
	}

	public Point(int x, int y) { // 매개변수 생성자
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() { 
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() { // 필드에 담긴 데이터를 반환하는 메소드
		return null;
	}
}
