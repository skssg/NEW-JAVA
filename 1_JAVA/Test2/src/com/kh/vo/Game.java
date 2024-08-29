package com.kh.vo;

public class Game {
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	
	public Game() {
		super();
	}

	public Game(String userId, String userPwd, String userName, int age) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Game [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", age=" + age + "]";
	}


	
	
	
}
