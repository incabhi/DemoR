package com.atm.design;

public class Rupees100Dispenser implements DispenseChain {
	
private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 100){
			int num = cur.getAmount()/100;
			int remainder = cur.getAmount() % 100;
			System.out.println("Dispensing "+num+" 100 note");
			if(remainder !=0) 
			{
				this.chain.dispense(new Currency(remainder));
			
				System.out.println("Ending If of 100");
			}
		}else{
			System.out.println("In else of 100");
			this.chain.dispense(cur);
		}
	}

}
