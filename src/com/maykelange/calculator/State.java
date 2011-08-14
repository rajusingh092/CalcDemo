package com.maykelange.calculator;

public class State {
	
	public enum Operation {
		NONE,
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE,		
	}
	private double accu = 0;
	private double current = 0;
	private boolean displayAccu = false;
	private int negPowTen;
	
	private Operation currentOp = Operation.PLUS;
	
	public Operation getCurrentOp() {
		return currentOp;
	}
	public void setCurrentOp(Operation currentOp) {
		this.currentOp = currentOp;
		calculateResult();
	}

	private void calculateResult() {
		switch (currentOp) {
			case PLUS:
				accu+=current;
				break;
			case MINUS:
				accu-=current;
				break;
			case MULTIPLY:
				accu*=current;
				break;
			case DIVIDE:
				accu/=current;
				break;
			default:
				break;
		}
		displayAccu = true;
		current = 0;

	}
	
	
	public void number(int number) {
		displayAccu = false;
		if(currentOp == Operation.NONE){
			accu=0;
		}
		
		current*=10;
		current+=number;
	}
	public String getDisplay() {
		String res = String.valueOf(current);
		if(displayAccu){
			res = String.valueOf(accu);
		}
		return res;
	}
	public void clear() {
		accu = 0;
		current = 0;
		currentOp = Operation.PLUS;
		
	}

}
