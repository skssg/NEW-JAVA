package test240711.object4;

public class Student {
	private String name; // 이름
	private String subject; //과목
	private int score; // 점수
	
	public Student() { // 기본 생성자
		super();
	}

	public Student(String name, String subject, int score) { // 3개의 초기값을 받는 생성자
		super();
		this.name = name;
		this.subject = subject;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String inform() { // Student 클래스의 모든 필드 값들을 합쳐 반환
//		return "이름 : " + this.name + " 과목 : " + this.subject + "점수 : " + this.score;
		return "이름 : " +this.name + " / 과목 : " + this.subject + " / 점수 : " + this.score;
	}
	
}
