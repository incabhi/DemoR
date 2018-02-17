package com.atm.design;

import java.util.Scanner;

public class ATMDispenseChain {
	
	private DispenseChain c1;
	
	
	public ATMDispenseChain() {
		
		
		this.c1 = new Rupees2000Dispenser();
		
		DispenseChain c2 = new Rupees1000Dispenser();
		
		DispenseChain c3 = new Rupees500Dispenser();
		
		DispenseChain c4 = new Rupees100Dispenser();
		
		System.out.println("Starting Dispensing 1000");
		c1.setNextChain(c2);
		System.out.println("Starting dispensing 500");
		c2.setNextChain(c3);
		System.out.println("Staring dispensing 100");
		c3.setNextChain(c4);
	}
		@SuppressWarnings("resource")
		public static void main(String[] args) {
			ATMDispenseChain atmDispenser = new ATMDispenseChain();
			while (true) {
				int amount = 0;
				System.out.println("Enter amount to dispense");
				Scanner input = new Scanner(System.in);
				amount = input.nextInt();
				if (amount % 100 != 0) {
					System.out.println("Amount should be in multiple of 100s.");
					return;
				}
				// process the request
				atmDispenser.c1.dispense(new Currency(amount));
			}

		}
		
		
	}
	


