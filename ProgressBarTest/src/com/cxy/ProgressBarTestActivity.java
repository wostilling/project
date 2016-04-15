package com.cxy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ProgressBarTestActivity extends Activity {
    /** Called when the activity is first created. */
	ProgressBar bar;
	TextView a;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bar=(ProgressBar)this.findViewById(R.id.bar);
        a=(TextView)this.findViewById(R.id.text);
             
        handler.post(updateThread);
    }
    
    Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			bar.setProgress(msg.arg1);
			a.setText("当前的进度值为: "+msg.arg1);
			handler.post(updateThread);
		}
    	
    };
    
    Runnable updateThread=new Runnable(){
        int i=0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			i=i+10;
			Message msg=handler.obtainMessage();
			msg.arg1=i;
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(i<=100){
			//	a.setText("当前的进度值为: "+msg.arg1);
				handler.sendMessage(msg);
			}else{
				handler.removeCallbacks(updateThread);
			}
		} 	
    };   
}