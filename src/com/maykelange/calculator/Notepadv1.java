/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maykelange.calculator;


import com.maykelange.calculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Notepadv1 extends Activity {
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
