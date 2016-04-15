package com.cxy.suan;

import java.util.Random;

public class Output {
    private int a, b;
    private int i;
    private String operator[]={"+","-","×","÷"};
    
    public Output(){
      while(true){
    	a=new Random().nextInt(100);
    	b=new Random().nextInt(100);
    	i=new Random().nextInt(4);
    	
    	if(i==1&&a<b){       
    		continue;
    	}
    	
    	if(i==3){             
    		if(b==0){
    			continue;
    		}
    		if(a%b!=0){      
    			continue;
    		}
    	}
    	break;   	
      }
      
    }
    
    
    public String getString(){
       return new String(a+operator[i]+b+"=");
    }
    
    
    
    public  boolean panduan(String s){
    	int i,result = 0;
    	try{
    		i=Integer.valueOf(s).intValue();
    	}catch(Exception e){
    		return false;
    	}
    	switch(this.operator().toCharArray()[0]){
    	   case '+':result=this.getA()+this.getB();break;
    	   case '-':result=this.getA()-this.getB();break;
    	   case '×':result=this.getA()*this.getB();break;
    	   case '÷':result=this.getA()/this.getB();break;
    	}
    	if(result==i){
    		return true;
    	}return false;
    	
    }
    
    
    public String operator(){
    	return operator[this.i];
    }
    
    
	public int getA() {
		return a;
	}


	public int getB() {
		return b;
	}
    
}