package com.cxy.suan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SuanActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private Button btn;
	private TextView operator,correct,number;
	private EditText answer;
    private int total=30;
    private int correctnumber=0;
	private Output out=new Output();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn=(Button)this.findViewById(R.id.tijiao);
        operator=(TextView)this.findViewById(R.id.suan);
        number=(TextView)this.findViewById(R.id.count);
        correct=(TextView)this.findViewById(R.id.zquelv);
        
        
        answer=(EditText)this.findViewById(R.id.answer);
      
        operator.setText(out.getString());
        
        btn.setOnClickListener(this);
			
		
        
        
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
	if(this.total>0){
		this.operator.setText(out.getString());
		if(out.panduan(answer.getText().toString())){
			this.correctnumber++;
			this.total--;		
			Toast.makeText(this, "回答正确", Toast.LENGTH_LONG);
					
		}else{
			this.total--;
			Toast.makeText(this, "回答错误", Toast.LENGTH_LONG);
		}
		this.correct.setText(new java.text.DecimalFormat("00%").format(((this.correctnumber*1.0)/(30-this.total))));
		this.number.setText(total+"");
		this.out=new Output();
		this.operator.setText(out.getString());
		this.answer.setText("");
	}else{
		this.finish();
	}
	if(this.total==0){
		this.btn.setText("退出");
	}
	}
    
    
}