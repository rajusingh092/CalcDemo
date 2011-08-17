package com.maykelange.calculator;

public class State {
	
	public enum Operation {
		NONE,
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE,		
	}
	
	public enum IOState{
		INPUT_CURRENT,
		INPUT_ACCU,
		DISPLAY_RESULT,
	}
	private double accu = 0;
	private double current = 0;
	private boolean inputted = false;
	
	private int negPowTen;
	
	private Operation currentOp = Operation.NONE;
	private IOState currentState  = IOState.INPUT_ACCU;
	
	
	public Operation getCurrentOp() {
		return currentOp;
	}
	public void setCurrentOp(Operation currentOp) {
		if(!inputted){
			return;
		}
		if(this.currentOp != Operation.NONE){
			calculateResult();
		}
		this.currentOp = currentOp;
		currentState = IOState.DISPLAY_RESULT;
		inputted = false;
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
		
		if(currentState == IOState.INPUT_CURRENT ){
			currentState = IOState.DISPLAY_RESULT;
		}
		
		current = 0;

	}
	
	
	public void number(int number) {
		if(currentState == IOState.DISPLAY_RESULT){
			currentState = IOState.INPUT_CURRENT;
		}
		inputted = true;
		double num;
		
		if(currentState == IOState.INPUT_ACCU){
			num = accu;
		}else{
			num = current;
		}
		
		num*=10;
		num+=number;
		
		if(currentState == IOState.INPUT_ACCU){
			accu = num;
		}else{
			current = num;
		}
	}
	public String getDisplay() {
		String res = String.valueOf(current);
		if(currentState == IOState.DISPLAY_RESULT || currentState == IOState.INPUT_ACCU){
			res = String.valueOf(accu);
		}
		return res;
	}
	public void clear() {
		accu = 0;
		current = 0;
		currentOp = Operation.NONE;
		currentState = IOState.INPUT_ACCU;
		
	}
	public void equal() {
		calculateResult();
		currentOp = Operation.NONE;
		currentState= IOState.INPUT_ACCU;
		current = 0;
	}

}
