package com.kaksha.oops;

public class AccountService{
	
	public static int balance = 10;
	
	public static void deposite(int amount) {
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		int x = balance;  //t1
		x += amount;
		balance = x;      //t2
		
	}

}
