package com.atm.design;

public class Rupees500Dispenser implements DispenseChain{
	
	
private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 500){
			int num = cur.getAmount()/500;
			int remainder = cur.getAmount() % 500;
			System.out.println("Dispensing "+num+" 500 note");
			if(remainder !=0) 
			{
				this.chain.dispense(new Currency(remainder));
				System.out.println("Ending If of 500");
			}
		}else{
			System.out.println("In else of 500");
			this.chain.dispense(cur);
		}
	}

}
