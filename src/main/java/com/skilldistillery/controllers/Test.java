package com.skilldistillery.controllers;

public class Test {

	public static void main(String[] args) {

		Test t = new Test();
//		System.out.println();
//		System.out.println(t.doubleX("axxbb"));
//		System.out.println(t.doubleX("axaxax"));
//		System.out.println(t.doubleX("xxxxx"));
		System.out.println(t.doubleX("xx"));
//		System.out.println(t.doubleX(""));
//		System.out.println("xx".substring(0, 2));
		// doubleX("axxbb") → true
		// doubleX("axaxax") → false
		// doubleX("xxxxx") → true
	}

	boolean doubleX(String str) {

		if (str.length() < 2) { return false; }
		
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == 'x' && str.charAt(i + 1) != 'x') {
				return false;
			}
			if (str.substring(i, i + 2).equals("xx")) {
				return true;
			}
			
		}
		int j = 0;
		if (str.substring(j, j + 2).equals("xx")) {
			return true;
		}
		return false;
	}
}
