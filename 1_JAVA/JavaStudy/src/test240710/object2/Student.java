package test240710.object2;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double heigt;
	private char gender;
	
	public Student() {
		super();
	}

	public Student(int grade, int classroom, String name, double heigt, char gender) {
		super();
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
		this.heigt = heigt;
		this.gender = gender;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeigt() {
		return heigt;
	}

	public void setHeigt(double heigt) {
		this.heigt = heigt;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void information() {
		System.out.println("이름 : " + this.name);
		System.out.println("등급 : " + this.grade);
		System.out.println("반 : " + this.classroom);
		System.out.println("키 : " + this.heigt);
		System.out.println("성별 : " + this.gender);
	}
	
}
