package com.atm.design;

public class Rupees1000Dispenser implements DispenseChain {
	
	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 1000){
			int num = cur.getAmount()/1000;
			int remainder = cur.getAmount() % 1000;
			System.out.println("Dispensing "+num+" 1000 note");
			if(remainder !=0) 
			{
				this.chain.dispense(new Currency(remainder));
				System.out.println("Ending If of 1000");
			}
		}else{
			System.out.println("In else of 1000");
			this.chain.dispense(cur);
		}
	}

}
