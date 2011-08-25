package com.maykelange.calculator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

final class EqualClickEvent implements OnClickListener {
	private State s;
	private TextView textView;


	public EqualClickEvent(TextView textView, State s) {
		super();
		this.s = s;
		this.textView = textView;
	}


	public void onClick(View v) {
		s.equal();
		textView.setText(s.getDisplay());
	}
}