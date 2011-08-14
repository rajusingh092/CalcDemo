package com.maykelange.calculator;

import com.maykelange.calculator.State.Operation;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

final class OperationClickEvent implements OnClickListener {
	private State s;
	private TextView textView;
	private Operation op;


	public OperationClickEvent(TextView textView, State s, State.Operation op) {
		super();
		this.op = op;
		this.s = s;
		this.textView = textView;
	}


	public void onClick(View v) {
		s.setCurrentOp(op);
		textView.setText(s.getDisplay());
	}
}