package com.atm.design;

public class Rupees2000Dispenser implements DispenseChain{
	
	private DispenseChain chain;
	
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 2000){
			int num = cur.getAmount()/2000;
			int remainder = cur.getAmount() % 2000;
			System.out.println("Dispensing "+num+" 2000 note");
			if(remainder !=0) 
			{
				this.chain.dispense(new Currency(remainder));
				System.out.println("Ending If of 2000");
			}
		}else{
			System.out.println("In else of 2000");
			this.chain.dispense(cur);
		}
	}

}
