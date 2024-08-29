package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.vo.Game;

public class GameController {
	private int num;
	private String str;
	private List<Game> gameList = new ArrayList<>();
	
	public GameController() {
		super();
		gameList.add(new Game("user01", "pass01", "이명건", 25));
	}
	
	public boolean insertMember(Game g) {
		return gameList.add(g);
	}
	
	public Game loginMember(String id, String pwd) {
		for(Game g : gameList) {
			if (g.getUserId().equals(id) && g.getUserPwd().equals(pwd)) {
				return g;
			}
		}
		
		return null;
	}
}
