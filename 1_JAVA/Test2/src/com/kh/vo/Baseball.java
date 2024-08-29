package com.kh.vo;

public class Baseball {
	private String name;
	private String hand;
	private int age;
	
	public Baseball() {
		super();
	}

	public Baseball(String name, String hand, int age) {
		super();
		this.name = name;
		this.hand = hand;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Baseball [name=" + name + ", hand=" + hand + ", age=" + age + "]";
	}
	
}
