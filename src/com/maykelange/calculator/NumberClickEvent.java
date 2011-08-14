package com.maykelange.calculator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

final class NumberClickEvent implements OnClickListener {
	private int number; 
	private State s;
	private TextView textView;


	public NumberClickEvent(TextView textView, State s, int number) {
		super();
		this.number = number;
		this.s = s;
		this.textView = textView;
	}


	public void onClick(View v) {
		s.number(number);
		textView.setText(s.getDisplay());
	}
}