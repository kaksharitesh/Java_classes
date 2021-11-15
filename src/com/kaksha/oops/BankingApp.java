package com.kaksha.oops;

public class BankingApp implements Runnable{

	public static void main(String[] args) {
		Thread t1 = new Thread(new BankingApp());
		t1.start();
		new Thread(new BankingApp()).start();
		new Thread(new BankingApp()).start();
		new Thread(new BankingApp()).start();
		new Thread(new BankingApp()).start();
		new Thread(new BankingApp()).start();
		new Thread(new BankingApp()).start();

		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " final balance = " + AccountService.balance);

	}

	@Override
	public void run() {
		AccountService a1 = new AccountService();
		System.out.println(Thread.currentThread().getName() + " previous balance = " + a1.balance);
		a1.deposite(10);
		System.out.println(Thread.currentThread().getName() + " new balance = " + a1.balance);

	}

}
