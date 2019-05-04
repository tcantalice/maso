package com.nipsters.commons.io;

import java.util.Scanner;

public class Keyboard {

	private Scanner inputer = new Scanner(System.in);
	private static Keyboard instance;

	private Keyboard(){}

	public static Keyboard getInstance(){
		if(instance == null){
			instance = new Keyboard();
		}
		return instance;
	}

	public String readLine(){
		return this.inputer.nextLine();
	}

	public int readInt(){
		return Integer.parseInt(this.readLine());
	}
}