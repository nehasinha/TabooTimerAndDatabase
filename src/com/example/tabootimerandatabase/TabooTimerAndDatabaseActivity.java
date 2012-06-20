//*************** REFERENCE FOR TIMER ***********************
//http://stackoverflow.com/questions/4873930/updating-android-textview-regularly-to-show-countdown

package com.example.tabootimerandatabase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;
import android.os.CountDownTimer;

public class TabooTimerAndDatabaseActivity extends Activity {
	TextView tv;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        setContentView(tv);
        MyCount counter = new MyCount(60000,1000);
        counter.start();
    }
    
    public class MyCount extends CountDownTimer {
    	public MyCount(long millisInFuture, long countDownInterval) {
    		super(millisInFuture, countDownInterval);
    	}
    	
        @Override
        public void onTick(long millisUntilFinished) {
             tv.setText("Left: " + millisUntilFinished / 1000);
        }
    	 
        @Override
        public void onFinish() {
        	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        	v.vibrate(300);
            tv.setText("done!");
        }
        
        
    }
    
}