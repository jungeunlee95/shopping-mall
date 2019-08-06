package com.cafe24.shoppingmall.frontend.vo;

public enum PasswordQuestion {

    TREASURE("가장 아끼는 보물 1호는?", 1), 
	DOGNAME("강아지 이름은?", 2), 
	LIKEBOOK("가장 좋아하는 책은?", 3);
	
	final private String name;
	final private int no;
	
	private PasswordQuestion(String name, int no) {
		this.name = name;
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public int getNo() {
		return no;
	}
}
