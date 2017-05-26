package com.skilldistillery.controllers;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();

		System.out.println(t.stringSplosion("ab"));
//		desired result CCoCodCode
	}

	public String stringSplosion(String str) {
		String result = "";
		for(int i = 0; i <= str.length(); i++) {
			result += str.substring(0, i);
			
		}
		
		return result;
	}
}
