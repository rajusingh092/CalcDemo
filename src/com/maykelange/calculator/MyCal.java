package com.maykelange.calculator;


import com.maykelange.calculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyCal extends Activity {
	State s;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.calc_layout);
        s = new State();
        
        int[] opNumbers = new int[] { 
        		R.id.Button_0,
        		R.id.Button_1,
        		R.id.Button_2,
        		R.id.Button_3,
        		R.id.Button_4,
        		R.id.Button_5,
        		R.id.Button_6,
        		R.id.Button_7,
        		R.id.Button_8,
        		R.id.Button_9,        		
        };
        
        final TextView textView = (TextView) findViewById(R.id.TextView01);
        for (int i = 0; i < 10;i++){
        	final Button button = (Button) findViewById(opNumbers[i]);        
        	button.setOnClickListener(new NumberClickEvent(textView,s,i));        	
        }
        
		int[] opButtons = new int[] { R.id.Button_plus, R.id.Button_minus,
				R.id.Button_multiply, R.id.Button_divide };
		State.Operation[] states = new State.Operation[] {
				State.Operation.PLUS, State.Operation.MINUS,
				State.Operation.MULTIPLY, State.Operation.DIVIDE};
		
		for(int i = 0; i < opButtons.length;i++){
			Button b_op = (Button) findViewById(opButtons[i]);
			b_op.setOnClickListener(new OperationClickEvent(textView, s, states[i]));
		}
		Button b_eq = (Button) findViewById(R.id.Button_equals);
		b_eq.setOnClickListener(new EqualClickEvent(textView, s));
		
		Button b_op = (Button) findViewById(R.id.Button_ac);
		b_op.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				s.clear();
				textView.setText(s.getDisplay());
			}
		});
        
		textView.setText(s.getDisplay());
    }

}
