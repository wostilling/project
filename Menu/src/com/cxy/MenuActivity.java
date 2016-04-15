package com.cxy;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends Activity {	
	TextView label=null;
	final static int MENU_DOWNLOAD=Menu.FIRST;
	final static int MENU_UPLOAD=Menu.FIRST+1;
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
		
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	static int dcount=0;
	static int ucount=0;
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case Menu.FIRST+12:dcount++;return true;
			
		case Menu.FIRST+10:ucount++;return true;
		
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem umenuitem=menu.findItem(Menu.FIRST+10);
		umenuitem.setTitle("上传参数A "+String.valueOf(ucount));
		
		MenuItem dmenuitem=menu.findItem(Menu.FIRST+12);
		dmenuitem.setTitle("上传参数B "+String.valueOf(dcount));
		
		
		return true;
	}


    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
    	menu.add(0, MENU_DOWNLOAD, 0, "下载设置").setIcon(R.drawable.download).setShortcut('0', 'd');

 	
    	SubMenu upload=(SubMenu)menu.addSubMenu(0, MENU_UPLOAD, 1, "上传设置").setIcon(R.drawable.upload);
    	upload.setHeaderIcon(R.drawable.upload);
    	upload.setHeaderTitle("上传参数");
    	upload.add(0,Menu.FIRST+10, 0, "上传参数A");
    	upload.add(0, Menu.FIRST+12, 0, "上传参数B");
    	
        for(int i=2;i<=9;i++){
    		menu.add(0, Menu.FIRST+i-1, i-1,"菜单子项"+i );
    	}
		return true;
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        label=(TextView)this.findViewById(R.id.label);
        registerForContextMenu(label);
        
    }
}