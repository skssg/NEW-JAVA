package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.vo.Baseball;

public class StartController {
	private List<Baseball> baseballList = new ArrayList<>();

	public boolean insert(Baseball b) {
		return baseballList.add(b);
	}
	
	public Baseball serachBaseballByName(String name) {
		for(Baseball b : baseballList) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		
		return null;
	}
	
	public boolean update(Baseball oldBaseball, Baseball newBaseball) {
		int i = baseballList.indexOf(oldBaseball);
		Baseball b = baseballList.set(i, newBaseball);
		return b != null;
	}
	
	public List<Baseball> getAllPlayers() {
		return new ArrayList<>(baseballList);
	}
	
	public boolean delete(Baseball b) {
		return baseballList.remove(b);
	}
	
	public Baseball findPlayer(String name) {
	      for (Baseball player : baseballList) {
	          if (player.getName().equals(name)) {
	              return player; // 선수 찾음
	          }
	      }
	      return null; // 선수 찾지 못함
	  }
}
