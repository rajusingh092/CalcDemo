package com.maykelange.calculator;

public class State {
	
	public enum Operation {
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE,		
	}
	
	public enum IOState{
		INPUTTING,
		DISPLAY_RESULT,
	}
	private Double accu = null;
	private double current = 0;
	
	private Operation currentOp = null;
	private IOState currentState = IOState.INPUTTING;
	
	public Operation getCurrentOp() {
		return currentOp;
	}
	public void setCurrentOp(Operation currentOp) {

		if (accu != null && this.currentOp != null ){
			calculateResult();
		}else{
			accu = Double.valueOf(current);
			current = 0;
		}
		this.currentOp = currentOp;
		
		if (currentState == IOState.INPUTTING){
			currentState = IOState.DISPLAY_RESULT;
		}
	}

	private void calculateResult() {
		double res = accu.doubleValue();
		switch (currentOp) {
			case PLUS:
				res += current;
				break;
			case MINUS:
				res -= current;
				break;
			case MULTIPLY:
				res *= current;
				break;
			case DIVIDE:
				res /= current;
				break;
		}
		accu = Double.valueOf(res);
		current = 0;
	}
	
	
	public void number(int number) {
		if (currentState == IOState.INPUTTING){
			current = current *10 + number;
		}else if(currentState == IOState.DISPLAY_RESULT){
			currentState = IOState.INPUTTING;
			current = number;
		}
	}
	public String getDisplay() {
		String res;
		Double d = getCurrentDisplayValue();
		double doubleValue = d.doubleValue();
		int intVal = (int)doubleValue;
		if (intVal == doubleValue){
			res = Integer.toString(intVal);
			
		}else{
			res = d.toString();
		}
//		String res = currentState + " - " + currentOp +" - "+ accu + " - " + current + " - " + d;
		
		return res;
	}
	private Double getCurrentDisplayValue() {
		Double d = accu;
		if (currentState == IOState.INPUTTING){
			d = Double.valueOf(current);
		}
		return d;
	}
	public void clear() {
		accu = null;
		currentState = IOState.INPUTTING;
		currentOp = null;
		current = 0;
		
	}
	public void equal() {
		if (accu == null || currentOp == null){
			return;
		}
		calculateResult();
		currentState = IOState.DISPLAY_RESULT;
		currentOp = null;
		current = getCurrentDisplayValue();
		
	}

}
